(ns game.core.gaining
  (:require
    [game.core.eid :refer [make-eid effect-completed]]
    [game.core.engine :refer [trigger-event trigger-event-sync]]
    [game.core.toasts :refer [toast]]))

(defn safe-inc-n
  "Helper function to safely update a value by n. Returns a function to use with `update` / `update-in`"
  [n]
  (partial (fnil + 0 0) n))

(defn sub->0
  "Helper function for use in `update` or `update-in` to subtract for a value, to a minimum of 0."
  [n]
  #(max 0 ((fnil - 0 0) % n)))

(defn deduct
  "Deduct the value from the player's attribute."
  [state side [attr value]]
  (cond
    ;; value is a map, should be :base, :mod, etc.
    (map? value)
    (doseq [[subattr value] value]
      (swap! state update-in [side attr subattr] (if (#{:mod :used} subattr)
                                                   ;; Modifications and mu used may be negative
                                                   ;; mu used is for easier implementation of the 0-mu hosting things
                                                   #(- % value)
                                                   (sub->0 value))))

    ;; values that expect map, if passed a number use default subattr of :mod
    (#{:memory} attr)
    (deduct state side [attr {:mod value}])

    ;; default case for tags and bad-publicity is `:base`
    (#{:tag :bad-publicity} attr)
    (deduct state side [attr {:base value}])

    :else
    (do (swap! state update-in [side attr] (if (= attr :agenda-point)
                                             ;; Agenda points may be negative
                                             #(- % value)
                                             (sub->0 value)))
        (when (and (= attr :credit)
                   (= side :runner)
                   (pos? (get-in @state [:runner :run-credit] 0)))
          (swap! state update-in [:runner :run-credit] (sub->0 value))))))

(defn gain [state side & args]
  (doseq [[cost-type amount] (partition 2 args)]
    (cond
      ;; amount is a map, merge-update map
      (map? amount)
      (doseq [[subtype amount] amount]
        (swap! state update-in [side cost-type subtype] (safe-inc-n amount))
        (swap! state update-in [:stats side :gain cost-type subtype] (fnil + 0) amount))

      ;; Default cases for the types that expect a map
      (#{:hand-size :memory} cost-type)
      (gain state side cost-type {:mod amount})

      ;; Default case for tags and bad publicity is `:base`
      (#{:tag :bad-publicity} cost-type)
      (gain state side cost-type {:base amount})

      ;; Else assume amount is a number and try to increment cost-type by it.
      :else
      (do (swap! state update-in [side cost-type] (safe-inc-n amount))
          (swap! state update-in [:stats side :gain cost-type] (fnil + 0 0) amount)))
    (trigger-event state side (if (= side :corp) :corp-gain :runner-gain) [cost-type amount])))

(defn lose [state side & args]
  (doseq [[cost-type amount] (partition 2 args)]
    (if (= amount :all)
      (do (swap! state update-in [:stats side :lose cost-type] (fnil + 0) (get-in @state [side cost-type]))
          (swap! state assoc-in [side cost-type] 0))
      (do (when (number? amount)
            (swap! state update-in [:stats side :lose cost-type] (fnil + 0) amount))
          (deduct state side [cost-type amount])))
    (trigger-event state side (if (= side :corp) :corp-lose :runner-lose) [cost-type amount])))

(defn gain-credits
  "Utility function for triggering events"
  ([state side eid amount] (gain-credits state side eid amount nil))
  ([state side eid amount args]
   (if (and amount
            (pos? amount))
     (do (gain state side :credit amount)
         (trigger-event-sync state side eid (if (= :corp side) :corp-credit-gain :runner-credit-gain) amount args))
     (effect-completed state side eid))))

(defn lose-credits
  "Utility function for triggering events"
  ([state side eid amount] (lose-credits state side eid amount nil))
  ([state side eid amount args]
   (if (and amount
            (or (= :all amount)
                (pos? amount)))
     (do (lose state side :credit amount)
         (when (and (= side :runner)
                    (= :all amount))
           (lose state :runner :run-credit :all))
         (trigger-event-sync state side eid (if (= :corp side) :corp-credit-loss :runner-credit-loss) amount args))
     (effect-completed state side eid))))

;;; Stuff for handling {:base x :mod y} data structures
(defn base-mod-size
  "Returns the value of properties using the `base` and `mod` system"
  [state side prop]
  (let [base (get-in @state [side prop :base] 0)
        mod (get-in @state [side prop :mod] 0)]
    (+ base mod)))

(defn available-mu
  "Returns the available MU the runner has"
  [state]
  (- (base-mod-size state :runner :memory)
     (get-in @state [:runner :memory :used] 0)))

(defn toast-check-mu
  "Check runner has not exceeded, toast if they have"
  [state]
  (when (neg? (available-mu state))
    (toast state :runner "You have exceeded your memory units!")))

(defn free-mu
  "Frees up specified amount of mu (reduces :used)"
  ([state _ n] (free-mu state n))
  ([state n]
   (deduct state :runner [:memory {:used n}])))

(defn use-mu
  "Increases amount of mu used (increased :used)"
  ([state _ n] (use-mu state n))
  ([state n]
   (gain state :runner :memory {:used n})))
(ns game.core.bad-publicity
  (:require
    [game.core.eid :refer [effect-completed make-eid make-result]]
    [game.core.engine :refer [trigger-event trigger-event-sync]]
    [game.core.flags :refer [cards-can-prevent? get-prevent-list]]
    [game.core.gaining :refer [gain lose]]
    [game.core.prompts :refer [clear-wait-prompt show-prompt show-wait-prompt]]
    [game.core.prevention :refer [resolve-bad-pub-prevention]]
    [game.core.say :refer [system-msg]]
    [game.core.toasts :refer [toast]]
    [game.macros :refer [wait-for]]))

(defn- resolve-bad-publicity
  [state side eid n]
  (if (pos? n)
    (do (gain state :corp :bad-publicity n)
        (toast state :corp (str "Took " n " bad publicity!") "info")
        (trigger-event-sync state side (make-result eid n) :corp-gain-bad-publicity {:amount n}))
    (effect-completed state side eid)))

(defn gain-bad-publicity
  "Attempts to give the corp n bad publicity, allowing for boosting/prevention effects."
  ([state side n] (gain-bad-publicity state side (make-eid state) n nil))
  ([state side eid n] (gain-bad-publicity state side eid n nil))
  ([state side eid n {:keys [unpreventable card] :as args}]
   (wait-for (resolve-bad-pub-prevention state side n args)
             (resolve-bad-publicity state side eid (:remaining async-result)))))

(defn lose-bad-publicity
  ([state side n] (lose-bad-publicity state side (make-eid state) n))
  ([state side eid n]
   (if (= n :all)
     (lose-bad-publicity state side eid (get-in @state [:corp :bad-publicity :base]))
     (do (lose state :corp :bad-publicity n)
         (trigger-event-sync state side eid :corp-lose-bad-publicity {:amount n
                                                                      :side side})))))

(ns i18n.ko)

(def translations
  {:missing ":ko 텍스트를 찾을 수 없음"
   :side {:corp "기업"
          :runner "러너"
          :any-side "모든 사이드"
          :all "모두"}
   :faction {:all "모두"
             :any-faction "모든 세력"
             :anarch "아나크"
             :criminal "크리미널"
             :shaper "쉐이퍼"
             :adam "아담"
             :apex "에이펙스"
             :sunny-lebeau "서니 르뷰"
             :jinteki "진테키"
             :haas-bioroid "하스-바이오로이드"
             :nbn "NBN"
             :weyland-consortium "웨이랜드 컨소시엄"
             :neutral "중립"}
   :format {:all "모두"
            :any-format "모든 포맷"
            :standard "스탠다드"
            :eternal "이터널"
            :core-experience "코어 익스피리언스"
            :snapshot "스냅샷"
            :snapshot-plus "스냅샷 플러스"
            :socr "SOCR"
            :sunset "Sunset"
            :neo "Neo"
            :classic "클래식"
            :casual "캐주얼"}
   :card-type {:all "모두"
               :identity "ID"
               :agenda "아젠다"
               :asset "자산"
               :upgrade "개선"
               :operation "운영"
               :ice "아이스"
               :event "이벤트"
               :hardware "하드웨어"
               :resource "리소스"
               :program "프로그램"}
   :pronouns {:none "미정"
              :any "아무렇게나"
              :myodb "부르지 않는걸 선호함"
              :blank "[빈 칸]"
              :they "They/them"
              :she "She/her"
              :shethey "She/they"
              :he "He/him"
              :hethey "He/they"
              :it "It"
              :ne "Ne/nem"
              :ve "Ve/ver"
              :ey "Ey/em"
              :zehir "Ze/hir"
              :zezir "Ze/zir"
              :xe "Xe/xem"}
   :chat {:title "브라우저로 즐기는 안드로이드: 넷러너"
          :channels "채널"
          :send "보내기"
          :placeholder "대화를 나누어 보세요..."
          :delete "메시지 삭제"
          :delete-all "모든 사용자로부터 받은 메시지 삭제"
          :block "사용자 차단"
          :cancel "취소"}
   :nav {:chat "채팅"
         :cards "카드"
         :deck-builder "덱 빌더"
         :play "플레이"
         :help "도움말"
         :settings "설정"
         :stats "기록"
         :about "진테키넷"
         :tournaments "대회"
         :admin "운영자"
         :users "사용자"
         :features "기능"
         :game-count (fn [[cnt]] (str cnt " 게임"))}
   :menu {:settings "설정"
          :logout "잭 아웃"
          :admin "운영자"
          :moderator "중재자"}
   :card-browser {:search-hint "카드 찾기"
                  :sort "정렬 기준"
                  :format "포맷"
                  :set "세트"
                  :side "사이드"
                  :faction "세력"
                  :type "타입"
                  :clear "지우기"
                  :select-art "아트 선택"
                  :selected-art "대체 아트가 선택됨"
                  :update-success "아트가 갱신됨"
                  :update-failure "아트 갱신 실패"
                  :memory "메모리"
                  :cost "비용"
                  :trash-cost "폐기 비용"
                  :strength "힘"
                  :advancement "필요 발전 정도"
                  :agenda-points "아젠다 점수"
                  :min-deck "최소 덱 사이즈"
                  :inf-limit "영향력 제한"
                  :influence "영향력"
                  :sort-by {:faction "세력"
                            :name "이름"
                            :type "타입"
                            :influence "영향력"
                            :cost "비용"
                            :set-number "세트 번호"}}
   :deck-builder {:loading-msg "덱 컬렉션을 불러오는 중"
                  :new-corp "새로운 기업 덱"
                  :new-runner "새로운 러너 덱"
                  :import-button "덱 가져오기"
                  :reset "리셋"
                  :import-title "NetrunnerDB 공개 덱 ID 혹은 URL 입력"
                  :import "가져오기"
                  :cancel "취소"
                  :import-placeholder "NetrunnerDB ID"
                  :deck-count (fn [[cnt]] (str cnt " 덱"))
                  :filtered "(필터됨)"
                  :save "저장"
                  :confirm-delete "삭제 확인"
                  :edit "편집"
                  :delete "삭제"
                  :clear-stats "기록 초기화"
                  :create-game "게임 생성"
                  :deck-name "덱 이름"
                  :format "포맷"
                  :identity "ID"
                  :deck-notes "덱 메모"
                  :decklist "덱 리스트"
                  :decklist-inst "(덱 리스트를 입력하거나 붙여 넣으십시오)"
                  :notes "메모"
                  :add-to-deck "덱에 삽입"
                  :add-cards "카드 삽입"
                  :card-name "카드 이름"
                  :no-decks "덱 없음"
                  :cards "카드"
                  :min "최소"
                  :max "최대"
                  :influence "영향력"
                  :agenda-points "아젠다 점수"
                  :hash "토너먼트 해쉬값"
                  :why "확인하십시오"
                  :legal "사용 가능"
                  :illegal "사용 불가"
                  :games "게임"
                  :completed "완료됨"
                  :won "승리"
                  :lost "패배"}
   :lobby {:no-games "게임 없음"
           :tournament "토너먼트"
           :competitive "경쟁"
           :casual "캐주얼"
           :new-game "새 게임"
           :reload "리스트 갱신"
           :load-replay "리플레이 불러오기"
           :start-replay "리플레이 재생"
           :save-replay "리플레이 저장"
           :replay-link-error "리플레이 링크가 유효하지 않습니다."
           :replay-invalid-file "유효한 리플레이 파일을 선택하십시오."
           :create "생성"
           :cancel "취소"
           :title "방 제목"
           :side "사이드"
           :format "포맷"
           :options "옵션"
           :spectators "관전 허용"
           :hidden "관전자가 플레이어의 숨겨진 정보를 볼 수 있게 하기"
           :password-protected "암호로 보호"
           :password "암호"
           :start "시작"
           :leave "떠나기"
           :swap "사이드 바꾸기"
           :waiting "플레이어가 덱을 고르고 있습니다"
           :players "플레이어"
           :deck-selected "덱 선택됨"
           :select-deck "덱 선택"
           :chat "채팅"
           :select-title "덱을 선택하십시오"
           :spectator-count (fn [[cnt]] (str cnt " 관전자"))
           :closed-msg "활동이 없어 게임 로비가 닫혔습니다."
           :title-error "게임 제목을 입력해주십시오."
           :password-error "암호를 입력해주십시오."
           :too-little-data "데이터가 너무 적음"
           :completion-rate "게임 완료율"
           :watch "관전"
           :join "참여"
           :rejoin "재참여"
           :private "비공개"
           :reset "게임 제목 리셋"
           :delete "게임 삭제"
           :password-for "암호 입력"
           :invalid-password "유효하지 않은 암호"
           :not-allowed "허용되지 않음"
           :game-count (fn [[cnt]] (str cnt " 게임"))
           :aborted "연결에 실패함"}
   :settings {:invalid-password "유효하지 않은 로그인 또는 암호"
              :invalid-email "이 이메일 주소로 등록된 계정이 없습니다"
              :updated "프로필 갱신됨 - 브라우저를 새로고침 하십시오"
              :updating "프로필 갱신중..."
              :get-log-width "현재 로그 너비 입력"
              :get-log-top "현재 로그 높이 입력"
              :email-title "이메일 주소 변경"
              :current-email "현재 이메일"
              :desired-email "사용할 이메일"
              :email-placeholder "이메일 주소"
              :enter-valid "유효한 이메일을 입력하십시오"
              :update "업데이트"
              :cancel "취소"
              :email "이메일"
              :change-email "이메일 변경"
              :avatar "아바타"
              :change-avatar "gravatar.com에서 변경하기"
              :pronouns "인칭 대명사"
              :language "언어"
              :sounds "음향"
              :enable-lobby-sounds "로비 음향 활성화"
              :enable-game-sounds "게임 음향 활성화"
              :volume "볼륨"
              :layout-options "레이아웃 옵션"
              :stacked-cards "서버 스태킹이 기본으로 설정됨"
              :runner-layout "기업 위치 러너 레이아웃"
              :runner-classic "클래식 진테키넷 러너 리그 (위에서부터: 프로그램, 하드웨어, 리소스)"
              :runner-reverse "반전된 러너 리그 (위에서부터: 리소스, 하드웨어, 프로그램)"
              :background "게임판 배경"
              :card-backs "카드 뒷면"
              :game-stats "게임 승/패 기록"
              :deck-stats "덱 기록"
              :always "항상 기록"
              :comp-only "경쟁 로비에서만"
              :none "기록 안함"
              :alt-art "대체 아트"
              :show-alt "대체 아트 보기"
              :high-res "고해상도 카드 이미지 활성화"
              :card-images "카드 이미지"
              :set-all "모든 카드를 다음과 같이 설정"
              :set "설정"
              :reset "공식 아트로 되돌리기"
              :blocked "차단한 사용자"
              :user-name "사용자 이름"
              :block "사용자 차단"
              :update-profile "프로필 갱신"
              :nsg "NSG"
              :ffg "FFG"}
   :stats {:game-stats "게임 기록"
           :corp-stats "기업 기록"
           :runner-stats "러너 기록"
           :clear-stats "기록 초기화"
           :no-log "사용 가능한 로그가 없습니다"
           :view-log "로그 보기"
           :winner "승자"
           :no-games "게임 없음"
           :all-games "모든 게임 보기"
           :shared-games "공유된 게임만 보기"
           :started "시작됨"
           :ended "종료됨"
           :completed "완료됨"
           :not-completed "완료되지 않음"
           :won "승리"
           :lost "패배"
           :turn-count (fn [[cnt]] (str cnt " 차례"))
           :lobby "로비"
           :format "포맷"
           :win-method "승리 방법"
           :view-games "기록 화면으로 돌아가기"
           :share "리플레이 공유"
           :launch "리플레이 실행"
           :download "리플레이 다운로드"
           :unavailable "리플레이를 사용할 수 없음"
           :filtered "(필터됨)"
           :log-count (fn [[cnt]] (str cnt " 로그"))
           :clicks-gained "얻은 클릭"
           :credits-gained "얻은 크레딧"
           :credits-spent "사용한 크레딧"
           :credits-click "클릭으로 얻은 크레딧"
           :cards-drawn "뽑은 카드"
           :cards-click "클릭으로 뽑은 카드"
           :damage-done "입힌 피해"
           :cards-rezzed "레즈된 카드"
           :tags-gained "얻은 태그"
           :runs-made "런 시도"
           :cards-accessed "액세스한 카드"}
   :log {:game-log "게임 로그"
         :annotating "주석"
         :shared "공유된 주석"
         :remote-annotations-fail "원격 주석을 가져올 수 없습니다."}
   :annotations {:turn-placeholder "이 차례에 대한 메모"
                 :click-placeholder "이 클릭에 대한 메모"
                 :available-annotations "사용가능한 주석"
                 :no-published-annotations "발행된 주석이 없음"
                 :publish "발행"
                 :import-local "로컬 주석 파일 가져오기"
                 :load-local "불러오기"
                 :save-local "저장"
                 :clear "로컬 주석 지우기"}
   :game {:keep "그대로"
          :mulligan "멀리건"
          :close "닫기"
          :start "게임 시작"
          :remove-tag "태그 제거"
          :run "런"
          :purge "퇴치"
          :trash-resource "리소스 폐기"
          :draw "카드 뽑기"
          :gain-credit "크레딧 얻기"
          :game-start "게임 시작"
          :start-turn "차례 시작"
          :end-turn "차례 종료"
          :mandatory-draw "강제 카드 뽑기"
          :take-clicks "클릭 가져가기"
          :hq "본부(HQ)"
          :grip "그립"
          :rfg "게임에서 제거됨"
          :play-area "발동 영역"
          :current "동향"
          :scored-area "득점 영역"
          :archives "기록보관소"
          :max-hand "최대 핸드 크기"
          :brain-damage "두뇌 피해"
          :tag-count (fn [[base additional total]] (str base (when (pos? additional) (str " + " additional)) " 태그"))
          :agenda-count (fn [[agenda-point]] (str agenda-point " 아젠다 점수"))
          :link-strength "링크 강도"
          :credit-count (fn [[credit run-credit]] (str credit " 크레딧" (when (pos? run-credit) (str " (런 동안 " run-credit ")"))))
          :click-count (fn [[click]] (str click " 클릭"))
          :bad-pub-count (fn [[base additional]] (str base (when (pos? additional) (str " + " additional)) " 악평"))
          :mu-count (fn [[unused available]] (str available " 메모리 유닛 중 " unused " 미사용"))
          :indicate-action "행동 선언"
          :spec-count (fn [[cnt]] (str cnt " 관전자"))
          :spec-view "관전자 보기"
          :runner-view "러너 보기"
          :corp-view "기업 보기"
          :leave-replay "리플레이 떠나기"
          :leave "게임 떠나기"
          :unmute "관전자 무시 해제"
          :mute "관전자 무시"
          :concede "항복하기"
          :inactivity "활동이 없어 게임이 닫혔습니다"
          :server "서버"
          :unimplemented "미구현"
          :abilities "능력"
          :let-subs-fire "모든 서브루틴 격발"
          :subs "서브루틴"
          :actions "행동"
          :fire-unbroken "깨지지 않은 서브루틴 격발"
          :stack "스택"
          :r&d "연구개발부(R&D)"
          :shuffle "섞기"
          :show "보기"
          :close-shuffle "닫고 섞는다"
          :heap "힙"
          :card-count (fn [[size]] (str size " 카드"))
          :face-down-count (fn [[total face-up]] (str total " cards, " (- total face-up) " face-down."))
          :up-down-count (fn [[total face-up]] (str face-up "↑ " (- total face-up) "↓"))
          :initiation "시도"
          :approach-ice "아이스 접근"
          :no-current-run "현재 런 없음"
          :current-phase "현재 단계"
          :unknown-phase "미상 단계"
          :rez "레즈하기"
          :no-further "더 이상 행동 없음"
          :continue-to "계속하기"
          :stop-auto-pass "자동-통과 우선 중지"
          :auto-pass "자동-통과 우선"
          :jack-out "잭 아웃"
          :trace "추적"
          :credits "크레딧"
          :card "카드"}})
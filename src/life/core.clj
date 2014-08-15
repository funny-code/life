(ns life.core)

;; 生命是一段漫长的旅程
;; 想了，就去做
;; 输了，从头再来
;; 摔了，爬起来继续
;; 赢了，还要继续往前
;; 死了，没留下任何遗憾

(def my-life (ref {:age 22 :state (rand-int 100)}))

(defn alive? [life]
  (and (< (life :age) 100) (> (life :state) 0)))

(defn do-plan []
  (dosync
   (alter my-life assoc :age (inc (my-life :age)) :state (rand-int 100)))
  (= 0 (rand-int 2)))

(defn live-my-life []
  (if (alive? @my-life)
    (do
      (println "I have a new plan...")
      (if (do-plan)
        (println "keep on moving!")
        (println "start all over again!"))
      (live-my-life))
    (println "no regrets.")))


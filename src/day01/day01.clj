; Puzzle input saved as input

(ns day01)

(count (re-seq #"\(" "((("))
;=> 3

(count (re-seq #"\(" (slurp "input")))
;=> 3537

(count (re-seq #"\)" (slurp "input")))
;=> 3463

(- 3537 3463)
;=> 74

(defn parse-step [floor step]
  (case step
    \( (inc floor)
    \) (dec floor)
    floor))

(defn parse-floor
  [steps]
  (reduce parse-step 0 steps))

 (defn part-1 []
   (println (parse-floor (slurp "input"))))
   
 (defn basement
  [instructions]
  (->> instructions
       (reductions parse-step 0)
       (map vector (drop 1 (range)))
       (drop-while (fn [[position floor]] (not (neg? floor))))
       first
       first))

(defn part-2 []
   (println (dec (basement (slurp "input")))))

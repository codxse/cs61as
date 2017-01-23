(defn inc [a] (+ a 1))

(defn sum [f a next b] 
  (let [iter (fn iter [a result]
               (if (> a b)
                 result
                 (iter (next a) (+ (f a) result))))]
    (iter a 0)))

(sum + 1 inc 3)
;; 6

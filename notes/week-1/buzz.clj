(defn buzz [n]
  "Return 'buzz if divisible by 7 or has 7,
  else number itself."
  (cond
    (= 0 (rem n 7)) 'buzz
    (some #(= \7 %) (str n)) 'buzz
    :else n))

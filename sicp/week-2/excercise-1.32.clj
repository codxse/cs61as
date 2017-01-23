(defn accumulate
  [combainer null-val f a next b]
  (if (> a b)
    null-val
    (combainer (f a) (accumulate combainer null-val f (next a) next b))))

(defn accumulate-iter
  [combainer null-val f a next b]
  (loop
    [iterator a
     result null-val]
    (if (> iterator b)
      result
      (recur (next iterator) (combainer (f iterator) result)))))

(defn sum-of [a b]
  (accumulate + 0 identity a inc b))

(sum-of 1 5)
;;=> 15

(defn sum-of-iter [a b]
  (accumulate-iter + 0 identity a inc b))

(sum-of-iter 1 5)
;;=> 15

(defn factorial [n]
  (accumulate * 1 identity 1 inc n))

(factorial 5)
;;=> 120

(defn factorial-iter [n]
  (accumulate-iter * 1 identity 1 inc n))

(factorial 5)
;;=> 120

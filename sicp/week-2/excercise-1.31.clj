(defn square [x] (* x x))

(defn product [f a next b]
  (if (> a b)
    1
    (* (f a) (product f (next a) next b))))

(defn product-iter [f a next b]
  (let [iter (fn iter [a result]
               (if (> a b)
                 result
                 (iter (next a) (* (f a) result))))]
    (iter a 1)))

(defn factorial [a]
  (product identity 1 inc a))

(factorial 5)
;;=> 120

(defn factorial-iter [a]
  (product-iter identity 1 inc a))

(factorial-iter 5)
;;=> 120

(defn wallis-formula [x]
  (/ (* 4.0 (square x))
     (- (* 4.0 (square x)) 1)))

(defn wallis [n]
  (* 2 (product wallis-formula 1 inc n)))

(wallis 1000)
;;=> 3.1408077460304042

(defn wallis-iter [n]
  (* 2 (product-iter wallis-formula 1 inc n)))

(wallis-iter 1000)
;;=> 3.140807746030402

(defn cube [a] (* a a a))

(defn sum [f a next b]
  (if (> a b)
    0
    (+ (f a)
       (sum f (next a) next b))))

(defn integral [f a b dx]
  (let [add-dx #(+ % dx)]
    (* (sum f (+ a (/ dx 2.0)) add-dx b)
       dx)))

(defn simpson [f a b n]
  (let [h (/ (- b a) b)
        y #(f (+ a (* % h)))
        term #(* (cond
                   (or (= % 0) (= % n)) 1
                   (odd? %) 4
                   (even? %) 2)
                 (y %))]
    (/ (* h (sum term 0 inc n)) 3)))

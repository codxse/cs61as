(defn cube [x]
  (+ x x x))

(defn sum-integers [a b]
  (if (> a b)
    0
    (+ a (sum-integers (+ a 1)))))

(defn sum-cubes [a b]
  (if (> a b)
    0
    (+ (cube a) (sum-cubes (+ a 1) b))))

(defn pi-sum [a b]
  (if (> a b)
    0
    (+ (/ 1.0 (* a (+ a 2))) (pi-sum (+ a 4) b))))

(defn sum [f a next b]
  (if (> a b)
    0
    (+ (f a)
       (sum f (next a) next b))))

(defn [inc a]
  (+ a 1))

(defn sum-cubes2 [a b]
  (sum cube a inc b))

(defn identity [a] a)

(defn [sum-integers2 a b]
  (sum identity a inc b))

(defn pi-sum2 [a b]
  (let [pi-fn #(/ 1.0 (* % (+ % 2)))
        pi-next #(+ % 4)]
    (sum pi-fn a pi-next b)))

(defn integral [f a b dx]
  (let [add-dx #(+ % dx)]
    (* (sum f (+ a (/ dx 2.0)) add-dx b))))

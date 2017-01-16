(defn square [x]
  (* x x))

(defn abs [x]
  (if (> x 0) x (- x)))

(defn- good-enough? [guess x]
  (< (abs (- (square guess) x))
     0.001))

(defn- average [x y]
  (/ (+ x y) 2))

(defn- improve [guess x]
  (average guess (/ x guess)))

(defn- sqrt-iter [guess x]
  (if (good-enough? guess x)
    guess
    (sqrt-iter (improve guess x) x)))

(defn sqrt [x]
  (sqrt-iter 1.0 x))
  
;; -----------------------------------------

(defn roots [a b c]
  (vector (/ (+ (- b) (sqrt (- (* b b)(* 4 a c))))
             (* 2 a))
          (/ (- (- b) (sqrt (- (* b b)(* 4 a c))))
             (* 2 a))))

(defn new-roots [a b c]
  (let [d (sqrt (- (* b b) (* 4 a c)))
        -b (- d)
        a2 (* 2 a)]
    (vector (/ (+ -b d) a2)
            (/ (- -b d) a2))))

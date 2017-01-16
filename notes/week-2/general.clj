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

(def PI 3.141592654)

(defn square-area [r]
  (square r))

(defn circle-area [r]
  (* PI (square r)))

(defn sphare-area [r]
  (* 4 PI (square r)))

(defn hexagon-area [r]
  (* (sqrt 3) 1.5 (square 4)))

;; -----------------------------------------

(def square 1)
(def circle PI)
(def sphare (* 4 PI))
(def hexagon (* (sqrt 3) 1.5))

(defn area [shape r]
  (* shape (square r)))

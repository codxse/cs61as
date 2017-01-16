(defn- cube [x]
  (* x x x))

(defn- square [x]
  (* x x))

(defn- abs [x]
  (if (> x 0) x (- x)))

(defn- good-enough? [guess x]
  (< (abs (- (cube guess) x))
     0.001))

(defn- improve [guess x]
  (/ (+ (/ x (square guess))
        (* guess 2))
     3))

(defn- cbrt-iter [guess x]
  (if (good-enough? guess x)
    guess
    (recur (improve guess x) x)))

(defn cbrt [x]
  (cbrt-iter 1.0 x))

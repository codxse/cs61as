(defn ex1-3 [a b c]
  "Returns the sum of squares
  of the two larger numbers."
  (if (>= a b)
    (if (>= b c)
      (+ (* a a) (* b b))
      (+ (* a a) (* c c)))
    (if (>= a c)
      (+ (* b b) (* a a))
      (+ (* b b) (* c c)))))

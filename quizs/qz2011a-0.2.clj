; quiz 1

(if (= 3 (+ 2 1))
  (+ 4 5)
  (+ 6 7))

(new-if (= 3 (+ 2 1))
  (+ 4 5)
  (+ 6 7))

; quiz 2

(defn- abs [x]
  (if (> x 0) x (- x)))

(defn- number-to-word [x]
  "Return phrase of positive integer number."
  (condp = x
    0 'zero
    1 'one
    2 'two
    3 'three
    4 'four
    5 'five
    6 'six
    7 'seven
    8 'eight
    9 'nine
    (recur (int (abs x)))))

(defn- number-to-list [x]
  "Convert number to list of number."
  (when (number? x)
    (->> (str x)
         (map str)
         (map read-string))))

(defn- drop-one [x]
  "Drop front of number."
  (let [y (number-to-list x)
        z (rest y)]
    (if (not-empty z)
      (->> (map str z)
           (apply str)
           (read-string))
      '())))

(defn num-sent [x]
  "Return sentence of number."
  (if-let [y (first (number-to-list x))]
    (cons (number-to-word y) (num-sent (drop-one x)))
    '()))

; quiz 3

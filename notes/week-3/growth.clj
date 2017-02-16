(defn square [x] (* x x))

(defn squares [x]
  (if (empty? x)
    []
    (cons (square (first x)) (squares (rest x)))))

;; O(N) need extra memory
(defn count [s]
  (if (empty? s)
    0
    (+ 1 (count (rest s)))))

(defn- count-iter [s result]
  (if (empty? s)
    0
    (count-iter (rest s) (inc result))))

;; no need extra memory
(defn smart-count [s]
  (count-iter s 0))

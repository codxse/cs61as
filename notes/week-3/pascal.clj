;; expensive pascal O(2^n)
(defn pascal [row col]
  (cond
    (= col 0) 1
    (= col row) 1
    :else (+ (pascal (dec row ) (dec col))
             (pascal (dec row) col))))

;; O(n^2)
(defn- pascal-iter [in out]
  (if (empty? (rest in))
    out
    (pascal-iter (rest in)
                 (cons (+ (first in) (first (rest in))) out))))

(defn- next-row [old-row num]
  (if (= num 0)
    old-row
    (next-row (cons 1 (pascal-iter old-row [1])) (dec num))))

(defn- pascal-row [row-num]
  (vec (next-row [1] row-num)))

(defn new-pascal [row col]
  (nth (pascal-row row) col))

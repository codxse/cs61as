(defn opposite [w]
  "Return opposite of word."
  (condp = w
    'like 'hate
    'hate 'like
    'wonderful 'terriable
    'terriable 'wonderful
    'great 'awful
    'awful 'great
    'terrific 'yucky
    'yucky 'terrific
    w))

(defn argue [s]
  "Return opposite of sentence."
  (if (empty? s)
    '()
    (cons (opposite (first s))
          (argue (rest s)))))

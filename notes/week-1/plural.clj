(defn plural [word]
  "Convert word to plural."
  (if (= \y (last word))
    (str (apply str (butlast word)) 'ies)
    (str word 's)))

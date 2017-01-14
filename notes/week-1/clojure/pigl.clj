(defn vowel? [chr]
  "Return true if the char is vowel."
  (let [f #(some (partial = %) "aiueo")]
    (if (char? chr)
      (not (nil? (f chr)))
      (not (nil? (f (first (str chr))))))))

(defn pl-done? [word]
  "Return true if the first char is vowel."
  (vowel? (first word)))

(defn pigl [word]
  "Convert word to pig-latin."
  (if (pl-done? word)
    (str word 'ay)
    (recur (str (apply str (rest word))
                (first word)))))

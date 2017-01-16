(defn evens [coll]
  (cond
    (empty? coll) '()
    (= (rem (first coll) 2) 0) (cons (first coll) (evens (rest coll)))
    :else (evens (rest coll))))

;--------------------------------------------

(defn new-rest [sentence]
  (let [words (clojure.string/split sentence #"\s")]
    (->> (rest words)
         (interpose " ")
         (apply str))))

(defn ewords [sentence]
  (let [words (clojure.string/split sentence #"\s")]
    (cond
      (= (first words) "") '()
      (= \e (first (first words))) (cons (first words)
                                         (ewords (new-rest sentence)))
      :else (ewords (new-rest sentence)))))

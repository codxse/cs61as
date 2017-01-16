; Alyssa P. Hacker doesn’t see why if needs to be provided as a special form.
; “Why can’t I just define it as an ordinary procedure in terms of cond?”
; she asks. Alyssa’s friend Eva Lu Ator claims this can indeed be done,
; and she defines a new version of if:

(defn new-if
  [predicate then-clouse else-clouse]
  (cond
    predicate then-clouse
    :else else-clouse))

; Eva themonstrate the program for Alyssa

(new-if (= 2 3) 0 5)
;;=> 5

(new-if (= 1 1) 0 5)
;;=> 0

;; the full program is in sqrt.clj
(defn sqrt-iter [guess x]
  (new-if (good-enough? guess x)
    guess
    (sqrt-iter (improve guess x) x)))

; What happens when Alyssa attempts to use this to compute square roots?
; Explain.

; Same behaviour as if, the given answer both if and new-if is same.
; thet because cond

; Observe that our model of evaluation allows for combinations whose
; operators are compund expressions. Use this observation to describe
; the behaviour of the following procedure:

(defn a-plus-abs-b [a b]
  ((if (> b 0) + -) a b))

; if b > 0, it just a + b
; otherwise a - (- b) witch is same as a + b

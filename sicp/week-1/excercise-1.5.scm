; Ben has invented a test to determine whether the interpreter he is faced
; with is using applicative-order evaluation or normal order evaluation.
; He dofines the followint two procedure:

(define (p) (p))

(define (test x y)
  (if (= x 0) 0 y))

; Then he evaluates the expression

(test 0 (p))

; What behaviour will Ben observe with an interpreter that use applicative-order
; evaluation?

;;=> (test 0 (p))
;
; it will evaluate to:
;
;;=> (if (= 0 0) 0 (p))
;;=> 0
;
; the program terminate and don't care to alternative as log as x = 0.


; What behaviour will Ben observe with an interpreter that use normal-order
; evaluation?

;;=> (test 0 (p))
;
; it will evaluate to
;
;;=> (if (= 0 0) 0 (p ...))
;
; the program will halt because p will never stop.
; That because p itself return itself.

; Assume that the evaluation rule for the special form if is the same
; whether using normal or applicative order: The predicate expression is
; evaluated first, and the result determines whether to evaluate consequent or
; the alternative expression.

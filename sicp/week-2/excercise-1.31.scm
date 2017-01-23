(define (inc a) (+ a 1))
(define (identity x) x)
(define (square x) (* x x))

(define (product f a next b)
  (if (> a b)
    1
    (* (f a) (product f (next a) next b))))

(define (product-iter f a next b)
  (define (iter a result)
    (if (> a b)
      result
      (iter (next a) (* (f a) result))))
  (iter a 1))

(define (factorial a)
  (product identity 1 inc a))

(factorial 5)
;; 120

(define (factorial-iter a)
  (product-iter identity 1 inc a))

(factorial-iter 5)
;; 120

(define (wallis-formula x)
  (/ (* 4.0 (square x))
     (- (* 4.0 (square x)) 1)))

(define (wallis n)
  (* 2 (product wallis-formula 1 inc n)))

(wallies 100)
;; 3.133787490628163

(define (wallis-iter n)
  (* 2 (product-iter wallis-formula 1 inc n)))

(wallis-iter 100)
;; 3.133787490628162

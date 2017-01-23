(define (inc a) (+ a 1))
(define (identity x) x)

(define (accumulate combainer null-val f a next b)
  (if (> a b)
    null-val
    (combainer (f a) (accumulate combainer null-val f (next a) next b))))

(define (accumulate-iter combainer null-val f a next b)
  (define (iter a result)
    (if (> a b)
      result
      (iter (next a) (combainer (f a) result))))
  (iter a null-val))

(define (sum-of a b)
  (accumulate + 0 identity a inc b))

(sum-of 1 5)
;; 15

(define (sum-of-iter a b)
  (accumulate-iter + 0 identity a inc b))

(sum-of-iter 1 5)
;; 15

(define (factorial n)
  (accumulate * 1 identity 1 inc n))

(factorial 5)
;; 120

(define (factorial-iter n)
  (accumulate-iter * 1 identity 1 inc n))

(factorial-iter 5)
;; 120  

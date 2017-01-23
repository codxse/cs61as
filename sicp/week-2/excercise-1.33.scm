(define (square x)
  (* x x))

(define (abs x)
  (if (> x 0) x (- x)))

(define (good-enough? guess x)
  (< (abs (- (square guess) x))
     0.001))

(define (average x y)
  (/ (+ x y) 2))

(define (improve guess x)
  (average guess (/ x guess)))

(define (sqrt-iter guess x)
  (if (good-enough? guess x)
    guess
    (sqrt-iter (improve guess x) x)))

(define (sqrt x)
  (sqrt-iter 1.0 x))

(define (prime? x)
  (define (dec x) (- x 1))
  (define (check x denom)
    (if (> denom 2)
      (cond
        ((even? x) #f)
        ((= 0 (remainder x (dec denom))) #f)
        (else (check x (dec denom))))
      #t))
  (check (abs x) (abs x)))

;; a

(define (inc a) (+ a 1))
(define (dec a) (- a 1))
(define (identity x) x)

(define (filter-accumulate filter combainer null-val f a next b)
  (if (> a b)
    null-val
    (if (filter a)
      (combainer (f a)
                 (filter-accumulate filter combainer null-val f (next a) next b))
      (filter-accumulate filter combainer null-val f (next a) next b))))

(define (sum-of-square-primes a b)
   (filter-accumulate prime? + 0 square a inc b))

(sum-of-square-primes 2 6)
;; 38

;; b

(define (gcd a b)
  (if (= b 0)
    a
    (gcd b (remainder a b))))

(define (product-of-gcd-prime n)
  (define (gcd-prime? i)
    (= 1 (gcd i n)))
  (filter-accumulate gcd-prime? * 1 identity 1 inc (dec n)))

(product-of-gcd-prime 10)
;; 189

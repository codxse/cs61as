(define (cbrt x)
  (define (cube x)
    (* x x x))

  (define (square x)
    (* x x))

  (define (abs x)
    (if (> x 0) x (- x)))

  (define (good-enough? guess)
    (< (abs (- (cube guess) x))
       0.001))

  (define (improve guess)
    (/ (+ (/ x (square guess))
          (* guess 2))
       3))

  (define (cbrt-iter guess)
    (if (good-enough? guess)
      guess
      (cbrt-iter (improve guess))))

  (cbrt-iter 1.0))

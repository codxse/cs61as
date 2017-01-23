(define (inc a) (+ a 1))

(define (sum f a next b)
  (define (iter a result)
    (if (> a b)
      result
      (iter (next a) (+ (f a) result))))
  (iter a 0))

(sum + 1 inc 3)
;; 6

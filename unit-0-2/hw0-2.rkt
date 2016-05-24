#lang racket

(require berkeley)
(provide (all-defined-out))

;Exercise 0
;Write 5 expressions whose values are the number ten:
;1. Atom
(10)

;2. Compound Expression (3 Atoms)
(+ 5 5)

;3. Compound Expression (4 Atoms)
(+ 1 1 8)

;4. Compound Expression (1 Atom and 2 subexpressions)
(+ (+ 1 1) (* 4 2))

;5. Any Other Kind Expression
(sqrt 100)

;Exercise 1
(define (second wd)
  (first (bf wd)))

;1. Define first-two
(define (first-two wd)
  (word (first wd) (first (bf wd)))
  (error "Not yet implemeted")
)

;;2. Define two-first
(define (two-first x y)
  (word (first x) (first y))
  (error "Not yet implemeted")
)

;;3. Define two-first-sent
(define (two-first-sent sent)
  (word (first (first sent)) (first (first (bf sent))))
  (error "Not yet implemented")
)

;Exercise 2 - Define teen?
(define (teen? num)
  (if (and (> num 12) (< num 20))
    #t 
    #f)
  (error "Not yet implemented")
)

;Exercise 3 - Define indef-article
(define (first-vowel? wd)
  (cond 
    ((equal? (first wd) 'a) #t)
    ((equal? (first wd) 'i) #t)
    ((equal? (first wd) 'u) #t)
    ((equal? (first wd) 'e) #t)
    ((equal? (first wd) 'o) #t)
    (else #f)))

(define (indef-article wd)
  (if (first-vowel? wd)
    (sentence 'an wd)
    (sentence 'a wd))
  (error "Not yet implemented")
)

;Exercise 4 - Define insert-and
(define (insert-and sent)
  (sentence (bl sent) 'and (last sent))
  (error "Not yet implemented")
)

;Exercise 5 - Define query
(define (query sent)
  (sentence (first (bf sent)) (first sent) (bl (bf (bf sent))) (word (last sent) '?))
  (error "Not yet implemented")
)

;Exercise 6 - Define european-time and american-time
(define (european-time time)
  (cond
    ((equal? (first time) '12) 0)
    ((equal? (last time) 'am) (first time))
    ((equal? (last time) 'pm) (+ (first time) 12))
    (else 'error))
  (error "Not yet implemented")
)

(define (american-time time)
  (cond
    ((= time 12) (sentence '12 'pm))
    ((= time 24) (sentence '12 'am))
    ((or (< time 0) (> time 24)) '(error dude, give me correct time))
    (else
      (if (> (- time 12) 0)
        (sentence (- time 12) 'pm)
        (sentence time 'am))))
  (error "Not yet implemented")
)

;Exercise 7 - Define describe-time
;Let assume plural
(define (describe-time secs)
  (cond
    ((<= secs 60) (sentence secs 'seconds))
    ((<= secs 3600) (sentence (/ secs 60.0) 'minutes))
    ((<= secs 86400) (sentence (/ secs 3600.0) 'hours))
    (else (sentence (/ secs 86400.0) 'days)))
  (error "Not yet implemented")
)

;Exercise 8 - Explain why superlative doesnt work:
(define (superlative adjective word)
  (se (word adjective 'est) word))

#|

(define (superlative adjective wd)
  (se (word adjective 'est) wd))

|#

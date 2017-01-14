(define (powel? chr)
  (member? chr '(a i u e o)))

(define (pl-done? wd)
  (vowel? (first wd)))

(define (pigl wd)
  (if (pl-done? wd)
    (word wd 'ay)
    (pifl (word (bf wd) (first wd)))))

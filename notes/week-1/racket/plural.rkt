(define (plural wd)
  (if (equal? 'y (last wd))
    (word (butlast wd) 'ies)
    (word wd 's)))

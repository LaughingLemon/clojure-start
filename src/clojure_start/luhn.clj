(ns clojure-start.luhn)

(defn double-and-limit [double-value]
  (let [digit (* 2 double-value)]
    (if (> digit 9)
      (- digit 9)
      digit)
    )
  )

(defn reduce-luhn [cc-vector]
  (let [reversed-vector (reverse cc-vector)]
    (+
      (reduce + (take-nth 2 reversed-vector))
      (reduce + (map double-and-limit (take-nth 2 (rest reversed-vector))))
      )
    )
  )

(defn luhn-check [credit_card]
  (let [cc_vector (map #(Character/digit % 10) (seq credit_card))]
    (= (mod (reduce-luhn cc_vector) 10) 0)
    )
  )
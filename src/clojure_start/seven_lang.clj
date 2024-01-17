(ns clojure-start.seven-lang)

(defn big [s n]
  (> (count s) n))

(defn collection-type [col]
  (if (vector? col) :vector
                    (if (list? col) :list
                                    (if (map? col) :map))
                    )
  )

(def directions [:north :south :east :west])

(defprotocol Compass
  (direction [c])
  (left [c])
  (right [c])
  )

(defn turn
  [base amount]
  (rem (+ base amount) (count directions))
  )

(defrecord SimpleCompass [bearing] Compass
  (direction [_] (directions bearing))
  (left [_] (SimpleCompass. (turn bearing 3)))
  (right [_] (SimpleCompass. (turn bearing 1)))
  Object
  (toString [this] (str "[" (direction this) "]"))
  )

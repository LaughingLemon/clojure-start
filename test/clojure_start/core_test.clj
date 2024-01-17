(ns clojure-start.core-test
  (:require [clojure.test :refer :all]
            [clojure-start.seven-lang :refer :all]
            [clojure-start.luhn :refer :all])
  (:import (clojure_start.seven_lang SimpleCompass)))

(deftest a-test
  (is (= (big "true" 3) true))
  (is (= (big "true" 5) false))
)

(deftest b-test
  (is (= (collection-type []) :vector))
  (is (= (collection-type (list)) :list))
  (is (= (collection-type {}) :map))
  )

(deftest c-test
  (is (= (turn 1 1) 2))
  (is (= (turn 3 0) 3))
  (is (= (turn 2 2) 0))
  )

(deftest d-test
  (def c (SimpleCompass. 0))
  (is (= (left c) #clojure_start.seven_lang.SimpleCompass{:bearing 3}))
  (is (= c #clojure_start.seven_lang.SimpleCompass{:bearing 0}))
  (is (= (right c) #clojure_start.seven_lang.SimpleCompass{:bearing 1}))
  )

(deftest cc_test
  (is (= true (luhn-check "4111111111111111")))
  (is (= false (luhn-check "4121212121212121")))
  )

(deftest cc_luhn_test
  (is (= (reduce-luhn [4 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1]) 30))
  (is (= (reduce-luhn [4 1 2 1 2 1 2 1 2 1 2 1 2 1 2 1]) 44))
  )

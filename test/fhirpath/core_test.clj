(ns fhirpath.core-test
  (:require [fhirpath.core :as sut]
            [clojure.test :refer :all]))



(deftest basic-tests


  (sut/parse "aaa.bb.cc.dd")


  (is (= (sut/fp "a" {:a 1}) 1))

  (is (= (sut/fp "a.b.c" {:a {:b {:c 1}}}) 1))
  (is (= (sut/fp "a.b.c" {:a [{:b [{:c 1}]}]}) [1]))
  (is (= (sut/fp "a.b.c" {:a [{:b [{:c 1}{:c 2}]}
                              {:b [{:c 3}{:c 4}]}]})
         [1 2 3 4]))

  (is (= "23"
         (sut/fp "str.subs(1,3)" {:str "12345"})))

  (is (= [1 2]
         (sut/fp "a.take(2)" {:a [1 2 3 4 5]})))

  (is (= true (sut/fp "a = b" {:a 1 :b 1})))
  (is (= false (sut/fp "a = b" {:a 1 :b 2})))
  

  (def data {:name [{:use "work"
                     :given "Kolja"}
                    {:use "home"
                     :given "Nikolai"}]})

  (is (= ["Nikolai"] (sut/fp "name.where(use = 'home').given" data)))
  (is (= ["Kolja"] (sut/fp "name.where(use = 'work').given" data)))
  (is (= "Kolja" (sut/fp "name[0].given" data)))
  (is (= "Nikolai" (sut/fp "name[1].given" data)))
  (is (= nil (sut/fp "name[100].given" data)))

  )


(ns fhirpath.core-test
  (:require [fhirpath.core :as sut]
            [clj-yaml.core :as yaml]
            [clojure.test :refer :all]
            [clojure.java.io :as io]))



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


(defn do-test [path]
  (let [data (yaml/parse-string (slurp (io/resource path)))]
    (doseq [t (:tests data)]
      (println (:desc t))
      (println "EXPR=>" (:expression t))

      (when (:expression t)
        (let [res (sut/fp (:expression t) (:subject data))]
          (is (= (:result t) res)
              (str (:desc t) " " (:expression t) )))))))

(deftest fhipath-tests
  (do-test "cases/4.1_literals.yaml")


  (is (= [3 4 5]
         (sut/fp "a.b.where($this > 2)" {:a {:b [1 2 3 4 5]}})))


  (is (= [1 2 3 4 5 6]
         (sut/fp "a.select(b)" {:a [{:b [1 2 3]}
                                    {:b [4 5 6]}]})))

  (is (= [1 2]
         (sut/fp "a.select(b)" {:a [{:b 1}
                                    {:b 2}]})))
  (is (= [1]
         (sut/fp "a.select(b)" {:a {:b 1}})))
  
  (is (= [{:a {:a 1}} {:a 1} 1]
         (sut/fp "b.repeat(a)" {:b {:a {:a {:a 1}}}})))


  (is (sut/fp "b.all($this > 0)" {:b [1 2 3 3]}))
  (is (not (sut/fp "b.all($this > 3)" {:b [1 2 3 3]})))
  (is (sut/fp "b.exists($this > 1)" {:b [1 2 3 3]}))
  (is (not (sut/fp "b.exists($this > 30)" {:b [1 2 3 3]})))



  (is (sut/fp "a.supersetOf(b)" {:a [1 2 3] :b [1 2]}))
  (is (not (sut/fp "b.supersetOf(a)" {:a [1 2 3] :b [1 2]})))

  (is (sut/fp "b.subsetOf(a)" {:a [1 2 3] :b [1 2]}))
  (is (not (sut/fp "a.subsetOf(b)" {:a [1 2 3] :b [1 2]})))


  
  (do-test "cases/5.2_filtering_and_projection.yaml")

  (do-test "cases/5.1_existence.yaml")

  
  )

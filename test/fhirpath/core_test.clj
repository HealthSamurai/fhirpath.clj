(ns fhirpath.core-test
  (:require [fhirpath.core :as sut]
            [clj-yaml.core :as yaml]
            [clojure.test :refer :all]
            [clojure.java.io :as io]
            [clojure.string :as str]))

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


(defn load-case [path]
  (yaml/parse-string (slurp (io/resource (str "fhirpath/" path)))))

(defn do-test [path]
  (let [data (load-case (str path))]
    (doseq [t (:tests data)]
      (println (:desc t))
      (println "EXPR=>" (:expression t))

      (when (:expression t)
        (let [res (sut/fp (:expression t) (:subject data) (:variables t))]
          (is (= (:result t) res)
              (str
               path
               (:desc t) " \n'" (:expression t) "' "
                   "\n"
                   (:result t) "!=" res)))))))

(defn parse-local [date]
   (java.time.LocalDate/parse date java.time.format.DateTimeFormatter/ISO_LOCAL_DATE))

(defn parse-zoned [date]
   (java.time.ZonedDateTime/parse date java.time.format.DateTimeFormatter/ISO_OFFSET_DATE_TIME))

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

  (is (= 2
         (sut/fp "Functions.coll1[0].coll2[1].attr"
             {:resourceType "Functions"
              :coll1 [{:coll2 [{:attr 1} {:attr 2}]}]})))

  (sut/parse "Functions.coll1[0].coll2.attr")

  (is (= [1 2 3]
         (sut/fp
          "Functions.coll1[0].coll2.attr"
          {:resourceType "Functions"
           :coll1 [{:coll2 [{:attr 1} {:attr 2} {:attr 3}]}
                   {:coll2 [{:attr 4} {:attr 5}]}]})))
  
  (is (= [4 5]
         (sut/fp
          "Functions.coll1[1].coll2.attr"
          {:resourceType "Functions"
           :coll1 [{:coll2 [{:attr 1} {:attr 2} {:attr 3}]}
                   {:coll2 [{:attr 4} {:attr 5}]}]})))

  (def edata (:subject (load-case "cases/5.1_existence.yaml")))
  (sut/fp
   "Functions.attrdouble.subsetOf(Functions.coll1[0].coll2.attr)"
   edata)

  (sut/fp "Functions.attrdouble" edata)

  (sut/parse "Functions.coll1[0]")

  (sut/fp "Functions.coll1" edata)

  (sut/fp
   "Functions.attrdouble.subsetOf(Functions.coll1[0].coll2.attr)"
   (load-case "cases/5.1_existence.yaml"))

  (sut/fp
   "Functions.attrdouble.supersetOf(Functions.coll1[0].coll2.attr"
   (load-case "cases/5.1_existence.yaml"))
  
  (is (not (sut/fp "collfalse.attr.isDistinct()"
                   {:collfalse [{:attr false}
                                {:attr false}]})))


  (sut/fp "collfalse.attr.isDistinct()" {:collfalse [{:attr false}
                                                     {:attr false}]})


  (do-test "cases/5.1_existence.yaml")
  (do-test "cases/5.2_filtering_and_projection.yaml")
  (do-test "cases/5.2.3_repeat.yaml")
  (do-test "cases/5.3_subsetting.yaml")

  (is (= [1 2 3 4 5]
         (sut/fp "a | b" {:a [1 2 3 3]
                          :b [4 5 5]})))

  (is (= [1 2 3 3 4 5 5]
         (sut/fp "a.combine(b)" {:a [1 2 3 3]
                                 :b [4 5 5]})))

  (def cdata (:subject (load-case "cases/5.4_combining.yaml")))

  (sut/fp 
   "Functions.attrdouble | Functions.coll1.coll2.attr"
   cdata)

  (do-test "cases/5.4_combining.yaml")

  (do-test "cases/5.5_conversion.yaml")

  (is (= 4 (sut/fp "a.iif(b = 3, 4, 5 )" {:a {:b 3}})))
  (is (= 5 (sut/fp "a.iif(b = 3, 4, 5 )" {:a {:b 4}})))

  (sut/fp "attr.substring(2, 1)" {:attr "abcdefg"})

  (is (= "cdefg"
         (sut/fp "attr.substring(2, 5555)" {:attr "abcdefg"})))
  

  (sut/fp "attr.replace('', 'x')", {:attr "abc"})

  (sut/fp "attr.replace('\\b(?<month>\\d{1,2})/(?<day>\\d{1,2})/(?<year>\\d{2,4})\\b', '${day}-${month}-${year}')",
          {:attr "11/30/1972"})


  (do-test "cases/6.6_math.yaml")


  (is (= 1 (sut/fp "%v.a" {} {:v {:a 1}})))

  (sut/fp "%v.a" {} {:v {:a 1}})


  (do-test "cases/5.6_string_manipulation.yaml")
  (do-test "cases/5.7_tree_navigation.yaml")
  (do-test "cases/5.8_utility_functions.yaml")

  (println (apply str (repeat 80 "=")))

  (is (= (java.time.LocalDate/now)
         (parse-local (sut/fp "Functions.today()" {}))))

  (is (>= 1
         (.between java.time.temporal.ChronoUnit/SECONDS
                   (java.time.ZonedDateTime/now)
                   (parse-zoned (sut/fp "Functions.now()" {})))))

  (do-test "cases/8_variables.yaml")
  (do-test "cases/6.6_math.yaml")
  ;; (do-test "cases/6.1_equality.yaml")

  ;; (do-test "cases/6.5_boolean_logic.yaml")

  )





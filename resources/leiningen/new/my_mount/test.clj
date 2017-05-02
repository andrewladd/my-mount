(ns {{full-name}}.test
  (:require  [clojure.test :as t]
             [mount.core :as mount]
             [clojure.tools.logging :as log]))


(defn start []
  (mount/start #'{{full-name}}.config/config))

(defn stop []
  (mount/stop #'{{full-name}}.config/config))

(defn system [f]
  (start)
  (f)
  (stop))

(defn seed [f]
  (populate)
  (f)
  (wipe))

(t/deftest test-1
  (t/testing "Test 1.1"
    (t/is (nil? nil)))
  (t/testing "Test 1.2"
    (t/is (nil? nil))))

(t/deftest test-2
  (t/testing "Test 2.1"
    (t/is (nil? nil)))
  (t/testing "Test 2.2"
    (t/is (nil? nil))))

(t/use-fixtures :each system seed)

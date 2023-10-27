(ns clj-object-pool-benchmarks.core
  (:require [com.github.enragedginger.clj-pool-party.core :as pool-party]
            [biiwide.deepend.alpha.pool :as deepend-pool]
            [pool.core :as kul-pool])
  (:use [criterium.core])
  (:import (java.util UUID)
           (java.util.concurrent Executors)
           (org.apache.commons.pool2.impl GenericObjectPool)))

(defn- run-vthread-tasks [task-fn times]
  (let [tasks (repeatedly times (constantly task-fn))]
    (with-open [exec (Executors/newVirtualThreadPerTaskExecutor)]
      (->> (.invokeAll exec tasks)
        (map (memfn get))
        (dorun)))))

(defn gen-fn [& args]
  (UUID/randomUUID))
(def max-size 100)
(def times (* 2 max-size))

(defn clj-pool-party-multi-checkout []
  (let [pool (pool-party/build-pool gen-fn max-size {})
        task-fn (fn []
                  (pool-party/with-object pool identity))]
    (bench
      (run-vthread-tasks task-fn times))))

(defn deepend-pool-multi-checkout []
  (let [pool (deepend-pool/pool {:generate gen-fn
                                 :destroy (constantly nil)
                                 :max-objects max-size})
        task-fn (fn []
                  (deepend-pool/with-resource [my-obj pool nil]
                    (identity my-obj)))]
    (bench
      (run-vthread-tasks task-fn times))))

(defn kul-pool-multi-checkout []
  (let [^GenericObjectPool pool (kul-pool/get-pool gen-fn)
        task-fn (fn []
                  (let [obj (kul-pool/borrow pool)]
                    (identity obj)
                    (kul-pool/return pool obj)))]
    (bench
      (run-vthread-tasks task-fn times))))

(defn -main [& args]
  (println "Running clj-pool-party benchmark")
  (clj-pool-party-multi-checkout)
  (println "Running deepend benchmark")
  (deepend-pool-multi-checkout)
  (println "Running kul pool benchmark")
  (kul-pool-multi-checkout)
  )
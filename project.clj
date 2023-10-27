(defproject clj-object-pool-benchmarks "0.1.0-SNAPSHOT"
  :description "Benchmarks for comparing Clojure object pool libraries."
  :url "https://github.com/enragedginger/clj-object-pool-benchmarks"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [criterium "0.4.6"]
                 [com.github.enragedginger/clj-pool-party "0.2.0"]
                 [pool "0.3.0"]
                 [biiwide/deepend "0.0.5"]
                 ]
  :target-path "target/%s")

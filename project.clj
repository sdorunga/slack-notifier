(defproject carrers-slack "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.julienxx/clj-slack "0.5.2"]
                 [speclj "3.3.1"]]
  :main ^:skip-aot carrers-slack.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})

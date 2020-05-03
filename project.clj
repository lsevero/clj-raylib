(defproject clj-raylib "0.1.0-SNAPSHOT"
  :description "raylib in clojure"
  :url "http://www.github.com/lsevero/clj-raylib"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [net.java.dev.jna/jna "5.5.0"]]
  :min-lein-version "2.8.0"
  :java-source-paths ["java"]
  :profiles {:dev {:plugins [[cider/cider-nrepl "0.22.3"]]
                   :global-vars {*warn-on-reflection* true}
                   :main main.examples
                   :repl-options {:init-ns clj-curl.easy}
                   :source-paths ["src" "test" "examples"]}}
  :source-paths ["src"]
  :repl-options {:init-ns clj-raylib.core
                 :port 17020
                 })

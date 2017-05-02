(defproject {{full-name}} "0.1.0-SNAPSHOT"
  :description "TODO"
  :url "TODO"
  :license {:name "TODO: Choose a license"
            :url "http://choosealicense.com/"}
  :dependencies [[org.clojure/clojure "1.9.0-alpha14"]
                 [org.clojure/tools.logging "0.3.1"]
                 [org.clojure/core.cache "0.6.5"]
                 [mount "0.1.11"]
                 [environ "1.1.0"]
                 [cheshire "5.6.3"]
                 [clj-time "0.12.2"]
                 [clj-http "3.4.1"]
                 [camel-snake-kebab "0.4.0"]
                 ;; [io.grpc/grpc-protobuf "1.0.3"]
                 ;; [io.grpc/grpc-netty "1.0.3"]
                 ;; [io.grpc/grpc-stub "1.0.3"]
                 [ch.qos.logback/logback-classic "1.1.8"]
                 [org.clojure/core.async "0.2.395"]
                 [korma "0.4.3"]
                 [org.clojure/java.jdbc "0.6.1"]
                 [org.postgresql/postgresql "42.0.0"]
                 [clojure.jdbc/clojure.jdbc-c3p0 "0.3.2"]]
  :jar-name "{{name}}-%s.jar"
  :repositories [["michaelklishin" "https://dl.bintray.com/michaelklishin/maven/"]]
  :uberjar-name "{{name}}-standalone.jar"
  :java-source-paths ["src/java"]
  :plugins []
  :profiles {:dev {:dependencies [[org.clojure/tools.namespace "0.2.11"]]
                   :source-paths ["dev"]}

             :prod {:aot [{{full-name}}]
                    :uberjar true
                    :main {{full-name}}}
             })

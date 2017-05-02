(ns {{full-name}}
  (:gen-class)
  (:require [mount.core :as mount]
            [{{full-name}}.config :refer (config)]
            [clojure.tools.logging :as log]))

(defn start []
  (log/info "Starting {{name}} at {{date}}")
  (log/debugf "{{name}}'s environment defined as:\n %s" config)
  {:foo "test"})

(defn stop [{{name}}]
  (log/infof "Stopping {{name}} at {{date}} -- %s" (:foo {{name}})))

(mount/defstate {{name}}
  :start (start)
  :stop (stop {{name}}))

(defn -main [& args]
  (let [s (mount/start)
        is_running? (atom true)]
    (Thread/setDefaultUncaughtExceptionHandler
     (reify Thread$UncaughtExceptionHandler
       (uncaughtException [_ thread ex]
         (log/error ex "Uncaught exception on" (.getName thread)))))
    (.addShutdownHook
     (Runtime/getRuntime)
     (Thread. (fn []
                (println "Death is only an illusion...")
                (when s (mount/stop))
                (reset! is_running? false))))
    (while is_running?
      (log/debug "tick")
      (Thread/sleep 5000))))

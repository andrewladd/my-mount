(ns {{full-name}}.config
  (:require [mount.core :as mount]
            [environ.core :refer (env)]))

(mount/defstate config
  :start {:env (env :ladd-env)
          :project (env :ladd-project)})

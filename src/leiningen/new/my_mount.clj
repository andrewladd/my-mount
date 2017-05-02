(ns leiningen.new.my-mount
  (:require [leiningen.new.templates :refer [renderer year date project-name
                                             ->files sanitize-ns name-to-path
                                             multi-segment]]
            [leiningen.core.main :as main]))

(def render (renderer "my-mount"))

(defn my-mount
  "FIXME: write documentation"
  [name]
  (let [full "com.andrewladd"
        full-name (format "%s.%s" full name)
        data {:name name
              :project (project-name name)
              :full-name full-name
              :sanitized (name-to-path full)
              :date (date)
              :year (year)}]

    (main/info (format "Generating fresh 'lein new' my-mount project. %s" data))
    (->files data
             ["project.clj" (render "project.clj" data)]
             [".gitignore" (render ".gitignore" data)]
             ["README.md" (render "README.md" data)]
             ["workspace.env" (render "workspace.env" data)]

             ["src/{{sanitized}}/{{name}}.clj" (render "core.clj" data)]
             ["src/{{sanitized}}/{{name}}/config.clj" (render "config.clj" data)]
             ["dev/dev.clj" (render "dev.clj" data)]
             ["dev/user.clj" (render "user.clj" data)]

             ["test/{{sanitized}}/{{name}}/test.clj" (render "test.clj" data)]

             ["resources/logback.xml" (render "logback.xml" data)])))

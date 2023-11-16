(defproject org.clojars.ygorsimoes/openai-clj "0.1.0"
  :description "A simple, fast, and robust client library for the OpenAI API in Clojure."
  :url "https://github.com/ygorsimoes/openai-clj"
  :license {:name "MIT license"
            :url  "https://github.com/ygorsimoes/openai-clj/blob/main/LICENSE"}
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [prismatic/schema "1.4.1"]
                 [com.github.oliyh/martian "0.1.23"]
                 [com.github.oliyh/martian-clj-http "0.1.23"]]
  :repl-options {:init-ns openai-clj.core})
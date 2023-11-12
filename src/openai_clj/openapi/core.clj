(ns ^:no-doc openai-clj.openapi.core
  (:require [martian.clj-http :as martian-http]
            [martian.core :as martian]
            [openai-clj.openapi.header :as header]
            [openai-clj.openapi.interceptor :as interceptor]
            [openai-clj.openapi.multipart :as multipart]
            [openai-clj.openapi.utils :as utils]))

(defn- configure-http-interceptors
  "Configures the HTTP interceptors for the Martian client, removing the default perform-request interceptor and appending custom interceptors."
  []
  (-> martian-http/default-opts
      (:interceptors)
      interceptor/remove-perform-request-interceptor
      (interceptor/append-interceptors [header/add-headers
                                        (interceptor/multipart-form-data-encoder)
                                        multipart/multipart-form-data])))

(defn- initialize-martian-client
  "Initializes the Martian client with custom interceptors and configurations for handling file operations."
  []
  (let [openapi-yaml "resources/openapi.yaml"
        opts {:interceptors (configure-http-interceptors)}]
    (-> (martian-http/bootstrap-openapi openapi-yaml opts)
        utils/configure-file-handling-for-operations)))

(defn response-for
  "Executes an API operation using the Martian client. It sets up request options and extracts the response body.
   This version does not require options."
  ([operation params]
   (response-for operation params {}))
  ([operation params options]
   (let [client (initialize-martian-client)]
     (-> (martian/response-for client operation (assoc params ::options options)) :body))))
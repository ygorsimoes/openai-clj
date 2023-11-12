(ns ^:no-doc openai-clj.openapi.multipart
  (:import (java.io File InputStream)))

(defn- is-multipart-form-data?
  "Checks if the given handler is meant for handling multipart/form-data content type."
  [handler]
  (boolean (-> handler
               :openapi-definition
               :requestBody
               :content
               :multipart/form-data)))

(defn- create-multipart-entry
  "Creates a multipart entry for a given parameter and its content. Supports File, InputStream, byte arrays, or general objects (as strings)."
  [param content]
  {:name    (name param)
   :content (cond
              (instance? File content) content
              (instance? InputStream content) content
              (bytes? content) content
              :else (str content))})

(defn- process-multipart-params
  "Processes all parameters intended for multipart/form-data submission, converting them into multipart entries."
  [params]
  (map (fn [[param content]] (create-multipart-entry param content)) params))

(defn- remove-content-type
  "Removes the 'Content-Type' header from the request context. This is necessary when handling multipart/form-data as the content type is set automatically."
  [http-context]
  (update-in http-context [:request :headers] dissoc "Content-Type"))

(defn- remove-body
  "Removes the body from the request context. This is used in multipart/form-data handling where the body is processed differently."
  [http-context]
  (update http-context :request dissoc :body))

(def multipart-form-data
  {:name  ::multipart-form-data
   :enter (fn [{:keys [handler params] :as http-context}]
            "Main interceptor for handling multipart/form-data. It checks if the handler requires multipart processing and updates the request context accordingly."
            (if (is-multipart-form-data? handler)
              (-> http-context
                  (assoc-in [:request :multipart] (process-multipart-params params))
                  remove-content-type
                  remove-body)
              http-context))})
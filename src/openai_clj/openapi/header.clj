(ns openai-clj.openapi.header)

(defn- get-api-key
  "Retrieves the API key from the request context. If not found in the context, tries to get it from the system environment."
  [context]
  (or (-> context :params :openai-clj.openapi.core/options :api-key)
      (System/getenv "OPENAI_API_KEY")))

(defn- get-organization
  "Retrieves the organization identifier from the request context. If not found in the context, tries to get it from the system environment."
  [context]
  (or (-> context :params :openai-clj.openapi.core/options :organization)
      (System/getenv "OPENAI_ORGANIZATION")))

(defn- get-openai-beta
  "Retrieves the OpenAI Beta setting from the request context. This is used for enabling beta features if available."
  [context]
  (-> context :params :openai-clj.openapi.core/options :openai-beta))

(defn- add-header-if-present
  "Adds a header to the HTTP request if the value is not empty. Helps in conditionally adding headers like API key, organization, etc."
  [headers key value]
  (if (not-empty value)
    (assoc headers key value)
    headers))

(def add-headers
  {:name  ::add-headers
   :enter (fn [context]
            "Interceptor function for HTTP requests. Adds necessary headers like API key, organization, and OpenAI Beta settings to the request."
            (let [api-key (get-api-key context)
                  organization (get-organization context)
                  openai-beta (get-openai-beta context)]
              (-> context
                  (update-in [:request :headers]
                             (fn [headers]
                               (-> headers
                                   (add-header-if-present "Authorization" (when api-key (str "Bearer " api-key)))
                                   (add-header-if-present "OpenAI-Organization" organization)
                                   (add-header-if-present "OpenAI-Beta" openai-beta)))))))})
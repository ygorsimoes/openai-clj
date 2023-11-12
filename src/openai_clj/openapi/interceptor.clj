(ns ^:no-doc openai-clj.openapi.interceptor
  (:require [martian.encoders :as encoders]
            [martian.interceptors :as interceptors]))

(defn remove-perform-request-interceptor
  "Remove the :martian.hato/perform-request interceptor from the given list of interceptors."
  [interceptors]
  (remove (comp #{:martian.hato/perform-request} :name) interceptors))

(defn append-interceptors
  "Append a list of new interceptors to the existing list of interceptors."
  [existing-interceptors new-interceptors]
  (concat existing-interceptors new-interceptors))

(defn multipart-form-data-encoder
  "Create an encoder for multipart/form-data with the default encoders, but setting multipart/form-data to nil."
  []
  (interceptors/encode-body (assoc (encoders/default-encoders) "multipart/form-data" nil)))
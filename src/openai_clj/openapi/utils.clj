(ns ^:no-doc openai-clj.openapi.utils
  (:require [martian.core :as martian])
  (:import (java.io File)))

(defn update-handler-for-file-field
  "Updates a specific operation in the API client to handle a file field."
  [api-client operation-id field-name]
  (martian/update-handler api-client operation-id assoc-in [:body-schema :body field-name] File))

(defn configure-file-handling-for-operations
  "Configures multiple operations in the API client for file handling."
  [api-client]
  (reduce (fn [client [op-id field]]
            (update-handler-for-file-field client op-id field))
          api-client
          [[:create-transcription :file]
           [:create-translation :file]
           [:create-file :file]
           [:create-image-edit :image]
           [:create-image-edit (schema.core/optional-key :mask)]
           [:create-image-variation :image]]))

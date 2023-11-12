(ns openai-clj.images
  (:require [openai-clj.openapi.core :as openapi]))

(defn create-image
  "Creates an image given a prompt.

  Example:
  ```
  (create-image {:prompt \"A cute baby sea otter\"
                 :n 2
                 :size \"1024x1024\"})
  ```

  Response:
  ```
  {\n  \"created\": 1589478378,\n  \"data\": [\n    {\n      \"url\": \"https://...\"\n    },\n    {\n      \"url\": \"https://...\"\n    }\n  ]\n}\n
  ```

  Also see the [OpenAI documentation](https://platform.openai.com/docs/api-reference/images/create)"
  ([params]
   (create-image params {}))
  ([params options]
   (openapi/response-for :create-image params options)))

(defn create-image-edit
  "Creates an edited or extended image given an original image and a prompt.

  Example:
  ```
  (create-image-edit {:image (clojure.java.io/file \"path/to/otter.png\")
                      :mask (clojure.java.io/file \"path/to/mask.png\")
                      :prompt \"A cute baby sea otter wearing a beret\"
                      :n 2
                      :size \"1024x1024\"})
  ```

  Response:
  ```
  {\n  \"created\": 1589478378,\n  \"data\": [\n    {\n      \"url\": \"https://...\"\n    },\n    {\n      \"url\": \"https://...\"\n    }\n  ]\n}\n
  ```

  Also see the [OpenAI documentation](https://platform.openai.com/docs/api-reference/images/createEdit)"
  ([params]
   (create-image-edit params {}))
  ([params options]
   (openapi/response-for :create-image-edit params options)))

(defn create-image-variation
  "Creates a variation of a given image.

  Example:
  ```
  (create-image-variation {:image (clojure.java.io/file \"path/to/otter.png\")
                           :n 2
                           :size \"1024x1024\"})
  ```

  Response:
  ```
  {\n  \"created\": 1589478378,\n  \"data\": [\n    {\n      \"url\": \"https://...\"\n    },\n    {\n      \"url\": \"https://...\"\n    }\n  ]\n}\n
  ```

  Also see the [OpenAI documentation](https://platform.openai.com/docs/api-reference/images/createVariation)"
  ([params]
   (create-image-variation params {}))
  ([params options]
   (openapi/response-for :create-image-variation params options)))



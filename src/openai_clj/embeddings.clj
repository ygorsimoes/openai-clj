(ns openai-clj.embeddings
  (:require [openai-clj.openapi.core :as openapi]))

(defn create-embedding
  "Creates an embedding vector representing the input text.

  Example:
  ```
  (create-embedding {:model \"text-embedding-ada-002\"
                     :input \"The food was delicious and the waiter...\"})
  ```

  Response:
  ```
  {\n  \"object\": \"list\",\n  \"data\": [\n    {\n      \"object\": \"embedding\",\n      \"embedding\": [\n        0.0023064255,\n        -0.009327292,\n        .... (1536 floats total for ada-002)\n        -0.0028842222,\n      ],\n      \"index\": 0\n    }\n  ],\n  \"model\": \"text-embedding-ada-002\",\n  \"usage\": {\n    \"prompt_tokens\": 8,\n    \"total_tokens\": 8\n  }\n}\n
  ```

  Also see the [OpenAI documentation](https://platform.openai.com/docs/api-reference/embeddings/create)"
  ([params]
   (create-embedding params {}))
  ([params options]
   (openapi/response-for :create-embedding params)))
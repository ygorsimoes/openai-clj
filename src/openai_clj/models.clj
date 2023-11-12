(ns openai-clj.models
  (:require [openai-clj.openapi.core :as openapi]))

(defn list-models
  "Lists the currently available models, and provides basic information about each one such as the owner and availability.

  Example:
  ```
  (list-models)
  ```

  Response:
  ```
  {\n  \"object\": \"list\",\n  \"data\": [\n    {\n      \"id\": \"model-id-0\",\n      \"object\": \"model\",\n      \"created\": 1686935002,\n      \"owned_by\": \"organization-owner\"\n    },\n    {\n      \"id\": \"model-id-1\",\n      \"object\": \"model\",\n      \"created\": 1686935002,\n      \"owned_by\": \"organization-owner\",\n    },\n    {\n      \"id\": \"model-id-2\",\n      \"object\": \"model\",\n      \"created\": 1686935002,\n      \"owned_by\": \"openai\"\n    },\n  ],\n  \"object\": \"list\"\n}\n
  ```

  Also see the [OpenAI documentation](https://platform.openai.com/docs/api-reference/models/list)"
  ([]
   (list-models {}))
  ([options]
   (openapi/response-for :list-models {} options)))

(defn retrieve-model
  "Retrieves a model instance, providing basic information about the model such as the owner and permissioning.

  Example:
  ```
  (retrieve-model {:model \"gpt-3.5-turbo-instruct\"})
  ```

  Response:
  ```
  {\n  \"id\": \"gpt-3.5-turbo-instruct\",\n  \"object\": \"model\",\n  \"created\": 1686935002,\n  \"owned_by\": \"openai\"\n}\n
  ```

  Also see the [OpenAI documentation](https://platform.openai.com/docs/api-reference/models/retrieve)"
  ([params]
   (retrieve-model params {}))
  ([params options]
   (openapi/response-for :retrieve-model params options)))
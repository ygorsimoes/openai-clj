(ns openai-clj.moderations
  (:require [openai-clj.openapi.core :as openapi]))

(defn create-moderation
  "Classifies if text violates OpenAI's Content Policy

  Example:
  ```
  (create-moderation {:input \"I want to kill them\"})
  ```

  Response:
  ```
  {\n  \"id\": \"modr-XXXXX\",\n  \"model\": \"text-moderation-005\",\n  \"results\": [\n    {\n      \"flagged\": true,\n      \"categories\": {\n        \"sexual\": false,\n        \"hate\": false,\n        \"harassment\": false,\n        \"self-harm\": false,\n        \"sexual/minors\": false,\n        \"hate/threatening\": false,\n        \"violence/graphic\": false,\n        \"self-harm/intent\": false,\n        \"self-harm/instructions\": false,\n        \"harassment/threatening\": true,\n        \"violence\": true,\n      },\n      \"category_scores\": {\n        \"sexual\": 1.2282071e-06,\n        \"hate\": 0.010696256,\n        \"harassment\": 0.29842457,\n        \"self-harm\": 1.5236925e-08,\n        \"sexual/minors\": 5.7246268e-08,\n        \"hate/threatening\": 0.0060676364,\n        \"violence/graphic\": 4.435014e-06,\n        \"self-harm/intent\": 8.098441e-10,\n        \"self-harm/instructions\": 2.8498655e-11,\n        \"harassment/threatening\": 0.63055265,\n        \"violence\": 0.99011886,\n      }\n    }\n  ]\n}\n
  ```

  Also see the [OpenAI documentation](https://platform.openai.com/docs/api-reference/moderations/create)"
  ([params]
   (create-moderation params {}))
  ([params options]
   (openapi/response-for :create-moderation params options)))
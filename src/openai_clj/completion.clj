(ns openai-clj.completion
  (:require [openai-clj.openapi.core :as openapi]))

(defn create-completion
  "Creates a completion for the provided prompt and parameters.

  Example:
  ```
  (create-completion {:model \"gpt-3.5-turbo-instruct\"
                      :prompt \"Say this is a test\"
                      :max_tokens 7
                      :temperature 0})
  ```

  Response:
  ```
  {\n  \"id\": \"cmpl-uqkvlQyYK7bGYrRHQ0eXlWi7\",\n  \"object\": \"text_completion\",\n  \"created\": 1589478378,\n  \"model\": \"gpt-3.5-turbo-instruct\",\n  \"system_fingerprint\": \"fp_44709d6fcb\",\n  \"choices\": [\n    {\n      \"text\": \"\\n\\nThis is indeed a test\",\n      \"index\": 0,\n      \"logprobs\": null,\n      \"finish_reason\": \"length\"\n    }\n  ],\n  \"usage\": {\n    \"prompt_tokens\": 5,\n    \"completion_tokens\": 7,\n    \"total_tokens\": 12\n  }\n}\n
  ```

  Also see the [OpenAI documentation](https://platform.openai.com/docs/api-reference/completions/create)"
  ([params]
   (create-completion params {}))
  ([params options]
   (openapi/response-for :create-completion params options)))


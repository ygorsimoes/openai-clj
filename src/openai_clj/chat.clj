(ns openai-clj.chat
  (:require [openai-clj.openapi.core :as openapi]))

(defn create-chat-completion
  "Creates a model response for the given chat conversation.

  Example:
  ```
  (create-chat-completion {:model \"gpt-3.5-turbo\"
                           :messages [{:role \"system\" :content \"You are a helpful assistant.\"}]})
  ```

  Response:
  ```
  {\n  \"id\": \"chatcmpl-123\",\n  \"object\": \"chat.completion\",\n  \"created\": 1677652288,\n  \"model\": \"gpt-3.5-turbo-0613\",\n  \"system_fingerprint\": \"fp_44709d6fcb\",\n  \"choices\": [{\n    \"index\": 0,\n    \"message\": {\n      \"role\": \"assistant\",\n      \"content\": \"\\n\\nHello there, how may I assist you today?\",\n    },\n    \"finish_reason\": \"stop\"\n  }],\n  \"usage\": {\n    \"prompt_tokens\": 9,\n    \"completion_tokens\": 12,\n    \"total_tokens\": 21\n  }\n}\n
  ```

  Also see the [OpenAI documentation](https://platform.openai.com/docs/api-reference/chat/create)"
  ([params]
   (create-chat-completion params {}))
  ([params options]
   (openapi/response-for :create-chat-completion params options)))

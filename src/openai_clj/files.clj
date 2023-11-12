(ns openai-clj.files
  (:require [openai-clj.openapi.core :as openapi]))

(defn list-files
  "Returns a list of files that belong to the user's organization.

  Example:
  ```
  (list-files)
  ```

  Response:
  ```
  {\n  \"data\": [\n    {\n      \"id\": \"file-abc123\",\n      \"object\": \"file\",\n      \"bytes\": 175,\n      \"created_at\": 1613677385,\n      \"filename\": \"salesOverview.pdf\",\n      \"purpose\": \"assistants\",\n    },\n    {\n      \"id\": \"file-abc123\",\n      \"object\": \"file\",\n      \"bytes\": 140,\n      \"created_at\": 1613779121,\n      \"filename\": \"puppy.jsonl\",\n      \"purpose\": \"fine-tune\",\n    }\n  ],\n  \"object\": \"list\"\n}\n
  ```

  Also see the [OpenAI documentation](https://platform.openai.com/docs/api-reference/files/list)"
  ([]
   (list-files {}))
  ([options]
   (openapi/response-for :list-files {} options)))

(defn create-file
  "Upload a file that can be used across various endpoints. The size of all the files uploaded by one organization can be up to 100 GB.

  Example:
  ```
  (create-file {:purpose \"fine-tune\"
                :file (clojure.java.io/file \"path/to/fine-tune.jsonl\")})
  ```

  Response:
  ```
  {\n  \"id\": \"file-abc123\",\n  \"object\": \"file\",\n  \"bytes\": 120000,\n  \"created_at\": 1677610602,\n  \"filename\": \"mydata.jsonl\",\n  \"purpose\": \"fine-tune\",\n}\n
  ```

  Also see the [OpenAI documentation](https://platform.openai.com/docs/api-reference/files/create)"
  ([params]
   (create-file params {}))
  ([params options]
   (openapi/response-for :create-file params options)))


(defn delete-file
  "Delete a file.

  Example:
  ```
  (delete-file {:file-id \"file-wefuhweof\"})
  ```

  Response:
  ```
  {\n  \"id\": \"file-abc123\",\n  \"object\": \"file\",\n  \"deleted\": true\n}\n
  ```

  Also see the [OpenAI documentation](https://platform.openai.com/docs/api-reference/files/delete)"
  ([params]
   (delete-file params {}))
  ([params options]
   (openapi/response-for :delete-file params options)))

(defn retrieve-file
  "Returns information about a specific file.

  Example:
  ```
  (retrieve-file {:file-id \"file-wefuhweof\"})
  ```

  Response:
  ```
  {\n  \"id\": \"file-abc123\",\n  \"object\": \"file\",\n  \"bytes\": 120000,\n  \"created_at\": 1677610602,\n  \"filename\": \"mydata.jsonl\",\n  \"purpose\": \"fine-tune\",\n}\n
  ```

  Also see the [OpenAI documentation](https://platform.openai.com/docs/api-reference/files/retrieve)"
  ([params]
   (retrieve-file params {}))
  ([params options]
   (openapi/response-for :retrieve-file params options)))

(defn download-file
  "Returns the contents of the specified file

  Example:
  ```
  (download-file {:file-id \"file-wefuhweof\"})
  ```

  Also see the [OpenAI documentation](https://platform.openai.com/docs/api-reference/files/retrieve-contents)"
  ([params]
   (download-file params {}))
  ([params options]
   (openapi/response-for :download-file params options)))
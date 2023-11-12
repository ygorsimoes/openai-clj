(ns openai-clj.fine-tuning
  (:require [openai-clj.openapi.core :as openapi]))

(defn create-fine-tuning-job
  "Creates a job that fine-tunes a specified model from a given dataset.\n\nResponse includes details of the enqueued job including job status and the name of the fine-tuned models once complete.

  Example:
  ```
  (create-fine-tuning-job {:training_file \"file-xuhfiwuefb\"
                           :model \"gpt-3.5-turbo\"})
  ```

  Response:
  ```
  {\n  \"object\": \"fine_tuning.job\",\n  \"id\": \"ftjob-abc123\",\n  \"model\": \"gpt-3.5-turbo-0613\",\n  \"created_at\": 1614807352,\n  \"fine_tuned_model\": null,\n  \"organization_id\": \"org-123\",\n  \"result_files\": [],\n  \"status\": \"queued\",\n  \"validation_file\": null,\n  \"training_file\": \"file-abc123\",\n}\n
  ```

  Also see the [OpenAI documentation](https://platform.openai.com/docs/api-reference/fine-tuning/create)"
  ([params]
   (create-fine-tuning-job params {}))
  ([params options]
   (openapi/response-for :create-fine-tuning-job params options)))

(defn list-fine-tuning-jobs
  "List your organization's fine-tuning jobs.

  Example:
  ```
  (list-fine-tuning-jobs)
  ```

  Response:
  ```
  {\n  \"object\": \"list\",\n  \"data\": [\n    {\n      \"object\": \"fine_tuning.job.event\",\n      \"id\": \"ft-event-TjX0lMfOniCZX64t9PUQT5hn\",\n      \"created_at\": 1689813489,\n      \"level\": \"warn\",\n      \"message\": \"Fine tuning process stopping due to job cancellation\",\n      \"data\": null,\n      \"type\": \"message\"\n    },\n    { ... },\n    { ... }\n  ], \"has_more\": true\n}\n
  ```

  Also see the [OpenAI documentation](https://platform.openai.com/docs/api-reference/fine-tuning/list)"
  ([]
   (list-fine-tuning-jobs {}))
  ([options]
   (openapi/response-for :list-paginated-fine-tuning-jobs {} options)))

(defn retrieve-fine-tuning-job
  "Gets info about a fine-tuning job.

  Example:
  ```
  (retrieve-fine-tuning-job {:fine_tuning_job_id \"ft-1wefweub\"})
  ```

  Response:
  ```
  {\n  \"object\": \"fine_tuning.job\",\n  \"id\": \"ftjob-abc123\",\n  \"model\": \"davinci-002\",\n  \"created_at\": 1692661014,\n  \"finished_at\": 1692661190,\n  \"fine_tuned_model\": \"ft:davinci-002:my-org:custom_suffix:7q8mpxmy\",\n  \"organization_id\": \"org-123\",\n  \"result_files\": [\n      \"file-abc123\"\n  ],\n  \"status\": \"succeeded\",\n  \"validation_file\": null,\n  \"training_file\": \"file-abc123\",\n  \"hyperparameters\": {\n      \"n_epochs\": 4,\n  },\n  \"trained_tokens\": 5768\n}\n
  ```

  Also see the [OpenAI documentation](https://platform.openai.com/docs/api-reference/fine-tuning/retrieve)"
  ([params]
   (retrieve-fine-tuning-job params {}))
  ([params options]
   (openapi/response-for :retrieve-fine-tuning-job params options)))

(defn cancel-fine-tuning-job
  "Immediately cancel a fine-tuning job.

  Example:
  ```
  (cancel-fine-tuning-job {:fine_tuning_job_id \"ft-1wefweub\"})
  ```

  Response:
  ```
  {\n  \"object\": \"fine_tuning.job\",\n  \"id\": \"ftjob-abc123\",\n  \"model\": \"gpt-3.5-turbo-0613\",\n  \"created_at\": 1689376978,\n  \"fine_tuned_model\": null,\n  \"organization_id\": \"org-123\",\n  \"result_files\": [],\n  \"hyperparameters\": {\n    \"n_epochs\":  \"auto\"\n  },\n  \"status\": \"cancelled\",\n  \"validation_file\": \"file-abc123\",\n  \"training_file\": \"file-abc123\"\n}\n
  ```

  Also see the [OpenAI documentation](https://platform.openai.com/docs/api-reference/fine-tuning/cancel)"
  ([params]
   (cancel-fine-tuning-job params {}))
  ([params options]
   (openapi/response-for :cancel-fine-tuning-job params options)))

(defn list-fine-tuning-events
  "Get status updates for a fine-tuning job.

  Example:
  ```
  (list-fine-tuning-events {:fine_tuning_job_id \"ft-1wefweub\"})
  ```

  Response:
  ```
  {\n  \"object\": \"list\",\n  \"data\": [\n    {\n      \"object\": \"fine_tuning.job.event\",\n      \"id\": \"ft-event-ddTJfwuMVpfLXseO0Am0Gqjm\",\n      \"created_at\": 1692407401,\n      \"level\": \"info\",\n      \"message\": \"Fine tuning job successfully completed\",\n      \"data\": null,\n      \"type\": \"message\"\n    },\n    {\n      \"object\": \"fine_tuning.job.event\",\n      \"id\": \"ft-event-tyiGuB72evQncpH87xe505Sv\",\n      \"created_at\": 1692407400,\n      \"level\": \"info\",\n      \"message\": \"New fine-tuned model created: ft:gpt-3.5-turbo:openai::7p4lURel\",\n      \"data\": null,\n      \"type\": \"message\"\n    }\n  ],\n  \"has_more\": true\n}\n
  ```

  Also see the [OpenAI documentation](https://platform.openai.com/docs/api-reference/fine-tuning/events)"
  ([params]
   (list-fine-tuning-events params {}))
  ([params options]
   (openapi/response-for :list-fine-tuning-events params options)))
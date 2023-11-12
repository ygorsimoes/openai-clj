(ns openai-clj.audio
  (:require [openai-clj.openapi.core :as openapi]))

(defn create-transcription
  "Transcribes audio into the input language.

  Example:
  ```
  (create-transcription {:file (clojure.java.io/file \"path/to/audio.mp3\")
                         :model \"whisper-1\"})
  ```

  Response:
  ```
  {\n  \"text\": \"Imagine the wildest idea that you've ever had, and you're curious about how it might scale tosomething that's a 100, a 1,000 times bigger. This is a place where you can get to do that.\"\n}\n
  ```

  Also see the [OpenAI documentation](https://platform.openai.com/docs/api-reference/audio/createTranscription)"
  ([params]
   (create-transcription params {}))
  ([params options]
   (openapi/response-for :create-transcription params options)))

(defn create-translation
  "Translates audio into English.

  Example:
  ```
  (create-translation {:file (clojure.java.io/file \"path/to/file/german.m4a\")
                       :model \"whisper-1\"})
  ```

  Response:
  ```
  {\n  \"text\": \"Hello, my name is Wolfgang and I come from Germany. Where are you heading today?\"\n}\n
  ```

  Also see the [OpenAI documentation](https://platform.openai.com/docs/api-reference/audio/createTranslation)"
  ([params]
   (create-translation params {}))
  ([params options]
   (openapi/response-for :create-translation params options)))
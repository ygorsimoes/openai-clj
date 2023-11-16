# Usage

Visit the official [OpenAI documentation](https://platform.openai.com/docs) for more information.

## Configuration

Add the `openai-clj` dependency:

### Leiningen/Boot

```clojure
[org.clojars.ygorsimoes/openai-clj "0.1.1-SNAPSHOT"]
```

### Clojure CLI/deps.edn

```clojure
org.clojars.ygorsimoes/openai-clj {:mvn/version "0.1.1-SNAPSHOT"}
```

### Gradle

```groovy
implementation("org.clojars.ygorsimoes:openai-clj:0.1.1-SNAPSHOT")
```

### Maven

```xml
<dependency>
    <groupId>org.clojars.ygorsimoes</groupId>
    <artifactId>openai-clj</artifactId>
    <version>0.1.1-SNAPSHOT</version>
</dependency>
```

## Authentication

You can configure the library by setting environment variables:

`OPENAI_API_KEY`: You can generate your API Key by accessing
your [OpenAI account](https://platform.openai.com/api-keys).

`OPENAI_ORGANIZATION` (Optional): You can find your organization by accessing
your [OpenAI account](https://platform.openai.com/account/organization).

Alternatively, you can pass the `:api-key` and/or `:organization` in the options argument of each api function:

```clojure
{:api-key      "YOUR-API-KEY"
 :organization "YOUR-ORGANIZATION"}
```

## Quickstart

See the full [API Reference](https://cljdoc.org/d/org.clojars.ygorsimoes/openai-clj/0.1.1-SNAPSHOT/api/openai-clj) api
documentation for examples of all the supported OpenAI APIs.

Add namespace in your project:

```clojure
(:require [openai-clj.chat :as chat])
```

A simple chat conversation with ChatGPT could be:

```clojure
(chat/create-chat-completion {:model    "gpt-3.5-turbo"
                              :messages [{:role "system" :content "You are a helpful assistant."}
                                         {:role "user" :content "Who won the world series in 2020?"}
                                         {:role "assistant" :content "The Los Angeles Dodgers won the World Series in 2020."}
                                         {:role "user" :content "Where was it played?"}]})
```

Alternatively the `api-key` and/or `organization` can be passed in the options argument of each api function:

```clojure
(chat/create-chat-completion {:model        "gpt-3.5-turbo"
                              :messages     [{:role "system" :content "You are a helpful assistant."}
                                             {:role "user" :content "Who won the world series in 2020?"}
                                             {:role "assistant" :content "The Los Angeles Dodgers won the World Series in 2020."}
                                             {:role "user" :content "Where was it played?"}]
                              :api-key      "YOUR-API-KEY"
                              :organization "YOUR-ORGANIZATION"})
```

Result:

```json
{
  "id": "chatcmpl-123",
  "object": "chat.completion",
  "created": 1677652288,
  "model": "gpt-3.5-turbo-0613",
  "system_fingerprint": "fp_44709d6fcb",
  "choices": [
    {
      "index": 0,
      "message": {
        "role": "assistant",
        "content": "\n\nHello there, how may I assist you today?"
      },
      "finish_reason": "stop"
    }
  ],
  "usage": {
    "prompt_tokens": 9,
    "completion_tokens": 12,
    "total_tokens": 21
  }
}
```
# openai-clj [![Clojars Project](https://img.shields.io/clojars/v/org.clojars.ygorsimoes/openai-clj.svg)](https://clojars.org/org.clojars.ygorsimoes/openai-clj)

A simple, fast, and robust community-maintained Clojure client library for accessing the OpenAI API.

# Documentation

- [Usage](https://github.com/ygorsimoes/openai-clj/blob/main/doc/USAGE.md)
    - [Configuration](https://github.com/ygorsimoes/openai-clj/blob/main/doc/USAGE.md#configuration)
        - [Leiningen/Boot](https://github.com/ygorsimoes/openai-clj/blob/main/doc/USAGE.md#leiningenboot)
        - [Clojure CLI/deps.edn](https://github.com/ygorsimoes/openai-clj/blob/main/doc/USAGE.md#clojure-clidepsedn)
        - [Gradle](https://github.com/ygorsimoes/openai-clj/blob/main/doc/USAGE.md#gradle)
        - [Maven](https://github.com/ygorsimoes/openai-clj/blob/main/doc/USAGE.md#maven)
    - [Authentication](https://github.com/ygorsimoes/openai-clj/blob/main/doc/USAGE.md#authentication)
    - [Quickstart](https://github.com/ygorsimoes/openai-clj/blob/main/doc/USAGE.md#authentication)
- [API Reference](https://cljdoc.org/d/org.clojars.ygorsimoes/openai-clj/0.1.1-SNAPSHOT/api/openai-clj)

# Authentication

Set your environment variables to: `OPENAI_API_KEY` and/or `OPENAI_ORGANIZATION` to authenticate with the OpenAI API.

For another alternative to access your api key and organization, access
the [authentication documentation](https://github.com/ygorsimoes/openai-clj/blob/main/doc/USAGE.md#authentication).

# Quickstart

Demonstration of a simple library use case. For more specific demonstrations, access
the [usage documentation](https://github.com/ygorsimoes/openai-clj/blob/main/doc/USAGE.md).

Add namespace in your project:

```clojure
(:require [openai-clj.completion :as completion])
```

Creates a completion:

```clojure
(completion/create-completion {:model  "gpt-3.5-turbo-instruct"
                               :prompt "Say this is a test"})
```

# Contributing

Contributions are welcome! Please feel free to open new issues and submit pull requests.

# Acknowledgements

This library was inspired by [wkok/openai-clojure](https://github.com/wkok/openai-clojure), which served as a base and
learning experience for me to delve even deeper into the Clojure language.

# License

`openai-clj` is made with ❤️ by [Ygor Simões](https://github.com/account) and it's released under
the [MIT license](https://github.com/ygorsimoes/openai-clj/blob/main/LICENSE).
package com.example.aiblogcontentgenerator.model

import com.fasterxml.jackson.annotation.JsonProperty

data class CompletionRequest(
        @JsonProperty("prompt")
        val prompt: String,
        @JsonProperty("model")
        val model: String = "text-davinci-003",
        @JsonProperty("max_tokens")
        val maxTokens: Int = 1000,
        @JsonProperty("temperature")
        val temperature: Int = 0
)
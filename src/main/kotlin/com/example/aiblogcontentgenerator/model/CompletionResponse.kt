package com.example.aiblogcontentgenerator.model

import com.fasterxml.jackson.annotation.JsonProperty

data class CompletionResponse (
        @JsonProperty("id")
        val id: String,
        @JsonProperty("object")
        val `object`: String,
        @JsonProperty("created")
        val created: String,
        @JsonProperty("model")
        val model: String,
        @JsonProperty("choices")
        val choices: List<Choice>,
        @JsonProperty("usage")
        val usage: Usage
)

data class Usage(
        @JsonProperty("prompt_tokens")
        val promptTokens: Int,
        @JsonProperty("completion_tokens")
        val completionTokens: Int,
        @JsonProperty("total_tokens")
        val totalTokens: Int
)

data class Choice(
        @JsonProperty("text")
        val text: String,
        @JsonProperty("finish_reason")
        val finishReason: String,
        @JsonProperty("index")
        val index: Int,
        @JsonProperty("logprobs")
        val logprobs: String?
)
package com.example.aiblogcontentgenerator.api

import com.example.aiblogcontentgenerator.model.CompletionRequest
import com.example.aiblogcontentgenerator.model.CompletionResponse
import mu.two.KotlinLogging
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder

private val logger = KotlinLogging.logger {}

@Service
class GPTClient(
        private val restTemplate: RestTemplate,
        @Value("\${gpt.api.url}")
        private val gptApiUrl: String,
        @Value("\${gpt.api.key}")
        private val gptApiKey: String
) {
    fun completePrompt(prompt: String): CompletionResponse {
        val url: String = buildUrl("/v1/completions")
        val headers: HttpHeaders = buildHeaders()
        val requestBody = CompletionRequest(prompt)
        val requestEntity: HttpEntity<CompletionRequest> = HttpEntity(requestBody, headers)
        logger.info { "Sending request to $url: $requestBody" }
        val responseEntity: ResponseEntity<CompletionResponse> =
                restTemplate.exchange(
                        url,
                        HttpMethod.POST,
                        requestEntity,
                        CompletionResponse::class.java
                )
        return responseEntity.body ?: throw RuntimeException("Failed to get completion response")
    }

    private fun buildUrl(endpoint: String): String {
        return UriComponentsBuilder
                .fromHttpUrl(gptApiUrl)
                .path(endpoint)
                .toUriString()
    }

    private fun buildHeaders(): HttpHeaders {
        val headers = HttpHeaders()
        headers.set(HttpHeaders.AUTHORIZATION, "Bearer $gptApiKey")
        headers.set(HttpHeaders.CONTENT_TYPE, "application/json")
        return headers
    }
}
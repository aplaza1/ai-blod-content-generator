package com.example.aiblogcontentgenerator.service

import com.example.aiblogcontentgenerator.api.GPTClient
import org.springframework.stereotype.Service

@Service
class ContentGeneratorService (
        private val gptClient: GPTClient
) {
    fun generateContent(prompt: String): String {
        return gptClient.completePrompt(prompt).choices[0].text
    }
}
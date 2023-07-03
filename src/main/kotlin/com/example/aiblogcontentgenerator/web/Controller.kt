package com.example.aiblogcontentgenerator.web

import com.example.aiblogcontentgenerator.service.ContentGeneratorService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller(
        private val contentGeneratorService: ContentGeneratorService
) {
    @PostMapping("/generate")
    fun generateContent(@RequestBody prompt: String): String {
        return contentGeneratorService.generateContent(prompt)
    }
}
package com.example.aiblogcontentgenerator.api

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.web.client.RestTemplate

@Configuration
class RestTemplateConfig(private val mappingJackson2HttpMessageConverter: MappingJackson2HttpMessageConverter) {
    @Bean
    fun restTemplate(): RestTemplate {
        val restTemplate = RestTemplate()
        restTemplate.messageConverters.add(0, mappingJackson2HttpMessageConverter)
        return restTemplate
    }
}
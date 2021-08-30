package com.example.eventsdemo.external

import com.example.eventsdemo.core.JmsService
import org.springframework.stereotype.Component

@Component
class S3ConsumerService(
    jmsService: JmsService
) {
    init {
        jmsService.addListener("s3consumer", ::process)
    }

    fun process(message: String) {
        println("receive: $message")
    }
}

package com.example.eventsdemo.s3

import com.example.eventsdemo.core.JmsService
import org.springframework.stereotype.Component

@Component
class S3PostProcessor(
    private val jmsService: JmsService
) {
    init {
        jmsService.addListener("4ch", ::sendNext)
    }

    fun sendNext(message: String) {
        jmsService.send("From: 4ch: $message", "s3consumer")
    }
}

package com.example.eventsdemo.s3

import com.example.eventsdemo.core.CustomEventPublisher
import com.example.eventsdemo.core.JmsService
import org.springframework.stereotype.Component

@Component
class S3ApiUser(
    jmsService: JmsService,
    private val s3Connector: S3Connector,
    private val eventSender: CustomEventPublisher
) {
    init {
        jmsService.addListener("2ch", ::publishToS3)
    }

    fun publishToS3(file: String) {
        s3Connector.publishFile(file)
        eventSender.sendS3Event(this, file)
    }
}

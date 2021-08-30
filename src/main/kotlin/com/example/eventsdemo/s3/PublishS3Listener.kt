package com.example.eventsdemo.s3

import com.example.eventsdemo.core.CustomEventPublisher
import com.example.eventsdemo.events.PublishS3Event
import org.springframework.context.ApplicationListener
import org.springframework.stereotype.Component

@Component
class PublishS3Listener(
    private val eventSender: CustomEventPublisher
) : ApplicationListener<PublishS3Event> {
    override fun onApplicationEvent(event: PublishS3Event) {
        eventSender.sendJmsEvent(this, "4ch", "${event.filename} : ${event.hash}")
    }
}

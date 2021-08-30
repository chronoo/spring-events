package com.example.eventsdemo.core

import com.example.eventsdemo.events.JmsEvent
import com.example.eventsdemo.events.PublishS3Event
import org.springframework.context.ApplicationEvent
import org.springframework.context.ApplicationEventPublisher
import org.springframework.context.ApplicationEventPublisherAware
import org.springframework.stereotype.Service

@Service
class CustomEventPublisher : ApplicationEventPublisherAware {
    private lateinit var publisher: ApplicationEventPublisher

    override fun setApplicationEventPublisher(publisher: ApplicationEventPublisher) {
        this.publisher = publisher
    }

    fun sendS3Event(source: Any, file: String) =
        publisher.publishEvent(
            PublishS3Event(source, file.getName(), file.hashCode())
        )

    fun sendJmsEvent(source: Any, queue: String, message: String) {
        publisher.publishEvent(
            JmsEvent(source, queue, message)
        )
    }

    fun publish(event: ApplicationEvent) = publisher.publishEvent(event)
}

private fun String.getName(): String = "$this.rar"

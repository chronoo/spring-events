package com.example.eventsdemo.core

import com.example.eventsdemo.events.JmsEvent
import org.springframework.context.ApplicationListener
import org.springframework.stereotype.Service

@Service
class JmsService(
    private val eventSender: CustomEventPublisher
) : ApplicationListener<JmsEvent> {
    private val listeners = HashMap<String, (String) -> Unit>()

    fun send(message: String, queue: String) =
        eventSender.sendJmsEvent(this, queue, message)

    fun addListener(queue: String, action: (String) -> Unit) {
        listeners[queue] = action
    }

    override fun onApplicationEvent(event: JmsEvent) {
        listeners[event.queue]?.let { it(event.message) }
    }
}

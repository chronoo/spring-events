package com.example.eventsdemo.events

import org.springframework.context.ApplicationEvent

class JmsEvent(
    source: Any,
    val queue: String,
    val message: String
) : ApplicationEvent(source)

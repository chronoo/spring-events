package com.example.eventsdemo.events

import org.springframework.context.ApplicationEvent

class PublishS3Event(
    source: Any,
    val filename: String,
    val hash: Int) : ApplicationEvent(source)

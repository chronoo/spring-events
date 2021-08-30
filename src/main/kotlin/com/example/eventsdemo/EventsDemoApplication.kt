package com.example.eventsdemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class EventsDemoApplication

fun main(args: Array<String>) {
    runApplication<EventsDemoApplication>(*args)
}

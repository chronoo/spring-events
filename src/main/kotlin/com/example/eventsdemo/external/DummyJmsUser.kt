package com.example.eventsdemo.external

import com.example.eventsdemo.core.JmsService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping
class DummyJmsUser(
    private val jmsService: JmsService
) {
    @GetMapping
    fun doIt(@RequestParam user: String?) =
        user?.let {
            jmsService.send(user, "2ch")
        }
}

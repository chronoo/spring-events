package com.example.eventsdemo.s3

import org.springframework.stereotype.Service

@Service
class S3Connector {
    fun publishFile(file: String) {
        println("publish file $file")
    }
}

package com.example.grpcclient.controllers

import com.example.grpcclient.services.HelloWorldService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/hello")
class HelloWorldControoler(
    val helloWorldService: HelloWorldService
) {

    @GetMapping
    fun sayHello(@RequestParam(value = "name", required = true) name: String): ResponseEntity<Any>{
        val message = helloWorldService.sayHello(name)
        return ResponseEntity.ok().body(message)
    }

}
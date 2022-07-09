package com.example.grpcclient.services

import net.devh.boot.grpc.client.inject.GrpcClient
import org.example.HelloRequest
import org.example.HelloWorldServiceGrpc
import org.springframework.stereotype.Service

@Service
class HelloWorldService {

    @GrpcClient("grpc-server")
    lateinit var helloWorldStub: HelloWorldServiceGrpc.HelloWorldServiceBlockingStub

    fun sayHello(name: String): String{
        val request = HelloRequest.newBuilder()
                                  .setName(name)
                                  .build()
        return helloWorldStub.sayHello(request).message
    }

}
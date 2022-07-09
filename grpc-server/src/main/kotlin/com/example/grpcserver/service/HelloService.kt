package com.example.grpcserver.service

import io.grpc.stub.StreamObserver
import net.devh.boot.grpc.server.service.GrpcService
import org.example.HelloReply
import org.example.HelloRequest
import org.example.HelloWorldServiceGrpc

@GrpcService
class HelloService : HelloWorldServiceGrpc.HelloWorldServiceImplBase() {

    override fun sayHello(request: HelloRequest?, responseObserver: StreamObserver<HelloReply>?) {
        val response = HelloReply.newBuilder().setMessage("Hello ${request?.name}").build()
        responseObserver?.onNext(response)
        responseObserver?.onCompleted()
    }

}
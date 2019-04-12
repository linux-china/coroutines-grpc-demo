package org.mvnsearch.coroutines.grpc

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CoroutinesGrpcDemoApplication

fun main(args: Array<String>) {
	runApplication<CoroutinesGrpcDemoApplication>(*args)
}

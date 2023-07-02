package com.example

import com.example.dao.DatabaseFactory
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*
import java.net.http.HttpResponse

fun main() {
    embeddedServer(Netty, port = 8100, host = "192.168.1.8", module = Application::module)
        .start(wait = true)
}


fun Application.module() {
    DatabaseFactory.init()
    configureSerialization()
    configureMonitoring()
    configureRouting()
}

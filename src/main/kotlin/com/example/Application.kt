package com.example

import com.example.di.mainModule
import com.example.plugins.*
import io.ktor.server.application.*
import org.koin.core.Koin
import org.koin.ktor.plugin.Koin


fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    install(Koin){
        modules(mainModule)
    }
    configureSockets()
    configureRouting()
    configureSerialization()
    configureMonitoring()
    configureSecurity()


}

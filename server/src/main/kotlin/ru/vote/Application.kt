package ru.vote

import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.features.CallLogging
import io.ktor.features.ContentNegotiation
import io.ktor.features.DefaultHeaders
import io.ktor.gson.gson
import io.ktor.locations.*
import io.ktor.server.netty.EngineMain
import ru.vote.routes.addRouting

import java.text.DateFormat

fun main(args: Array<String>): Unit = EngineMain.main(args)

fun Application.module() {

    install(Locations)
    install(CallLogging)          // Включаем логирование
    install(DefaultHeaders)       // Включаем заголовки (Date and Server)
    install(ContentNegotiation) {

        // Серилизация
        gson {
            setDateFormat(DateFormat.LONG)
            setPrettyPrinting()
        }
    }

    addRouting()            // Роутинг ("/", ets)
}
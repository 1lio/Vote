package ru.vote.routes

import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.http.ContentType
import io.ktor.response.*
import io.ktor.routing.Routing
import io.ktor.routing.get
import io.ktor.routing.routing

fun Application.addRouting() {

    routing {

        get("/"){
            call.respond("This is Home")
        }
    }

}

fun Routing.notFound() {
    get("/404") {
        call.respondText("page not found", contentType = ContentType.Text.Plain)
    }
}
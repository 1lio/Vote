package server.routing

import io.ktor.application.call
import io.ktor.response.respond
import io.ktor.routing.*
import server.controllers.UserController


val controller = UserController()

fun Route.routeUsers(): Set<Route> {
    return setOf(

            get("/users:list") {
                call.respond(controller.getAllUsers())
            },

            post("/users") {


            },

            put {  },

            delete ("/user:id") {



            }

    )
}
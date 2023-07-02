package com.example.routes

import com.example.dao.DAOFacadeImpl
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.util.*

private val dao = DAOFacadeImpl()


fun Route.allQuotes() {
    get("/quotes/all") {
        call.respond(mapOf("quotes" to dao.allQuotes()))
    }
}

fun Route.getQuote() {
    get("/quotes/{id}") {
        val id = call.parameters.getOrFail<Int>("id").toInt()
        call.respond(
            mapOf("quote" to dao.quote(id))
        )
    }
}
fun Route.addQuote() {
    post {
        val formParameters = call.receiveParameters()
        val text = formParameters.getOrFail("text")
        val author = formParameters.getOrFail("author")
        val quote = dao.addNewQuote(text, author)
        call.respondRedirect("/quotes/${quote?.id}")
    }
}

fun Route.editQuote() {
    patch("/quotes/{id}") {
        val id = call.parameters.getOrFail<Int>("id").toInt()
        val formParameters = call.receiveParameters()
        val text = formParameters.getOrFail("text")
        val author = formParameters.getOrFail("author")
        dao.editQuote(id, text, author)
        call.respondRedirect("/quotes/$id")
    }
}

fun Route.deleteQuote() {
    delete("{id}") {
        val id = call.parameters.getOrFail<Int>("id").toInt()
        val formParameters = call.receiveParameters()
        dao.deleteQuote(id)
        call.respondRedirect("/quotes/all")
    }
}

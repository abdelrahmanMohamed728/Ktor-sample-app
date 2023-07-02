package com.example.plugins

import com.example.routes.*
import io.ktor.server.routing.*
import io.ktor.server.http.content.*
import io.ktor.server.application.*

fun Application.configureRouting() {
    
    routing {
        allQuotes()
        getQuote()
        addQuote()
        addDummyQuote()
        editQuote()
        deleteQuote()
        // Static plugin. Try to access `/static/index.html`
        static("/static") {
            resources("static")
        }
    }
}

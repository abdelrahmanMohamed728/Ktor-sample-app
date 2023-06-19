package com.example.routes

import com.example.models.Quote
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

private val quotes = listOf(
    Quote(
        1,
        "Two things are infinite: the universe and human stupidity; and I'm not sure about the universe.",
        "Albert Einstein"
    ),
    Quote(2, "So many books, so little time.", "Frank Zappa"),
    Quote(3, "A room without books is like a body without a soul.", "Marcus Tullius Cicero")
)

fun Route.dailyQuote() {
    get("/daily_quote") {
        call.respond(
            HttpStatusCode.OK,
            quotes.random()
        )
    }
}
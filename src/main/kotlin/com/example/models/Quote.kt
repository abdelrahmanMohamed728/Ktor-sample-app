package com.example.models

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.*

@Serializable
class Quote(val id: Int, val text: String, val author: String)

object Quotes : Table() {
    val id = integer("id").autoIncrement()
    val text = varchar("text", 128)
    val author = varchar("author", 1024)

    override val primaryKey = PrimaryKey(id)
}
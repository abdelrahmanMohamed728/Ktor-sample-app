package com.example.dao

import com.example.dao.DatabaseFactory.dbQuery
import com.example.models.Quote
import com.example.models.Quotes
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq

class DAOFacadeImpl : DAOFacade {

    private fun fromRowToQuote(row: ResultRow) = Quote(
        id = row[Quotes.id],
        text = row[Quotes.text],
        author = row[Quotes.author],
    )

    override suspend fun allQuotes(): List<Quote> {
        return dbQuery { Quotes.selectAll().map(::fromRowToQuote) }
    }

    override suspend fun quote(id: Int): Quote? {
        return dbQuery {
            Quotes.select { Quotes.id eq id }
                .map(::fromRowToQuote)
                .singleOrNull()
        }
    }

    override suspend fun addNewQuote(text: String, author: String): Quote? {
        return dbQuery {
           val insertStatement = Quotes.insert {
                it[Quotes.text] = text
                it[Quotes.author] = author
            }
            return@dbQuery insertStatement.resultedValues?.singleOrNull()?.let(::fromRowToQuote)
        }
    }

    override suspend fun editQuote(id: Int, text: String, author: String): Boolean {
        return dbQuery {
            val updateStatement = Quotes.update({Quotes.id eq id}) {
                it[Quotes.text] = text
                it[Quotes.author] = author
            }
            return@dbQuery updateStatement > 0
        }
    }

    override suspend fun deleteQuote(id: Int): Boolean {
        return dbQuery {
            Quotes.deleteWhere { Quotes.id eq id } > 0
        }
    }
}
package com.example.dao

import com.example.models.Quote

interface DAOFacade {
    suspend fun allQuotes(): List<Quote>
    suspend fun quote(id: Int): Quote?
    suspend fun addNewQuote(text: String, author: String): Quote?
    suspend fun editQuote(id: Int, text: String, author: String): Boolean
    suspend fun deleteQuote(id: Int): Boolean
}
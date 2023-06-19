package com.example.models

import kotlinx.serialization.Serializable

@Serializable
class Quote(val id: Int, val text: String, val author: String)
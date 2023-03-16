package com.geovannycode.models

import kotlinx.serialization.Serializable

@Serializable
data class BookResponse(
    val id: Long,
    val name: String,
)

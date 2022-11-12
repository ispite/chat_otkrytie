package ru.skillbox.chat_otkrytie.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AuthBody(
    val login: String,
    val password: String
)

package ru.skillbox.chat_otkrytie.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class User(
    @Json(name = "userId")
    val userId: Long,

    @Json(name = "login")
    val login: String,

    @Json(name = "role")
    val role: String,
//    val role: UserRole,

    @Json(name = "jwtToken")
    val jwtToken: String
)

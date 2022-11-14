package ru.skillbox.chat_otkrytie.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Message(

    @Json(name = "dialogId")
    val dialogId: Int = 1,

    @Json(name = "text")
    val text: String,

    @Json(name = "messageType")
    val messageType: String,

    @Json(name = "data")
    val data: String?,

    @Json(name = "mediaUrl")
    val mediaUrl: String?
)

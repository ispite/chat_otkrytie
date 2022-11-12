package ru.skillbox.chat_otkrytie.networking

import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
import ru.skillbox.chat_otkrytie.data.AuthBody
import ru.skillbox.chat_otkrytie.data.User

interface OtkrytieApi {

    @POST("auth")
    @Headers("Content-Type: application/json")
    suspend fun auth(
        @Body authBody: AuthBody
    ): User
}
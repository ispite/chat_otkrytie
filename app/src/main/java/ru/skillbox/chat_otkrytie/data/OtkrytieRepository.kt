package ru.skillbox.chat_otkrytie.data

import ru.skillbox.chat_otkrytie.networking.Networking

class OtkrytieRepository {

    private val otkrytieApi = Networking.otkrytieApi

    suspend fun authRequest(body: AuthBody) = otkrytieApi.auth(body)

}
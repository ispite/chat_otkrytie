package ru.skillbox.chat_otkrytie.networking

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import ru.skillbox.chat_otkrytie.utils.haveP


object Networking {

//    private val baseUrlProtocol: String = if (haveP()) "https" else "http"

    private val okHttpClient = OkHttpClient.Builder()
//        .addNetworkInterceptor(ApiKeyAdderInterceptor(API_KEY))
        .addNetworkInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://hack.invest-open.ru/")
        .addConverterFactory(MoshiConverterFactory.create())
        .client(okHttpClient)
        .build()

    val otkrytieApi: OtkrytieApi
        get() = retrofit.create()
}
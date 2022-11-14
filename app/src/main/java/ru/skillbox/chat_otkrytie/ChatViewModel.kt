package ru.skillbox.chat_otkrytie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.skillbox.chat_otkrytie.data.AuthBody
import ru.skillbox.chat_otkrytie.data.OtkrytieRepository
import ru.skillbox.chat_otkrytie.data.User

class ChatViewModel : ViewModel() {

    private val repository = OtkrytieRepository()
    lateinit var user: User

    fun sendAuthRequest(body: AuthBody) {
        viewModelScope.launch {
            user = repository.authRequest(body)

        }
    }

    companion object {
        private val WEB_SOCKET_FEED = "wss://hack.invest-open.ru/chat"
    }
}
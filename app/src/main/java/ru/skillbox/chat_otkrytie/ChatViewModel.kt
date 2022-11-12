package ru.skillbox.chat_otkrytie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.skillbox.chat_otkrytie.data.AuthBody
import ru.skillbox.chat_otkrytie.data.OtkrytieRepository

class ChatViewModel : ViewModel() {

    private val repository = OtkrytieRepository()

    fun sendAuthRequest(body: AuthBody) {
        viewModelScope.launch {
            repository.authRequest(body)
        }
    }
}
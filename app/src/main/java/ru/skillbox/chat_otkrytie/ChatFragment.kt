package ru.skillbox.chat_otkrytie

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.WebSocket
import ru.skillbox.chat_otkrytie.data.AuthBody
import ru.skillbox.chat_otkrytie.databinding.FragmentChatBinding
import ru.skillbox.chat_otkrytie.networking.EchoWebSocketListener
import timber.log.Timber


class ChatFragment : Fragment(R.layout.fragment_chat) {

    private val args: ChatFragmentArgs by navArgs()
    private val binding: FragmentChatBinding by viewBinding(FragmentChatBinding::bind)
    private val viewModel: ChatViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind()
        binding.wss.setOnClickListener { start() }
    }

    private val WEB_SOCKET_FEED_HACKATHON = "wss://hack.invest-open.ru/chat"
    private val WEB_SOCKET_FEED = "wss://ws.postman-echo.com/raw"

    private fun start() {
        val client = OkHttpClient()

        val user = viewModel.user
        Timber.d("start")
        val request: Request = Request.Builder().url(WEB_SOCKET_FEED_HACKATHON)
            .addHeader("Authorization", "Bearer ${user.jwtToken}")
            .build()
        val listener = EchoWebSocketListener()
        val ws: WebSocket =
            client.newWebSocket(request, listener)
        ws.send("Hello")
        client.dispatcher.executorService.shutdown()
    }

    private fun bind() {
        when (args.userType) {
            // 0 = Client
            0 -> {
                viewModel.sendAuthRequest(
                    AuthBody(
                        "morocco",
                        "d9e34e327bf38d710783a51e11a40583c2dce8450c880b59b3eaf755c9539def"
                    )
                )
            }
            // 1 = Operator
            1 -> {
                viewModel.sendAuthRequest(
                    AuthBody(
                        "moldova",
                        "5bc6585d521bae9020ef54773a53e9ac073aa11074b842c0574d274c00df6859"
                    )
                )
            }
        }
    }
}
package ru.skillbox.chat_otkrytie

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.skillbox.chat_otkrytie.data.AuthBody
import ru.skillbox.chat_otkrytie.databinding.FragmentChatBinding

class ChatFragment : Fragment(R.layout.fragment_chat) {

    private val args: ChatFragmentArgs by navArgs()
    private val binding: FragmentChatBinding by viewBinding(FragmentChatBinding::bind)
    private val viewModel: ChatViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind()
    }

    private fun bind() {
        val result = args.userType
        when (result) {
            // 0 = Client
            0 -> { viewModel.sendAuthRequest(AuthBody("morocco", "d9e34e327bf38d710783a51e11a40583c2dce8450c880b59b3eaf755c9539def")) }
            // 1 = Operator
            1 -> { viewModel.sendAuthRequest(AuthBody("moldova", "5bc6585d521bae9020ef54773a53e9ac073aa11074b842c0574d274c00df6859")) }
        }
    }
}
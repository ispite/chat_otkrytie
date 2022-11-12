package ru.skillbox.chat_otkrytie

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.skillbox.chat_otkrytie.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {

    private val binding: FragmentMainBinding by viewBinding(FragmentMainBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 0 = Client
        binding.client.setOnClickListener {
            findNavController()
                .navigate(MainFragmentDirections.actionMainFragmentToChatFragment(0))
        }

        // 1 = Operator
        binding.operator.setOnClickListener {
            findNavController()
                .navigate(MainFragmentDirections.actionMainFragmentToChatFragment(1))
        }
    }

}
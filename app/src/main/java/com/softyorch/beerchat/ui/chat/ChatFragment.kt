package com.softyorch.beerchat.ui.chat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.softyorch.beerchat.R
import com.softyorch.beerchat.databinding.FragmentChatBinding

class ChatFragment : Fragment() {

    private lateinit var binding: FragmentChatBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChatBinding.inflate(layoutInflater, container, false)
        binding.ivBack.setOnClickListener {
            findNavController().navigate(R.id.action_chat_fragment_back_main_fragment)
        }
        return binding.root
    }

}
package com.softyorch.beerchat.ui.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.softyorch.beerchat.R
import com.softyorch.beerchat.databinding.FragmentChatBinding
import com.softyorch.beerchat.ui.chat.adapter.ChatAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ChatFragment : Fragment() {

    private lateinit var binding: FragmentChatBinding
    private val viewModel by viewModels<ChatViewModel>()
    private lateinit var chatAdapter: ChatAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChatBinding.inflate(layoutInflater, container, false)
        binding.ivBack.setOnClickListener {
            viewModel.logout {
                findNavController().navigate(R.id.action_chat_fragment_back_main_fragment)
            }
        }
        binding.btnSendChat.setOnClickListener {
            val msg = binding.etChat.text.toString()
            if (msg.isNotBlank()) {
                viewModel.sendMessageToOther(msg)
                binding.etChat.text.clear()
            }
        }

        setUpUI()

        return binding.root
    }

    private fun setUpUI() {
        setUpMessages()
        subscribeToMessages()
        setUpToolbar()
    }

    private fun setUpToolbar() {
        binding.tvTitle.text = viewModel.name
    }

    private fun setUpMessages() {
        chatAdapter = ChatAdapter(mutableListOf())
        binding.rvMsg.apply {
            adapter = chatAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    private fun subscribeToMessages() {
        lifecycleScope.launch {
            viewModel.messageList.collect { list ->
                chatAdapter.updateList(list.toMutableList(), viewModel.name)
                binding.rvMsg.scrollToPosition(chatAdapter.messagesList.size - 1)
            }
        }
    }

}
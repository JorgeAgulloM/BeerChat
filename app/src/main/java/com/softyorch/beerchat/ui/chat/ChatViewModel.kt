package com.softyorch.beerchat.ui.chat

import androidx.lifecycle.ViewModel
import com.softyorch.beerchat.domain.useCase.SendMessage
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(private val sendMessage: SendMessage): ViewModel() {
    fun sendMessage() {
        val msg = "Holiwi"
        sendMessage(msg)
    }
}
package com.softyorch.beerchat.ui.chat

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.softyorch.beerchat.domain.useCase.GetMessage
import com.softyorch.beerchat.domain.useCase.SendMessage
import com.softyorch.beerchat.ui.chat.model.MessageUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(
    private val sendMessage: SendMessage,
    private val getMessage: GetMessage
): ViewModel() {

    private val _messageList = MutableStateFlow<List<MessageUi>>(emptyList())
    val messageList: StateFlow<List<MessageUi>> = _messageList

    init {
        getMessages()
    }

    private fun getMessages() {
        viewModelScope.launch {
            getMessage().collect { list ->
                list.forEach {
                    Log.i("BeerChatLog", "Message: $it")
                }
                _messageList.update { list }
            }
        }
    }

    fun sendMessage() {
        val msg = "Holiwi"
        sendMessage(msg)
    }
}
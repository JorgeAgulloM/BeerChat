package com.softyorch.beerchat.ui.chat.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.softyorch.beerchat.databinding.ItemMsgMeBinding
import com.softyorch.beerchat.databinding.ItemMsgOtherBinding
import com.softyorch.beerchat.ui.chat.model.MessageUi

class ChatAdapter(
    var messagesList: MutableList<MessageUi>,
    private var userName: String = ""
) : RecyclerView.Adapter<ChatViewHolder>() {

    companion object {
        const val SEND_MESSAGE = 0
        const val RECEIVE_MESSAGE = 1
    }

    fun updateList(list: MutableList<MessageUi>, name: String) {
        userName = name
        messagesList.clear()
        messagesList.addAll(list)
        notifyItemInserted(messagesList.size - 1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val binding = when (viewType) {
            SEND_MESSAGE -> {
                ItemMsgMeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            }

            RECEIVE_MESSAGE -> {
                ItemMsgOtherBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            }

            else -> {
                ItemMsgOtherBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            }
        }

        return ChatViewHolder(binding)
    }

    override fun getItemCount() = messagesList.size

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        holder.bind(messagesList[position], getItemViewType(position))
    }

    override fun getItemViewType(position: Int): Int {
        return if (messagesList[position].user.userName == userName) {
            SEND_MESSAGE
        } else {
            RECEIVE_MESSAGE
        }
    }
}
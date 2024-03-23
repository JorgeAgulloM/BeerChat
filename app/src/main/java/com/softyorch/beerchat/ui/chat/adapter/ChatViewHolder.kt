package com.softyorch.beerchat.ui.chat.adapter

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.softyorch.beerchat.databinding.ItemMsgMeBinding
import com.softyorch.beerchat.databinding.ItemMsgOtherBinding
import com.softyorch.beerchat.ui.chat.adapter.ChatAdapter.Companion.RECEIVE_MESSAGE
import com.softyorch.beerchat.ui.chat.adapter.ChatAdapter.Companion.SEND_MESSAGE
import com.softyorch.beerchat.ui.chat.model.MessageUi

class ChatViewHolder(private val binding: ViewBinding):RecyclerView.ViewHolder(binding.root) {
    fun bind(messageUi: MessageUi, itemViewType: Int) {
        when (itemViewType) {
            SEND_MESSAGE -> bindSendMessage(messageUi)
            RECEIVE_MESSAGE -> bindReceiveMessage(messageUi)
        }
    }

    private fun bindReceiveMessage(messageUi: MessageUi) {
        val currentBinding = binding as ItemMsgOtherBinding
        messageUi.apply {
            currentBinding.apply {
                tvDateOther.text = date
                tvChatMe.text = msg
                tvName.text = user.userName
                tvHour.text = hour
            }
        }
    }

    private fun bindSendMessage(messageUi: MessageUi) {
        val currentBinding = binding as ItemMsgMeBinding
        messageUi.apply {
            currentBinding.apply {
                tvDateMe.text = date
                tvChatMe.text = msg
                tvHour.text = hour
            }
        }
    }
}
package com.softyorch.beerchat.ui.chat.adapter

import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.softyorch.beerchat.databinding.ItemMsgMeBinding
import com.softyorch.beerchat.databinding.ItemMsgOtherBinding
import com.softyorch.beerchat.ui.chat.adapter.ChatAdapter.Companion.RECEIVE_MESSAGE
import com.softyorch.beerchat.ui.chat.adapter.ChatAdapter.Companion.SEND_MESSAGE
import com.softyorch.beerchat.ui.chat.model.MessageUi

class ChatViewHolder(private val binding: ViewBinding):RecyclerView.ViewHolder(binding.root) {
    fun bind(messageUi: MessageUi, oldMessage: MessageUi? = null, itemViewType: Int) {
        when (itemViewType) {
            SEND_MESSAGE -> bindSendMessage(messageUi, oldMessage)
            RECEIVE_MESSAGE -> bindReceiveMessage(messageUi, oldMessage)
        }
    }

    private fun bindReceiveMessage(messageUi: MessageUi, oldMessage: MessageUi?) {
        val currentBinding = binding as ItemMsgOtherBinding
        val isLastUser = isLastUser(messageUi.user.userName, oldMessage)
        val isDiffDate = isDiffDate(messageUi.date, oldMessage)
        messageUi.apply {
            currentBinding.apply {
                ivUser.visibility = if (!isLastUser) ImageView.VISIBLE else ImageView.GONE
                tvName.visibility = if (!isLastUser) TextView.VISIBLE else TextView.GONE
                tvChat.text = msg
                tvHour.text = hour
                if (!isLastUser) { tvName.text = user.userName }

                tvDate.visibility = if (!isDiffDate) TextView.VISIBLE else TextView.GONE
                if (!isDiffDate) { tvDate.text = date }
            }
        }
    }

    private fun bindSendMessage(messageUi: MessageUi, oldMessage: MessageUi?) {
        val currentBinding = binding as ItemMsgMeBinding
        val isDiffDate = isDiffDate(messageUi.date, oldMessage)
        messageUi.apply {
            currentBinding.apply {
                tvChat.text = msg
                tvHour.text = hour
                if (!isDiffDate) {
                    tvDate.text = date
                }
                tvDate.visibility = if (isDiffDate) TextView.GONE else TextView.VISIBLE
            }
        }
    }

    private fun isLastUser(newUser: String, oldMessage: MessageUi?): Boolean =
        if (oldMessage == null) false else newUser == oldMessage.user.userName

    private fun isDiffDate(newDate: String, oldMessage: MessageUi?): Boolean =
        if (oldMessage == null) false else newDate == oldMessage.date

}
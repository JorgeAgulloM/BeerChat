package com.softyorch.beerchat.domain.model

import com.softyorch.beerchat.domain.model.UserDomain.Companion.toUi
import com.softyorch.beerchat.ui.chat.model.MessageUi

data class MessageDomain(
    val msg: String,
    val hour: String,
    val date: String,
    val user: UserDomain
) {
    companion object {
        fun MessageDomain.toUi(): MessageUi = MessageUi(msg, hour, date, user.toUi())
    }
}

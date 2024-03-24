package com.softyorch.beerchat.data.network.response

import com.softyorch.beerchat.data.network.response.UserResponse.Companion.toDomain
import com.softyorch.beerchat.domain.model.MessageDomain

data class MessageResponse(
    val msg: String? = null,
    val hour: String? = null,
    val date: String? = null,
    val user: UserResponse? = null
) {
    companion object {
        fun MessageResponse.toDomain(): MessageDomain {
            return MessageDomain(
                msg = msg.orEmpty(), hour = hour.orEmpty(), date = date.orEmpty(), user = user!!.toDomain()
            )
        }
    }
}

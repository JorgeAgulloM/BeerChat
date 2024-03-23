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
            val totalDate = if (date == null && hour == null) {
                "no date"
            } else if (date == null) {
                hour.orEmpty()
            } else if (hour == null) {
                date
            } else {
                "$hour - $date"
            }

            return MessageDomain(
                msg = msg.orEmpty(), hour = hour.orEmpty(), date = totalDate, user = user!!.toDomain()
            )
        }
    }
}

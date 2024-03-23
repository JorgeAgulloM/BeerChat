package com.softyorch.beerchat.domain.useCase

import com.softyorch.beerchat.data.network.FirebaseChatService
import com.softyorch.beerchat.data.network.dto.MessageDto
import com.softyorch.beerchat.data.network.dto.UserDto
import java.util.Calendar
import javax.inject.Inject

class SendMessage @Inject constructor(private val firebaseChatService: FirebaseChatService) {
    operator fun invoke(msg: String, userName: String) {
        firebaseChatService.sendMsgToFirebase(generateUserDto(msg, userName))
    }

    private fun generateUserDto(msg: String, userName: String): MessageDto {
        val calendar = Calendar.getInstance()

        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val min = calendar.get(Calendar.MINUTE)
        val time = "$hour:$min"

        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val date = "$day-$month-$year"

        val user = UserDto(
            userName = userName,
            admin = false
        )

        return MessageDto(msg = msg, hour = time, date = date, user = user)
    }
}
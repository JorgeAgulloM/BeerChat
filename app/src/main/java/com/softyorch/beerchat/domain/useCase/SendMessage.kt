package com.softyorch.beerchat.domain.useCase

import com.softyorch.beerchat.data.network.FirebaseChatService
import javax.inject.Inject

class SendMessage @Inject constructor(private val firebaseChatService: FirebaseChatService) {
    operator fun invoke(msg: String) {
        firebaseChatService.sendMsgToFirebase(msg)
    }
}
package com.softyorch.beerchat.data.network

import com.google.firebase.database.DatabaseReference
import com.softyorch.beerchat.data.network.dto.MessageDto
import javax.inject.Inject

class FirebaseChatService @Inject constructor(private val reference: DatabaseReference) {

    companion object {
        private const val PATH = "messages"
        private const val EXAMPLE_PATH = "examples"
    }

    fun sendMsgToFirebase(msgDto: MessageDto) {
        val newMsg = reference.child(PATH).push()
        newMsg.setValue(msgDto)
    }
}
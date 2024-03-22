package com.softyorch.beerchat.data.network

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.snapshots
import com.softyorch.beerchat.data.network.dto.MessageDto
import com.softyorch.beerchat.data.network.response.MessageResponse
import com.softyorch.beerchat.data.network.response.MessageResponse.Companion.toDomain
import com.softyorch.beerchat.domain.model.MessageDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FirebaseChatService @Inject constructor(private val reference: DatabaseReference) {

    companion object {
        private const val PATH = "messages"
    }

    fun sendMsgToFirebase(msgDto: MessageDto) {
        val newMsg = reference.child(PATH).push()
        newMsg.setValue(msgDto)
    }

    fun getMsgFromFirebase(): Flow<List<MessageDomain>> {
        return reference.child(PATH).snapshots.map { dataSnapshot ->
            dataSnapshot.children.mapNotNull { dataChild ->
                dataChild.getValue(MessageResponse::class.java)?.toDomain()
            }
        }
    }
}
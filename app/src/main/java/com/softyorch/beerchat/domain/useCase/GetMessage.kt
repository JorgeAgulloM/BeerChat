package com.softyorch.beerchat.domain.useCase

import com.softyorch.beerchat.data.network.FirebaseChatService
import com.softyorch.beerchat.domain.model.MessageDomain.Companion.toUi
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetMessage @Inject constructor(private val firebaseChatService: FirebaseChatService) {
    operator fun invoke() = firebaseChatService.getMsgFromFirebase().map { list ->
        list.map { it.toUi() }
    }
}

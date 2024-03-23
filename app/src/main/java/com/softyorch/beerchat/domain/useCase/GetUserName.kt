package com.softyorch.beerchat.domain.useCase

import com.softyorch.beerchat.domain.interfaces.IDatabaseService
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class GetUserName @Inject constructor(private val db: IDatabaseService) {
    suspend operator fun invoke(): String = db.getUserName().first()
}

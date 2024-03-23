package com.softyorch.beerchat.domain.useCase

import com.softyorch.beerchat.domain.interfaces.IDatabaseService
import javax.inject.Inject

class SaveUserName @Inject constructor(private val db: IDatabaseService) {
    suspend operator fun invoke(userName: String) {
        db.saveUserName(userName)
    }
}

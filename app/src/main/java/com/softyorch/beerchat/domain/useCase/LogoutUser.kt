package com.softyorch.beerchat.domain.useCase

import com.softyorch.beerchat.domain.interfaces.IDatabaseService
import javax.inject.Inject

class LogoutUser @Inject constructor(private val db: IDatabaseService) {
    suspend operator fun invoke() {
        db.clear()
    }
}

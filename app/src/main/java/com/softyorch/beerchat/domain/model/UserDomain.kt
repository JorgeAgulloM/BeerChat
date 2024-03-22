package com.softyorch.beerchat.domain.model

import com.softyorch.beerchat.ui.chat.model.UserUi

data class UserDomain(
    val userName: String ,
    val admin: Boolean
) {
    companion object {
        fun UserDomain.toUi(): UserUi = UserUi(userName, admin)
    }
}

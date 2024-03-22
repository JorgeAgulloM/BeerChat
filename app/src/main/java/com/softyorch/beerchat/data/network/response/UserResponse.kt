package com.softyorch.beerchat.data.network.response

import com.softyorch.beerchat.domain.model.UserDomain

data class UserResponse(
    val userName: String? = null,
    val admin: Boolean? = null
) {
    companion object {
        fun UserResponse.toDomain(): UserDomain = UserDomain(userName ?: "Guess", admin = admin ?: false)
    }
}

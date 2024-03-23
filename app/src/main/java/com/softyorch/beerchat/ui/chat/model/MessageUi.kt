package com.softyorch.beerchat.ui.chat.model

data class MessageUi(
    val msg: String,
    val hour: String,
    val date: String,
    val user: UserUi
)

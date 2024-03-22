package com.softyorch.beerchat.data.network.dto

data class MessageDto(
    val msg: String,
    val hour: String,
    val date: String,
    val user: UserDto
)

package com.softyorch.beerchat.domain.interfaces

import kotlinx.coroutines.flow.Flow

interface IDatabaseService {
    fun getUserName(): Flow<String>
    suspend fun saveUserName(userName: String)
    suspend fun clear()
}

package com.softyorch.beerchat.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.softyorch.beerchat.domain.useCase.SaveUserName
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val saveUserName: SaveUserName,
    private val dispatcherIO: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {

    fun saveNickName(userName: String) {
        viewModelScope.launch(dispatcherIO) {
            saveUserName(userName)
        }
    }
}

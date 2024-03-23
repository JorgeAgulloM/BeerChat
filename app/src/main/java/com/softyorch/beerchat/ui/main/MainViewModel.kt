package com.softyorch.beerchat.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.softyorch.beerchat.domain.useCase.GetUserName
import com.softyorch.beerchat.domain.useCase.SaveUserName
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val saveUserName: SaveUserName,
    private val getUserName: GetUserName,
    private val dispatcherIO: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {


    private val _uiState = MutableStateFlow<MainViewState>(MainViewState.LOADING)
    val uiState: StateFlow<MainViewState> = _uiState

    init {
        verifyUserLogged()
    }

    private fun verifyUserLogged() {
        viewModelScope.launch {
            val name = async { getUserName() }.await()
            _uiState.update {
                if (name.isNotBlank()) {
                    MainViewState.REGISTERED
                } else {
                    MainViewState.UNREGISTERED
                }
            }
        }
    }

    fun saveNickName(userName: String) {
        viewModelScope.launch(dispatcherIO) {
            saveUserName(userName)
        }
    }
}

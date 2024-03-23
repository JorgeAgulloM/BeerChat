package com.softyorch.beerchat.ui.main

sealed class MainViewState {
    object UNREGISTERED: MainViewState()
    object REGISTERED: MainViewState()
    object LOADING: MainViewState()
}
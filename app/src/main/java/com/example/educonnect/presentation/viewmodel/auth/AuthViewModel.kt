package com.example.educonnect.presentation.viewmodel.auth

import androidx.lifecycle.ViewModel
import com.example.educonnect.data.local.profile.ProfileOfflineRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class AuthViewModel
@Inject
constructor(
    private val profileOfflineRepository: ProfileOfflineRepository
): ViewModel() {

    private val _authUIState = MutableStateFlow(AuthUIState())
    val authUIState = _authUIState.asStateFlow()

    fun LoginEvents(events: AuthEvents){
        when(events){
            is AuthEvents.LoginClicked -> {

            }
            is AuthEvents.SignInClicked -> {

            }
        }
    }
}
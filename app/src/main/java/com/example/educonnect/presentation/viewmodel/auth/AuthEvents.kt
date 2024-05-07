package com.example.educonnect.presentation.viewmodel.auth

sealed interface AuthEvents {
    data class LoginClicked(
        val user: String,
        val id: String,
        val password: String
    ): AuthEvents

    data class SignInClicked(
        val name: String,
        val id: String,
        val password: String
    ):  AuthEvents
}
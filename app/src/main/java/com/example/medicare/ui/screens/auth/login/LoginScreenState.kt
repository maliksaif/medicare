package com.example.medicare.ui.screens.auth.login

data class LoginState(
    val username: String = "",
    val password: String = "",
    val validationError : String? = "",
    val isVisiblePassword: Boolean = false
)


sealed class LoginEvent {
    data class UsernameChanged(val username: String) : LoginEvent()
    data class PasswordChanged(val password: String) : LoginEvent()
    data class VisiblePassword(val isVisiblePassword: Boolean) : LoginEvent()
    object LoginClicked : LoginEvent()
}
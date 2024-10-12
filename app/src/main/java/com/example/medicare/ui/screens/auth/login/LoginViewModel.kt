package com.example.medicare.ui.screens.auth.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.medicare.ui.screens.auth.login.LoginEvent.LoginClicked
import com.example.medicare.ui.screens.auth.login.LoginEvent.PasswordChanged
import com.example.medicare.ui.screens.auth.login.LoginEvent.UsernameChanged
import com.example.medicare.ui.screens.auth.login.LoginEvent.VisiblePassword
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {

    var loginUiState by mutableStateOf(LoginState())

    fun onEvent(event: LoginEvent) {

        when (event) {
            is UsernameChanged -> {
                loginUiState = loginUiState.copy(username = event.username)
            }

            is PasswordChanged -> {
                loginUiState = loginUiState.copy(password = event.password)
            }

            is VisiblePassword -> loginUiState =
                loginUiState.copy(isVisiblePassword = event.isVisiblePassword)

            LoginClicked -> {
                loginUiState =
                    loginUiState.copy(validationError = if (!validateFields()) "Please fill both the fields to proceed." else null)

            }
        }
    }

    fun validateFields() =
        loginUiState.username.isNotEmpty() && loginUiState.password.isNotEmpty()

}
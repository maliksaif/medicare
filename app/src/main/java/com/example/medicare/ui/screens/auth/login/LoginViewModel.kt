package com.example.medicare.ui.screens.auth.login

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.medicare.ui.screens.auth.login.LoginEvent.LoginClicked
import com.example.medicare.ui.screens.auth.login.LoginEvent.PasswordChanged
import com.example.medicare.ui.screens.auth.login.LoginEvent.UsernameChanged
import com.example.medicare.ui.screens.auth.login.LoginEvent.VisiblePassword

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
                // TODO Validate both fields are not empty atleast

            }
        }
    }

}
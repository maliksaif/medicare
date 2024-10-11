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

// Login ViewModel
@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {

    var formState by mutableStateOf(LoginState())

    fun onEvent(event: LoginEvent) {

        when (event) {
            is UsernameChanged -> {
                formState = formState.copy(username = event.username)
            }
            is PasswordChanged -> {
                formState = formState.copy(password = event.password)
            }
            is VisiblePassword -> formState =
                formState.copy(isVisiblePassword = event.isVisiblePassword)

            LoginClicked -> {
                // TODO Validate both fields are not empty atleast

            }
        }
    }

}
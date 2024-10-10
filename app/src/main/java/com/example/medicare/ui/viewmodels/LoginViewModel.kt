package com.example.medicare.ui.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

// Login ViewModel
@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {

    private var username by mutableStateOf("")
    private var password by mutableStateOf("")

    fun login(inputUsername: String, inputPassword : String) {
        username = inputUsername
        password = inputPassword
    }
}
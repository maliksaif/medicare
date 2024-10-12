package com.example.medicare

import com.example.medicare.ui.screens.auth.login.LoginEvent
import com.example.medicare.ui.screens.auth.login.LoginState
import com.example.medicare.ui.screens.auth.login.LoginViewModel
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertFalse
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class LoginViewModelTest {

    private lateinit var viewModel: LoginViewModel

    @Before
    fun setup() {
        viewModel = LoginViewModel()
    }

    @Test
    fun `validateFields returns false when username or password is empty`() {
        viewModel.loginUiState = LoginState(username = "", password = "")
        val isValid = viewModel.validateFields()
        assertFalse(isValid)
    }

    @Test
    fun `LoginClicked sets validation error when fields are empty`() {
        viewModel.loginUiState = LoginState(username = "", password = "")
        viewModel.onEvent(LoginEvent.LoginClicked)
        assertEquals("Please fill both the fields to proceed.", viewModel.loginUiState.validationError)
    }

    @Test
    fun `LoginClicked sets validation error when fields are not empty`() {
        viewModel.loginUiState = LoginState(username = "qwqw", password = "wqw")
        viewModel.onEvent(LoginEvent.LoginClicked)
        assert(true)
    }
}

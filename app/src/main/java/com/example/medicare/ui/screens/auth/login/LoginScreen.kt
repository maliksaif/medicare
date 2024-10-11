package com.example.medicare.ui.screens.auth.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.medicare.ui.common.AddSpacer
import com.example.medicare.ui.navigationgraph.Navigation
import com.example.medicare.ui.navigationgraph.NavigationItem
import com.example.medicare.ui.screens.auth.login.LoginEvent.LoginClicked
import com.example.medicare.ui.screens.auth.login.LoginEvent.PasswordChanged
import com.example.medicare.ui.screens.auth.login.LoginEvent.UsernameChanged
import kotlinx.coroutines.launch


@Composable
fun LoginScreen(navController: NavController, viewModel: LoginViewModel = hiltViewModel()) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ShowUsername(viewModel = viewModel)
        ShowPassword(viewModel = viewModel)
        ShowButton(viewModel = viewModel, navController = navController)

    }
}

@Composable
fun ShowUsername(viewModel: LoginViewModel) {

    TextField(
        value = viewModel.loginUiState.username,
        onValueChange = { viewModel.onEvent(event = UsernameChanged(it)) },
        label = { Text("Username") },
        modifier = Modifier.fillMaxWidth(),
        singleLine = true,
    )
    AddSpacer(height = 16.dp)

}

@Composable
fun ShowPassword(viewModel: LoginViewModel) {

    TextField(value = viewModel.loginUiState.password,
        onValueChange = { viewModel.onEvent(event = PasswordChanged(it)) },
        label = { Text("Password") },
        modifier = Modifier.fillMaxWidth(),
        singleLine = true,
        visualTransformation = if (viewModel.loginUiState.isVisiblePassword) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            val image = if (viewModel.loginUiState.isVisiblePassword) Icons.Filled.Visibility
            else Icons.Filled.VisibilityOff
            val description =
                if (viewModel.loginUiState.isVisiblePassword) "Hide password" else "Show password"
            IconButton(onClick = {
                viewModel.onEvent(
                    LoginEvent.VisiblePassword(
                        isVisiblePassword = !viewModel.loginUiState.isVisiblePassword
                    )
                )
            }) {
                Icon(imageVector = image, description)
            }
        })

    AddSpacer(height = 24.dp)
}

@Composable
fun ShowButton(viewModel: LoginViewModel, navController: NavController) {
    Button(modifier = Modifier.fillMaxWidth(),
        onClick = {
            viewModel.onEvent(event = LoginClicked);
            navController.navigate(Navigation.navigateToHome(viewModel.loginUiState.username))
        }) {
        Text("Login")
    }
}

package com.example.medicare.ui.screens.auth.login

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.medicare.R
import com.example.medicare.ui.common.AddSpacer
import com.example.medicare.ui.common.CircleImageView
import com.example.medicare.ui.navigationgraph.Navigation
import com.example.medicare.ui.screens.auth.login.LoginEvent.LoginClicked
import com.example.medicare.ui.screens.auth.login.LoginEvent.PasswordChanged
import com.example.medicare.ui.screens.auth.login.LoginEvent.UsernameChanged
import com.example.medicare.ui.utilities.Constants


@Composable
fun LoginScreen(navController: NavController, viewModel: LoginViewModel = hiltViewModel()) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(R.dimen.spacing_16dp))
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        CircleImageView(R.drawable.logo)

        Text(
            text = "Welcome to Medicare",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(bottom = dimensionResource(R.dimen.spacing_24dp))
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.spacing_16dp)),
            elevation = CardDefaults.cardElevation(defaultElevation = dimensionResource(R.dimen.spacing_4dp)),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            shape = RoundedCornerShape(dimensionResource(R.dimen.spacing_12dp))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.spacing_24dp)),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.spacing_16dp))
            ) {

                ShowUsername(viewModel = viewModel)
                ShowPassword(viewModel = viewModel)
                ShowButton(viewModel = viewModel, navController = navController)

            }
        }

    }
}

@Composable
fun ShowUsername(viewModel: LoginViewModel) {

    TextField(
        value = viewModel.loginUiState.username,
        onValueChange = {
            if (it.length <= Constants.MAX_LENGTH) viewModel.onEvent(
                event = UsernameChanged(
                    it
                )
            )
        },
        label = { Text(stringResource(R.string.username)) },
        modifier = Modifier.fillMaxWidth(),
        singleLine = true,
    )

}

@Composable
fun ShowPassword(viewModel: LoginViewModel) {

    TextField(value = viewModel.loginUiState.password,
        onValueChange = {
            if (it.length <= Constants.MAX_LENGTH) viewModel.onEvent(
                event = PasswordChanged(
                    it
                )
            )
        },
        label = { Text(stringResource(R.string.password)) },
        modifier = Modifier.fillMaxWidth(),
        singleLine = true,
        visualTransformation = if (viewModel.loginUiState.isVisiblePassword) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            val image = if (viewModel.loginUiState.isVisiblePassword) Icons.Filled.Visibility
            else Icons.Filled.VisibilityOff
            val description =
                if (viewModel.loginUiState.isVisiblePassword) stringResource(R.string.hide_password) else stringResource(
                    R.string.show_password
                )
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

    AddSpacer(height = dimensionResource(R.dimen.spacing_24dp))
}

@Composable
fun ShowButton(
    viewModel: LoginViewModel,
    navController: NavController,
    context: Context = LocalContext.current
) {
    Button(modifier = Modifier.fillMaxWidth(),
        onClick = {
            viewModel.onEvent(event = LoginClicked)

            // Check if validation is successful before navigating
            if (viewModel.loginUiState.validationError == null) {
                navController.navigate(Navigation.navigateToHome(viewModel.loginUiState.username))
            } else {
                // Show Toast
                Toast.makeText(context, viewModel.loginUiState.validationError, Toast.LENGTH_SHORT)
                    .show()
            }
        }) {
        Text(stringResource(R.string.login))
    }
}

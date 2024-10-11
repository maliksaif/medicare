package com.example.medicare.ui.navigationgraph

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.medicare.ui.screens.auth.login.LoginScreen
import com.example.medicare.ui.screens.auth.login.LoginViewModel
import com.example.medicare.ui.screens.dashboard.home.HomeScreen
import com.example.medicare.ui.screens.dashboard.home.HomeViewModel
import com.example.medicare.ui.screens.dashboard.medicinedetails.MedicineDetailsScreen
import com.example.medicare.ui.screens.dashboard.medicinedetails.MedicineDetailsViewModel
import com.example.medicare.ui.utilities.Constants


@Composable
fun NavGraph(
    navController: NavHostController,
    startDestination: String = Screen.LOGIN.route,
) {
    NavHost(navController = navController, startDestination = startDestination) {
        composable(Screen.LOGIN.route) {
            val loginViewModel: LoginViewModel = hiltViewModel()
            LoginScreen(navController = navController, viewModel = loginViewModel)
        }
        composable(
            route = Screen.HOME.route,
            arguments = listOf(navArgument(Constants.USERNAME) { type = NavType.StringType })
        ) { backStackEntry ->
            val username = backStackEntry.arguments?.getString(Constants.USERNAME) ?: ""
            val homeViewModel = hiltViewModel<HomeViewModel>()
            HomeScreen(navController,viewModel = homeViewModel, username = username)
        }

        composable(
            route = Screen.MEDICINE_DETAILS.route,
            arguments = listOf(navArgument(Constants.MEDICINE_ID) { type = NavType.StringType })
        ) { backStackEntry ->
            val medicineId = backStackEntry.arguments?.getString(Constants.MEDICINE_ID)
            val viewModel = hiltViewModel<MedicineDetailsViewModel>()
            MedicineDetailsScreen(viewModel = viewModel, medicineId = medicineId ?: "")
        }
    }
}
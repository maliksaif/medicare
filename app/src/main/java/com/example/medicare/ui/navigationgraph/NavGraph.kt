package com.example.medicare.ui.navigationgraph

import android.os.Build
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.medicare.domain.models.Medicine
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
            HomeScreen(navController, viewModel = homeViewModel, username = username)
        }

        composable(
            route = Screen.MEDICINE_DETAILS.route
        ) { backStackEntry ->
            val medicine = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                backStackEntry.arguments?.getParcelable(Constants.MEDICINE_ID, Medicine::class.java)
            } else {
                backStackEntry.arguments?.getParcelable(Constants.MEDICINE)
            } // Retrieve the medicine object
            val medicineId = backStackEntry.arguments?.getString(Constants.MEDICINE_ID)
            val viewModel = hiltViewModel<MedicineDetailsViewModel>()
            if (medicine != null) {
                MedicineDetailsScreen(
                    viewModel = viewModel,
                    medicine = medicine
                )
            }
            // Can be used when passing the ID and using ROOM DB To Query The Data
//            MedicineDetailsScreen(viewModel = viewModel, medicineId = medicineId ?: "")
        }
    }
}
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


@Composable
fun NavGraph(
    navController: NavHostController,
    startDestination: String = NavigationItem.Login.route,
) {
    NavHost(navController = navController, startDestination = startDestination) {
        composable(NavigationItem.Login.route) {
            val loginViewModel: LoginViewModel = hiltViewModel()
            LoginScreen(navController = navController, viewModel = loginViewModel)
        }
        composable(
            route = "home/{username}",
            arguments = listOf(navArgument("username") { type = NavType.StringType })
        ) { backStackEntry ->
            val username = backStackEntry.arguments?.getString("username") ?: ""
            val homeViewModel: HomeViewModel = hiltViewModel()

            HomeScreen(viewModel = homeViewModel,username = username)
        }

        composable(
            route = "medicineDetail/{medicineId}",
            arguments = listOf(navArgument("medicineId") { type = NavType.StringType })
        ) { backStackEntry ->
            val medicineId = backStackEntry.arguments?.getString("medicineId")
//            val viewModel = hiltViewModel<HomeViewModel>()
//            val medicine = viewModel.getMedicineById(medicineId)
//            if (medicine != null) {
//                MedicineDetailsScreen(medicine = medicine)
//            }
        }
    }
}
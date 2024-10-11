package com.example.medicare.ui.navigationgraph

import androidx.compose.runtime.Composable
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
            LoginScreen(navController = navController, viewModel = LoginViewModel())
        }
        composable(NavigationItem.Home.route) {
            HomeScreen(navController = navController, viewModel = HomeViewModel())
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
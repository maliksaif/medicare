package com.example.medicare.ui.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.medicare.R
import com.example.medicare.ui.screens.auth.HomeScreen
import com.example.medicare.ui.screens.auth.LoginScreen
import com.example.medicare.ui.screens.dashboard.MedicineDetailsScreen
import com.example.medicare.ui.viewmodels.HomeViewModel
import com.example.medicare.ui.viewmodels.LoginViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set the composable content in the activity
        setContent {
            MyApp()
        }
    }
}

// Main composable function to host the Navigation graph
@Composable
fun MyApp() {
    // Hilt ViewModel initialization for navigation (optional)
    val navController = rememberNavController()

    // Set up the Theme for your app (optional, if using a custom theme)
    MaterialTheme {
        // Calling the NavGraph composable to handle navigation
        NavGraph(navController = navController)
    }
}

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            LoginScreen(navController = navController, viewModel = LoginViewModel())
        }
        composable("home") {
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
package com.example.medicare.ui.navigationgraph

enum class Screen(val route: String) {
    LOGIN("login"),
    HOME("home/{username}"),
    MEDICINE_DETAILS("medicineDetail/{medicineId}");
}

object Navigation {
    fun navigateToHome(username: String): String {
        return Screen.HOME.route.replace("{username}", username)
    }

    fun navigateToMedicineDetails(medicineId: String): String {
        return Screen.MEDICINE_DETAILS.route.replace("{medicineId}", medicineId.toString())
    }
}

sealed class NavigationItem(val route: String) {
    data object Login : NavigationItem(Screen.LOGIN.name)
    data object Home : NavigationItem(Screen.HOME.name)
    data object MedicineDetails : NavigationItem(Screen.MEDICINE_DETAILS.name)
}

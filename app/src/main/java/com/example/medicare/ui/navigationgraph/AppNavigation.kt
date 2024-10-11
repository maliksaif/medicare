package com.example.medicare.ui.navigationgraph

enum class Screen {
    LOGIN,
    HOME,
    MEDICINE_DETAILS
}

sealed class NavigationItem(val route: String) {
    object Login : NavigationItem(Screen.LOGIN.name)
    object Home : NavigationItem(Screen.HOME.name)
    object MedicineDetails : NavigationItem(Screen.MEDICINE_DETAILS.name)
}

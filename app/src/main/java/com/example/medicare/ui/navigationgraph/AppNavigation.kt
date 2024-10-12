package com.example.medicare.ui.navigationgraph

import com.example.medicare.domain.models.Medicine

enum class Screen(val route: String) {
    LOGIN("login"),
    HOME("home/{username}"),
    MEDICINE_DETAILS_WITH_ID("medicineDetail/{medicineId}")
}

object Navigation {
    fun navigateToHome(username: String): String {
        return Screen.HOME.route.replace("{username}", username)
    }

    fun navigateToMedicineDetails(medicineId: String): String {
        return Screen.MEDICINE_DETAILS_WITH_ID.route.replace("{medicineId}", medicineId)
    }
}


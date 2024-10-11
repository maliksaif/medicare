package com.example.medicare.ui.screens.dashboard.medicinedetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.medicare.domain.models.Medicine
import com.example.medicare.ui.common.AddSpacer

@Composable
fun MedicineDetailsScreen(viewModel: MedicineDetailsViewModel, medicineId: String) {

    viewModel.setMedicineId(medicineId)
    viewModel.medicineDetailsState.medicine?.let {
        MedicineDetails(it)
    }
}

@Composable
fun MedicineDetails(medicine: Medicine) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Medicine Details", style = MaterialTheme.typography.headlineLarge)
        AddSpacer(height = 16.dp)

        Text(text = "Name: ${medicine.name}", style = MaterialTheme.typography.titleLarge)
        Text(text = "Dose: ${medicine.dose}", style = MaterialTheme.typography.bodyLarge)
        Text(text = "Strength: ${medicine.strength}", style = MaterialTheme.typography.bodyLarge)
        Text(
            text = "Description: ${medicine.description}",
            style = MaterialTheme.typography.bodyLarge
        )

    }
}
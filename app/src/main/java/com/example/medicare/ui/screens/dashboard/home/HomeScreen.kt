package com.example.medicare.ui.screens.dashboard.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.medicare.domain.models.Medicine
import com.example.medicare.ui.common.AddSpacer


@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel(),username : String) {

    viewModel.setUsername(username)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        GreetUser(viewModel.homeUiState.greetingsMessage)
        ShowMedicines(viewModel)
    }
}

@Composable
fun LoadingScreen(showLoading : Boolean){

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun GreetUser(greetings: String) {
    Text(
        greetings,
        style = MaterialTheme.typography.bodyMedium
    )
    AddSpacer(height = 16.dp)
}

@Composable
fun ShowMedicines(viewModel: HomeViewModel) {
    LazyColumn {
        items(
            items = viewModel.homeUiState.medicineList,
            key = { it.id }) { medicine ->
            MedicineCard(medicine) {
                viewModel.onEvent(HomeEvent.OnMedicineSelected(medicine))
            }
        }
    }
}

@Composable
fun MedicineCard(medicine: Medicine, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(onClick = onClick),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Name: ${medicine.name}", style = MaterialTheme.typography.bodyLarge)
            Text("Dose: ${medicine.dose}")
            Text("Strength: ${medicine.strength}")
        }
    }
}
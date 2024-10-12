package com.example.medicare.ui.screens.dashboard.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MedicalServices
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.medicare.domain.models.Medicine
import com.example.medicare.ui.common.AddSpacer
import com.example.medicare.ui.common.LoadingScreen
import com.example.medicare.ui.navigationgraph.Navigation
import com.example.medicare.ui.screens.dashboard.home.HomeEvent.OnMedicineSelected
import com.example.medicare.R

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel(),
    username: String
) {

    viewModel.setUsername(username)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(R.dimen.spacing_16dp))
    ) {

        LoadingScreen(viewModel.homeUiState.isLoading)
        GreetUser(viewModel.homeUiState.greetingsMessage)
        ShowMedicines(navController, viewModel)
    }
}

@Composable
fun GreetUser(greetings: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.primary.copy(alpha = 0.9f),
                shape = RoundedCornerShape(dimensionResource(R.dimen.spacing_8dp))
            )
            .padding(dimensionResource(R.dimen.spacing_16dp))
    ) {
        Text(
            text = greetings,
            style = MaterialTheme.typography.headlineMedium.copy(
                color = MaterialTheme.colorScheme.onPrimary,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.align(Alignment.TopStart)
        )
    }

    AddSpacer(height = dimensionResource(R.dimen.spacing_16dp))
}

@Composable
fun ShowMedicines(navController: NavController, viewModel: HomeViewModel) {
    LazyColumn {
        items(
            items = viewModel.homeUiState.medicineList,
            key = { it.id }) { medicine ->
            MedicineCard(medicine) {
                viewModel.onEvent(OnMedicineSelected(medicine))
                navController.navigate(Navigation.navigateToMedicineDetails(medicineId = medicine.id))
            }
        }
    }
}

@Composable
fun MedicineCard(medicine: Medicine, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = dimensionResource(R.dimen.spacing_8dp), horizontal = dimensionResource(R.dimen.spacing_16dp))
            .clickable(onClick = onClick),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        ),
        shape = RoundedCornerShape(dimensionResource(R.dimen.spacing_12dp)),
        elevation = CardDefaults.cardElevation(dimensionResource(R.dimen.spacing_8dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.spacing_16dp)),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.MedicalServices, // Use a relevant icon
                contentDescription = null,
                modifier = Modifier
                    .size(dimensionResource(R.dimen.spacing_48dp))
                    .background(
                        MaterialTheme.colorScheme.primary.copy(alpha = 0.1f),
                        shape = CircleShape
                    )
                    .padding(dimensionResource(R.dimen.spacing_8dp)),
                tint = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.width(dimensionResource(R.dimen.spacing_16dp)))

            Column {
                Text(
                    text = medicine.name,
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = "Dose: ${medicine.dose}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = "Strength: ${medicine.strength}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

package com.example.medicare.ui.screens.dashboard.medicinedetails

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.medicare.domain.models.Medicine
import com.example.medicare.domain.usecases.GetMedicineByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MedicineDetailsViewModel @Inject constructor(private val getMedicineByIdUseCase: GetMedicineByIdUseCase) :
    ViewModel() {

//    var medicineDetailsState by mutableStateOf(MedicineDetailsState())
    private val _medicineDetailsState = MutableStateFlow(MedicineDetailsState())
    val medicineDetailsState: StateFlow<MedicineDetailsState> get() = _medicineDetailsState


    fun setMedicineId(medicineId: String) {

        viewModelScope.launch {
            val medicine = getMedicineByIdUseCase(medicineId)
            Log.e("TAG", "setMedicineId: $medicine")
            _medicineDetailsState.value = _medicineDetailsState.value.copy(
                selectedMedicineId = medicineId,
                medicine = medicine
            )
            Log.e("TAG", "setMedicineId: ${_medicineDetailsState.value.medicine}")
        }

    }

    fun setMedicine(medicine: Medicine) {
        _medicineDetailsState.value = _medicineDetailsState.value.copy(medicine = medicine)
    }

}
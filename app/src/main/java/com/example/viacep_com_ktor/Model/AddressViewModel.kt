package com.example.viacep_com_ktor.Model

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class AddressViewModel(
    private val repository: AddressNetwork
) : ViewModel() {

    private val _uiState = MutableStateFlow(AddressUi())
    val uiState = _uiState.asStateFlow()

    suspend fun findAddress(cep: String) {
        _uiState.update {
            Log.e("AddressViewModel1", "findAddress: ", )
            it.copy(
                isLoading = true,
                isError = false
            )
        }
        _uiState.update {
            try {
                Log.e("AddressViewModel2", "findAddress: ", )
                repository.getCep(cep)
                    .AddresstoAddressUi()
            } catch (t: Throwable) {
                Log.e("AddressViewModel3", "findAddress: ", t)
                _uiState.value.copy(
                    isError = true,
                    isLoading = false
                )
            }
        }
    }

}
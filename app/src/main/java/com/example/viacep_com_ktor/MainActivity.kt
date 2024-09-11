package com.example.viacep_com_ktor

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope

import com.example.viacep_com_ktor.Model.AddressDesignn
import com.example.viacep_com_ktor.Model.AddressViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val viewModel = koinViewModel<AddressViewModel>()
            val uiState by viewModel.uiState.collectAsState()
            val scope = rememberCoroutineScope()

                AddressDesignn(addressUi = uiState, viewModel)

        }}}



package com.example.viacep_com_ktor.Model

data class AddressUi (
    val logradouro: String = "",
    val bairro: String ="",
    val cidade: String = "",
    val estado: String = "",
    val isLoading: Boolean = false,
    val isError: Boolean = false


    )
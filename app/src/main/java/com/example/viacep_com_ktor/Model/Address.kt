package com.example.viacep_com_ktor.Model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Suppress("PLUGIN_IS_NOT_ENABLED")
@Serializable
class Address(

     private val logradouro: String,
    private  val bairro: String,
   @SerialName("localidade")
    private val cidade: String,
    @SerialName("uf")
    private val estado: String


) {

    fun AddresstoAddressUi()=AddressUi(
        logradouro=logradouro,
        bairro=bairro,
        cidade=cidade,
        estado=estado
    )





    }


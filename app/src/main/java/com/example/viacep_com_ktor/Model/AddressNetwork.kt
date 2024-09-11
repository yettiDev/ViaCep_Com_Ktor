package com.example.viacep_com_ktor.Model

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class AddressNetwork( private val CLient: HttpClient = HttpClient()) {



    suspend fun getCep(cep:String):Address{
         return  CLient
             .get("https://viacep.com.br/ws/$cep/json/")
             .body()
    }

}
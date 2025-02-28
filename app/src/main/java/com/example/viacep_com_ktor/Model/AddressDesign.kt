@file:Suppress("UNUSED_EXPRESSION")

package com.example.viacep_com_ktor.Model

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
 import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.viacep_com_ktor.R
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch


@Composable

fun AddressDesignn(
    addressUi:AddressUi,

addressViewModel: AddressViewModel
    ){
    val corountine = rememberCoroutineScope()

    Column(modifier= Modifier
        .fillMaxSize()
        .background(Color.LightGray)
        .padding(2.dp)
        , horizontalAlignment = Alignment.CenterHorizontally
        , verticalArrangement = Arrangement.Center

    ) {
        when {
            addressUi.isError -> {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Red)
                ) {
                    Text(
                        text = "Falha ao buscar o endereço",
                        Modifier
                            .padding(8.dp)
                            .align(Alignment.Center),
                        color = Color.White
                    )
                }
            }

            addressUi.isLoading -> {
                Box(Modifier.fillMaxWidth()) {
                    CircularProgressIndicator(
                        Modifier
                            .padding(8.dp)
                            .align(Alignment.Center)
                    )
                }
            }
        }


        Box(    modifier = Modifier.fillMaxWidth().offset(x = 0.dp)
            .offset(y = 100.dp)
            , Alignment.Center

        ) {
           Column( horizontalAlignment = Alignment.CenterHorizontally

           ) {
               Text(
                   text = "YETTI FIND CEP",style = TextStyle(
                       color = Color.Black,
                       fontSize = 24.sp,
                       fontWeight = FontWeight.Bold,
                       fontStyle = FontStyle.Italic
                   )
               )
               Image(painter = painterResource(id = R.drawable.yetticon ), contentDescription ="yettiIcon"
                   , modifier = Modifier

               )
           }


        }
        

        Column(
            modifier = Modifier
                .padding(10.dp)
            ,
            verticalArrangement = Arrangement.spacedBy(8.dp)

        ) {
            val addressTextFieldModifier = Modifier
                .fillMaxWidth()

            var cep by remember {
                mutableStateOf("")
            }
            Row(
                Modifier
                    .fillMaxWidth()
                    .offset(x = 0.dp)
                    .offset(y = 120.dp)
                ,
                verticalAlignment = Alignment.CenterVertically

            ) {
                TextField(
                    value = cep,
                    onValueChange = {
                        if (it.length < 9) {
                            cep = it
                        }
                    },
                    Modifier.weight(1f),
                    label = {
                        Text(text = "CEP"

                        )

                    },
                    visualTransformation = CepVisualTransformation
                )
                val coroutine = rememberCoroutineScope()
                IconButton(onClick = {
                    corountine.launch {
                        addressViewModel.findAddress(cep)
                    }


                })

                {
                    Icon(
                        Icons.Default.Search,
                        "lupa indicando ação de busca",
                        Modifier.fillMaxHeight()
                    )
                }
            }







            }
          Box(modifier= Modifier
              .offset(x = 0.dp)
              .offset(y = 40.dp)
          ) {



              Column(modifier= Modifier
                  .fillMaxSize()
                  .padding(10.dp)
                  .offset(x = 0.dp)
                  .offset(y = 70.dp)
                  , verticalArrangement = Arrangement.spacedBy(8.dp)
                  /*LOUGRADOURO*/
              ) {
                  val addressTextFieldModifier = Modifier
                  var logradouro by remember(addressUi.logradouro) {
                      mutableStateOf(addressUi.logradouro)

                  }

                  TextField(value =logradouro, onValueChange ={
                      logradouro=it

                  },
                      addressTextFieldModifier,
                      label = {
                          Text(text = "Logradouro"
                              , modifier = Modifier.fillMaxWidth(0.9f))

                      }      , readOnly = true)





                  /*BAIRRO*/
                  var bairro by remember(addressUi.bairro) {
                      mutableStateOf(addressUi.bairro)

                  }

                  TextField(value =bairro, onValueChange ={

                      bairro=it

                  },

                      addressTextFieldModifier,
                      label = {
                          Text(text = "Bairro"
                              , modifier = Modifier.fillMaxWidth(0.9f))

                      }
                      , readOnly = true

                  )





                  /*ESTADO*/
                  var estado by remember(addressUi.estado) {

                      mutableStateOf(addressUi.estado)
                  }
                  TextField(value =estado, onValueChange ={

                      estado=it
                  },
                      addressTextFieldModifier,

                      label = {
                          Text(text = "Estado"
                              , modifier = Modifier.fillMaxWidth(0.9f)
                          )

                      }      , readOnly = true)



              }
          }

       }

       }





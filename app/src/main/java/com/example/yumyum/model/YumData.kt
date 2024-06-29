package com.example.yumyum.model

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf

data class YumData(var name:String, var price:Double, var quantity: MutableState<Int> = mutableStateOf(0), val totalPrice: State<Double> = derivedStateOf { quantity.value * price })
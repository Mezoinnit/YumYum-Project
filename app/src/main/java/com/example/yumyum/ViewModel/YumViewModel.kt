package com.example.yumyum.ViewModel

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.yumyum.model.yumList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.math.roundToLong

class YumViewModel: ViewModel() {

    private val yumState = MutableStateFlow(yumList)

    private var count = mutableIntStateOf(0)

    var quantity = mutableIntStateOf(0)

    fun yumLogic(){

        viewModelScope.launch(Dispatchers.IO) {
            if (count.intValue < yumState.value.size - 1) count.intValue++ else count.intValue = 0
        }
    }

    fun yumName(): String{
        return yumState.value[count.intValue].name
    }
    fun yumPrice(): Double{
        return yumState.value[count.intValue].price
    }

    fun totalAmount(): Double{
        return yumPrice().times(quantity.intValue)
    }

}
package com.example.yumyum.ViewModel

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.yumyum.model.YumData
import com.example.yumyum.model.yumList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.math.roundToLong

class YumViewModel: ViewModel() {

    private val yumcontent = MutableStateFlow(yumList())

    val yumDataList = yumcontent.asStateFlow()

    private var count = mutableIntStateOf(0)

    private var totalQuantity = mutableIntStateOf(0)
    private var totalPrice = mutableDoubleStateOf(0.0)

    fun yumLogic(){
        viewModelScope.launch(Dispatchers.IO) {
            yumPriceLogic()
            yumQuantityLogic()
        }
    }

    fun yumQuantityLogic(): Int {
        var y = yumcontent.value[0].quantity.value
        return totalQuantity.intValue
    }
    fun yumPriceLogic(): Double {
        for(x in 0 until yumcontent.value.size){
            totalPrice.doubleValue = yumcontent.value[x].price.times(yumcontent.value[x].quantity.value)
        }
        return totalPrice.doubleValue
    }

}
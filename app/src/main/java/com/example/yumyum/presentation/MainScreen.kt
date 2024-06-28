package com.example.yumyum.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.yumyum.R
import com.example.yumyum.presentation.components.MainContent
import com.example.yumyum.presentation.components.TopAppBar

@Composable
fun MainScreen(){
    Scaffold(modifier = Modifier
        .statusBarsPadding()
        .navigationBarsPadding(), topBar = { TopAppBar(R.string.app_name)}) { PaddingValues ->
        MainContent(modifier = Modifier.padding(PaddingValues))
    }
}
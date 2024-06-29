package com.example.yumyum.presentation.components

import android.annotation.SuppressLint
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.yumyum.ViewModel.YumViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.yumyum.model.YumData
import com.example.yumyum.model.yumList
import com.example.yumyum.presentation.dimenstions.bodyPadding
import com.example.yumyum.presentation.dimenstions.buttonHeight
import com.example.yumyum.presentation.dimenstions.buttonTopPadding
import com.example.yumyum.presentation.dimenstions.buttonWidth
import com.example.yumyum.presentation.dimenstions.cardHeight
import com.example.yumyum.presentation.dimenstions.corners

@Composable
fun TopAppBar(@StringRes title: Int) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = bodyPadding + 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = stringResource(id = title),
            style = MaterialTheme.typography.bodyLarge.copy(fontSize = 32.sp)
        )
        Icon(imageVector = Icons.Default.Info, contentDescription = null)
    }

}

@SuppressLint("DefaultLocale")
@Composable
fun MainContent(modifier: Modifier, yumList: List<YumData>) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(bodyPadding)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .then(modifier)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(cardHeight)
                .clip(RoundedCornerShape(corners))
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bodyPadding)
            ) {
                Text(text = "Menu", style = MaterialTheme.typography.titleLarge)
                LazyColumn() {
                    items(yumList) {
                        MenuList(data = it)
                    }

                }
            }
        }
    }
}

@Composable
fun MenuList(data: YumData) {
    Column(modifier = Modifier.padding(vertical = 16.dp)) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = data.name)
            Text(text = "$${String.format("%.2f", data.totalPrice.value)}")
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row {
                Button(
                    onClick = { if (data.quantity.value > 0) data.quantity.value-- else data.quantity.value },
                    modifier = Modifier
                        .width(buttonWidth)
                        .height(buttonHeight)
                ) {
                    Text(text = "-")
                }
                Button(
                    onClick = { data.quantity.value++ },
                    modifier = Modifier
                        .padding(start = buttonTopPadding)
                        .width(buttonWidth)
                        .height(buttonHeight)
                ) {
                    Text(text = "+")
                }
            }
            Text(text = "${data.quantity.value}")
        }
    }
}
package com.example.appnewkool.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun HomeScreen() {
    Card(modifier = Modifier.padding(8.dp),
        shape = RoundedCornerShape(8.dp), elevation = 1.dp) {
        Text(text = "Summer", modifier = Modifier.fillMaxSize())
    }
}

@Preview
@Composable
fun ItemInfo() {
    Card(
        modifier = Modifier.padding(8.dp),
        shape = RoundedCornerShape(8.dp), elevation = 1.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Tên xe")
                Text(text = "Accent")
            }
            Column(modifier = Modifier.weight(3f)) {
                Row() {
                    Text(text = "Kính lái")
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(text = "90 cm x 90 cm")
                }
            }
        }

    }

}
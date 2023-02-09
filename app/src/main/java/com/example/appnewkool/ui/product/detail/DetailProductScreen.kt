package com.example.appnewkool.ui.product.detail

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController

@Preview
@Composable
fun DetailProductScreen(
//    detailProductViewModel: DetailProductViewModel,
    navControllor: (() -> Unit)? = null
) {
    Text(text = "This is a Detail")
}
package com.example.appnewkool.ui.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.appnewkool.R
import com.example.appnewkool.data.model.Product
import com.example.appnewkool.ui.theme.BlueWhite


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    navToDetailSc: ()-> Unit
) {

    val listProduct = viewModel.listProducts.observeAsState(listOf())
    val list = mutableListOf<String?>()
    listProduct.value.forEach {
        list.add(it.hangXe)
    }
    var search by remember { mutableStateOf("") }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Column() {
            Box(
                modifier = Modifier
                    .background(
                        color = BlueWhite,
                        shape = RoundedCornerShape(bottomEnd = 60.dp)
                    )
            ) {
                Column(
                    modifier = Modifier
                        .padding(top = 15.dp, start = 10.dp, end = 10.dp, bottom = 5.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.ArrowBack,
                            contentDescription = "",
                            tint = Color.White,
                            modifier = Modifier
                                .padding(horizontal = 10.dp)
                        )
                        SearchFeature(search) { search = it }
                    }
                    Box() {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 10.dp, start = 15.dp),
                            text = "NEWKOOL FILM", color = Color.White,
                            fontSize = 40.sp,
                            fontFamily = FontFamily(
                                Font(
                                    resId = R.font.modulusmedium,
                                    weight = FontWeight.Black
                                )
                            ),
                        )
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 30.dp),
                        contentAlignment = Alignment.BottomEnd
                    ) {
                        Text(
                            text = "Film for Car",
                            color = Color.White,
                            fontSize = 20.sp,
                            fontFamily = FontFamily(
                                Font(
                                    resId = R.font.modulusbold
                                )
                            ),
                            fontWeight = FontWeight.ExtraBold
                        )
                    }
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(6f)
            ) {
                Column() {
                    LazyRow(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 7.dp)
                    ) {
                        items(list.size) {
                            Row() {
                                Chip(
                                    onClick = {  },
                                    border = BorderStroke(
                                        ChipDefaults.OutlinedBorderSize,
                                        color = Color.Black
                                    ),
                                    colors = ChipDefaults.chipColors(
                                        backgroundColor = Color.Transparent,
                                        contentColor = Color.Black
                                    )
                                ) {
                                    list.get(it)?.let { it1 -> Text(text = it1) }
                                }
                                Spacer(modifier = Modifier.width(10.dp))
                            }
                        }
                    }
                    LazyVerticalGrid(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 5.dp)
                            .weight(1f),
                        columns = GridCells.Fixed(2)
                    ) {
                        items(listProduct.value.size) {
                            listProduct.value.forEach {
                                ItemInfo(it){
                                    navToDetailSc.invoke()
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun SearchFeature(search:String,seachChange:(String)-> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White, shape = RoundedCornerShape(30.dp)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            value = search,
            onValueChange = seachChange,
            modifier = Modifier
                .weight(1f),
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.Black,
                backgroundColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                placeholderColor = Color.Gray
            ),
            placeholder = {
                Text(
                    text = "Search",
                )
            }
        )
        IconButton(onClick = { }) {
            Icon(
                imageVector = Icons.Rounded.Search,
                contentDescription = "",
                tint = BlueWhite,
                modifier = Modifier.background(color = Color.Transparent)
            )
        }
        Spacer(modifier = Modifier.width(3.dp))
    }
}


@Composable
fun ItemInfo(
    product: Product
    = Product(
        1, "toyota", "toyota", "90 cm x 90 cm",
        "50 cm x 30 cm", "20 cm x 20 cm", "30 cm x 30 cm", null, null, null, null
    ),
    changeScreen: ()->Unit
) {
    Card(
        modifier = Modifier.padding(start = 5.dp, end = 5.dp, bottom = 10.dp),
        shape = RoundedCornerShape(8.dp), elevation = 1.dp, backgroundColor = BlueWhite
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .background(color = BlueWhite)
                .clickable { changeScreen.invoke() }
        ) {
            Text(
                text = product.tenXe.uppercase(),
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.White, shape = RoundedCornerShape(5.dp)),
                textAlign = TextAlign.Center,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(4.dp))
            if (product.kinhLai != null) Row() {
                Text(text = "Kính lái", color = Color.White)
                Spacer(modifier = Modifier.width(5.dp))
                Text(text = product.kinhLai, color = Color.White)
            }
            if (product.suonTruoc != null)
                Row() {
                    Text(text = "Sườn trước", color = Color.White)
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(text = product.suonTruoc, color = Color.White)
                }
            if (product.suonSau != null)
                Row() {
                    Text(text = "Sườn sau", color = Color.White)
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(text = product.suonSau, color = Color.White)
                }
        }
    }
}

@Preview
@Composable
fun PreHome(){

}


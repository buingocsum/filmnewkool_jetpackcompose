package com.example.appnewkool.ui.login.signin

import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.appnewkool.R
import com.example.appnewkool.data.model.Account
import com.example.appnewkool.ui.theme.WhiteBlue
import com.example.appnewkool.ui.theme.WhiteBlue2

@Preview
@Composable
fun SignInScreen(
    viewModel: SignInViewModel = hiltViewModel()
) {
    val inputTextUserName: MutableState<String> = remember { mutableStateOf("") }
    val inputTextPassword: MutableState<String> = remember { mutableStateOf("") }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color.Blue, Color.Black)
                )
            )
            .padding(10.dp)
    ) {
        DrawArc(
            Modifier
                .absoluteOffset(x = -65.dp, y = -320.dp)
                .size(400.dp)
        )
        Row() {
            Spacer(modifier = Modifier.weight(1f))

            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(4f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(70.dp))
                Text(
                    text = "Login", color = Color.White, fontSize = 70.sp,
                    fontFamily = FontFamily(Font(R.font.modulusbold)),
                    fontWeight = FontWeight.Black
                )
                Spacer(modifier = Modifier.weight(1f))

                TvInput(
                    placeholderText = "Username",
                    leadingIcon = {
                        Image(
                            painter = painterResource(id = R.drawable.leading_username),
                            contentDescription = "",
                            Modifier.size(30.dp),
                            colorFilter = ColorFilter.tint(color = Color.White)
                        )
                    },
                    inputText = inputTextUserName
                )
                Spacer(modifier = Modifier.height(30.dp))
                TvInput(
                    placeholderText = "Password",
                    leadingIcon = {
                        Image(
                            imageVector = ImageVector.vectorResource(id = R.drawable.ic_baseline_lock_24),
                            contentDescription = "",
                            Modifier.size(30.dp),
                            colorFilter = ColorFilter.tint(color = Color.White)
                        )
                    },
                    inputText = inputTextPassword
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Haven't Account?", color = Color.White,
                        fontFamily = FontFamily(Font(R.font.modulusmedium))
                    )

                    Text(
                        modifier = Modifier.clickable(onClick = {}),
                        text = "Skip",
                        color = WhiteBlue2,
                        fontFamily = FontFamily(Font(R.font.modulusbold)),
                        fontWeight = FontWeight.Black
                    )

                }
                Spacer(modifier = Modifier.height(32.dp))
                BtnSignIn(inputTextUserName,inputTextPassword) {
                    viewModel.signIn(it)
                }
                Spacer(modifier = Modifier.weight(1f))
            }
            Spacer(modifier = Modifier.weight(1f))

        }
    }

}


@Composable
fun DrawArc(modifier: Modifier) {
    Canvas(modifier) {
        val brush = Brush.verticalGradient(listOf(Color.White, Color.Blue, Color.Blue, Color.Black))
        drawArc(
            brush = brush,
            startAngle = 0f,
            sweepAngle = 180f,
            useCenter = true,
            size = Size(500.dp.toPx(), 500.dp.toPx())
        )
    }
}

@Composable
fun BtnSignIn(
    inputUserNameText: MutableState<String>,
    inputPasswordText: MutableState<String>,
    onClick: (Account) -> Unit) {
    Button(
        onClick = {
            if(inputUserNameText.value!="" && inputPasswordText.value!= "") {
                onClick(Account(inputUserNameText.value,inputPasswordText.value))
            } else{
                Log.e("TAG", "BtnSignIn: " + "null" )
            }
        }, shape = CircleShape, modifier = Modifier.size(70.dp),
        colors = ButtonDefaults.buttonColors(WhiteBlue)
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_baseline_arrow_forward_ios_24),
            "",
            tint = Color.Black,
            modifier = Modifier.size(70.dp)
        )
    }
}


@Composable
fun TvInput(
    placeholderText: String,
    leadingIcon: (@Composable () -> Unit)? = null,
    inputText: MutableState<String>,
) {
    BasicTextField(
        value = inputText.value,
        textStyle = TextStyle(
            color = Color.White,
            fontSize = 20.sp,
            fontFamily = FontFamily(Font(R.font.modulusbold))
        ),
        onValueChange = {
            inputText.value = it
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(color = WhiteBlue, shape = RoundedCornerShape(40.dp))
            .padding(horizontal = 20.dp),
        singleLine = true,
        decorationBox = { innerTextField ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .background(color = WhiteBlue, shape = RoundedCornerShape(40.dp)),
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (leadingIcon != null) leadingIcon()
                Box(Modifier.weight(1f)) {
                    if (inputText.value.isEmpty()) Text(
                        placeholderText,
                        style = LocalTextStyle.current.copy(
                            color = Color.White,
                            fontSize = 20.sp,
                            fontFamily = FontFamily(Font(R.font.modulusbold))
                        )
                    )
                    innerTextField()
                }
            }
        }
    )
}

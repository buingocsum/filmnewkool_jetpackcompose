package com.example.appnewkool.ui.login.signin

import android.util.Log
import androidx.compose.foundation.Canvas
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
import androidx.navigation.NavController
import com.example.appnewkool.R
import com.example.appnewkool.data.model.Account
import com.example.appnewkool.ui.login.state.EmailState
import com.example.appnewkool.ui.login.state.PasswordState
import com.example.appnewkool.ui.nav.Screen
import com.example.appnewkool.ui.theme.WhiteBlue
import com.example.appnewkool.ui.theme.WhiteBlue2

@Composable
fun SignInScreen(
    viewModel: SignInViewModel = hiltViewModel(),
    navController: NavController
) {
    val emailState = remember { EmailState() }
    val passwordState = remember { PasswordState() }
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

                EmailInput(
                    inputText = emailState
                )
                Spacer(modifier = Modifier.height(30.dp))
                PasswordInput(
                    inputText = passwordState
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
                BtnSignIn(emailState, passwordState, navController) {
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
    inputUserNameText: EmailState,
    inputPasswordText: PasswordState,
    navController: NavController,
    onClick: (Account) -> Unit
) {
    Button(
        onClick = {

            if (inputUserNameText.text != "" && inputPasswordText.text != "") {
                onClick(Account(inputUserNameText.text, inputPasswordText.text))
            } else {
                Log.e("TAG", "BtnSignIn: " + "null")
            }

            navController.navigate(Screen.HomeScreen.route)

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


//@Composable
//fun TvInput(
//    placeholderText: String = "abc",
//    leadingIcon: (@Composable () -> Unit)? = null,
//    inputText: MutableState<String>? = mutableStateOf("a"),
//) {
//    BasicTextField(
//        value = inputText!!.value,
//        textStyle = TextStyle(
//            color = Color.White,
//            fontSize = 20.sp,
//            fontFamily = FontFamily(Font(R.font.modulusbold))
//        ),
//        onValueChange = {
//            inputText.value = it
//        },
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(50.dp)
//            .background(color = WhiteBlue, shape = RoundedCornerShape(40.dp))
//            .padding(horizontal = 20.dp),
//        singleLine = true,
//        decorationBox = { innerTextField ->
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(50.dp)
//                    .background(color = WhiteBlue, shape = RoundedCornerShape(40.dp)),
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//                if (leadingIcon != null) leadingIcon()
//                Box(Modifier.weight(1f)) {
//                    if (inputText.value.isEmpty()) Text(
//                        placeholderText,
//                        style = LocalTextStyle.current.copy(
//                            color = Color.White,
//                            fontSize = 20.sp,
//                            fontFamily = FontFamily(Font(R.font.modulusbold))
//                        )
//                    )
//                    innerTextField()
//                }
//            }
//        }
//    )
//}

@Preview
@Composable
fun ShowError(){
    Text(text = "isError", color = Color.Red)
}

@Composable
fun EmailInput(
    inputText: EmailState
) {
    BasicTextField(
        value = inputText.text,
        textStyle = TextStyle(
            color = Color.White,
            fontSize = 20.sp,
            fontFamily = FontFamily(Font(R.font.modulusbold))
        ),
        onValueChange = {
            inputText.text = it
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
                Icon(
                    painter = painterResource(id = R.drawable.leading_username),
                    contentDescription = "iconEmail",
                    modifier = Modifier.size(30.dp),
                    tint = Color.White
                )
                Box(Modifier.weight(1f)) {
                    if (inputText.text.isEmpty()) Text(
                        text = "Username",
                        style = LocalTextStyle.current.copy(
                            color = Color.White,
                            fontSize = 20.sp,
                            fontFamily = FontFamily(Font(R.font.modulusbold))
                        )
                    )
                    innerTextField()
                }
                ShowError()
            }
        }
    )
}

@Composable
fun PasswordInput(
    inputText: PasswordState,
) {
    BasicTextField(
        value = inputText.text,
        textStyle = TextStyle(
            color = Color.White,
            fontSize = 20.sp,
            fontFamily = FontFamily(Font(R.font.modulusbold))
        ),
        onValueChange = {
            inputText.text = it
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
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_baseline_lock_24),
                    contentDescription = "iconEmail",
                    modifier = Modifier.size(30.dp),
                    tint = Color.White
                )
                Box(Modifier.weight(1f)) {
                    if (inputText.text.isEmpty()) Text(
                        text = "Password",
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

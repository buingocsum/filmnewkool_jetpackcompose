package com.example.appnewkool.ui.login.signup

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
import com.example.appnewkool.R
import com.example.appnewkool.ui.theme.WhiteBlue
import com.example.appnewkool.ui.theme.WhiteBlue2


@Preview
@Composable
fun SignUpScreen() {
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
//        Circle()
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
                    text = "Register", color = Color.White, fontSize = 63.sp,
                    fontFamily = FontFamily(Font(R.font.modulusbold)),
                    fontWeight = FontWeight.Black
                )
                Spacer(modifier = Modifier.weight(1f))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .background(color = WhiteBlue, shape = RoundedCornerShape(40.dp))
                        .padding(horizontal = 20.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.leading_username),
                        contentDescription = "",
                        Modifier.size(30.dp),
                        colorFilter = ColorFilter.tint(color = Color.White)
                    )
                    BasicTextField(
                        value = "Username", onValueChange = {},
                        Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp),
                        textStyle = TextStyle.Default.copy(
                            color = Color.White,
                            fontFamily = FontFamily(Font(R.font.modulusbold)),
                            fontSize = 20.sp
                        )
                    )
                }

                Spacer(modifier = Modifier.size(30.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .background(color = WhiteBlue, shape = RoundedCornerShape(40.dp))
                        .padding(horizontal = 20.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_baseline_email_24),
                        contentDescription = "email",
                        Modifier.size(30.dp),
                        colorFilter = ColorFilter.tint(color = Color.White)
                    )
                    BasicTextField(
                        value = "Email", onValueChange = {},
                        Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp),
                        textStyle = TextStyle.Default.copy(
                            color = Color.White,
                            fontFamily = FontFamily(Font(R.font.modulusbold)),
                            fontSize = 20.sp
                        )
                    )
                }

                Spacer(modifier = Modifier.size(30.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .background(color = WhiteBlue, shape = RoundedCornerShape(40.dp))
                        .padding(horizontal = 20.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_baseline_lock_24),
                        contentDescription = "",
                        Modifier.size(30.dp),
                        colorFilter = ColorFilter.tint(color = Color.White)
                    )
                    BasicTextField(
                        value = "Password",
                        onValueChange = {},
                        Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp),
                        textStyle = TextStyle.Default.copy(
                            color = Color.White,
                            fontFamily = FontFamily(Font(R.font.modulusbold)),
                            fontSize = 20.sp
                        )
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Already Have an Account?", color = Color.White,
                        fontFamily = FontFamily(Font(R.font.modulusmedium))
                    )

                    Text(
                        modifier = Modifier.clickable(onClick = {}),
                        text = "Login",
                        color = WhiteBlue2,
                        fontFamily = FontFamily(Font(R.font.modulusbold)),
                        fontWeight = FontWeight.Black
                    )

                }
                Spacer(modifier = Modifier.height(32.dp))
                Button(
                    onClick = {}, shape = CircleShape, modifier = Modifier.size(70.dp),
                    colors = ButtonDefaults.buttonColors(WhiteBlue)
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_baseline_arrow_forward_ios_24),
                        "",
                        tint = Color.Black,
                        modifier = Modifier.size(70.dp)
                    )
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

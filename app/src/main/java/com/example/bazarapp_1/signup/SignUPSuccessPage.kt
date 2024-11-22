package com.example.bazarapp_1.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.bazarapp_1.AuthViewModel
import com.example.bazarapp_1.ForgetPasswordPage
import com.example.bazarapp_1.R
import com.example.bazarapp_1.ui.theme.BazarApp_1Theme
import com.example.bazarapp_1.ui.theme.robotofontfamily

@Composable
fun SignUpSuccessScreen(modifier: Modifier = Modifier, navController: NavHostController, authViewModel: AuthViewModel) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Column(
            modifier = Modifier
                .padding(top = 250.dp, start = 10.dp),
         //       .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {
            Image(
                painter = painterResource(R.drawable.signupsuccess),
                contentDescription = "SignUp Success",
                modifier = Modifier
                 //   .align(Alignment.CenterHorizontally)
                    .padding(top = 0.dp, bottom = 10.dp)
            )
            BodyText()
            GetStartedButton(
                modifier = Modifier,
                navController = navController
            )
        }
    }
}

@Composable
fun BodyText() {
    val annotatedString = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = Color.Black,
                fontSize = 24.sp,
                fontFamily = robotofontfamily,
                fontWeight = FontWeight.Bold,
            )
        ) {
            append("Congratulations!\n")
        }
        withStyle(
            style = SpanStyle(
                color = Color(0xffA6A6A6),
                fontSize = 16.sp,
                fontFamily = robotofontfamily,
                fontWeight = FontWeight.Normal,
            )
        ) {
            append("your account is complete,please enjoy the\nbest menu from us.")
        }
    }

    Box(
       // modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = annotatedString,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .align(Alignment.Center)
                /*.align(Alignment.BottomCenter)
                .padding(bottom = 10.dp, top = 35.dp)
*/
        )
    }
}

@Composable
fun GetStartedButton(modifier: Modifier = Modifier,navController: NavHostController) {
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF54408C)
        ),
        shape = RoundedCornerShape(40.dp),
        onClick = {
            // new nav
            navController.navigate(ForgetPasswordPage)
        },
        modifier = Modifier
            .padding(start = 15.dp, end = 15.dp, top = 50.dp)
            .height(55.dp)

    ) {
        Text(
            text = "Get Started",
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .fillMaxWidth(),
            //   .padding(start = 60.dp),
            textAlign = TextAlign.Center

        )
    }
}
@Preview(showBackground = true)
@Composable
fun SignUpSuccessPreview() {
    BazarApp_1Theme {
        SignUpSuccessScreen(
            modifier = Modifier,
            navController = rememberNavController(),
            authViewModel = AuthViewModel()
        )
    }
}

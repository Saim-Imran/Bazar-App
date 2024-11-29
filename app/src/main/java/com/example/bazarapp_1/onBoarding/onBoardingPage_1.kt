package com.example.bazarapp_1.onBoarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.bazarapp_1.LoginPage
import com.example.bazarapp_1.OnBoardingPage2
import com.example.bazarapp_1.R
import com.example.bazarapp_1.common.OnBoardButton
import com.example.bazarapp_1.ui.theme.BazarApp_1Theme
import com.example.bazarapp_1.ui.theme.robotofontfamily

@Composable
fun OnBoardingScreen1(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Text(
            text = "Skip",
            color = Color(0xff54408C),
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = robotofontfamily,
            modifier = Modifier
                .padding(top = 35.dp, start = 25.dp)
                .clickable { navController.navigate(LoginPage) }
        )

        MainBodyScreen1(
            navController = navController
        )
    }
}

@Composable
fun MainBodyScreen1(navController: NavHostController) {
    Column(modifier = Modifier)
    {

        Image(
            painter = painterResource(R.drawable.board_read1),
            contentDescription = "OnBoardingScreen1 read img",
            modifier = Modifier
                .fillMaxWidth()
              //  .height(120.dp)
                .padding(top = 80.dp, start = 16.dp, end = 16.dp)
        )

        Text(
            text = "Now reading books\nwill be easier",
            color = Color.Black,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = robotofontfamily,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(top = 30.dp)
                .align(Alignment.CenterHorizontally)
        )

        Text(
            text = "   Discover new worlds,join a vibrant\nreading community.Start your reading\n    adventure effortlessly with us.",
            color = Color(0xffA6A6A6),
            lineHeight = 24.sp,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = robotofontfamily,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 20.dp)
        )

        Column(modifier = Modifier.padding(top = 80.dp)) {
            Button(
                onClick = {navController.navigate(OnBoardingPage2)},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(start = 25.dp, end = 25.dp, top = 10.dp),
                enabled = true,
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White,
                    containerColor = Color(0xff54408C),
                )
            ) {
                Text(
                    text = "Continue",
                    fontSize = 16.sp,
                    fontFamily = robotofontfamily
                )
            }

            Text(
                text = "SignIn",
                color = Color(0xff54408C),
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                fontFamily = robotofontfamily,
                modifier = Modifier
                    .padding(top = 15.dp)
                    .align(Alignment.CenterHorizontally)
            )


        }
    }
}



@Preview(showBackground = true)
@Composable
fun BaordScreen1Preview() {
    BazarApp_1Theme {
        OnBoardingScreen1(
            navController = rememberNavController()
        )
    }
}
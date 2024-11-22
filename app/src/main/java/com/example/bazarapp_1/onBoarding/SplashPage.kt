package com.example.bazarapp_1.onBoarding


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.bazarapp_1.OnBoardingPage1
import com.example.bazarapp_1.OnBoardingPage2
import com.example.bazarapp_1.R
import com.example.bazarapp_1.ui.theme.BazarApp_1Theme
import com.example.bazarapp_1.ui.theme.robotofontfamily


@Composable
fun SplashScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xff54408C))
    ) {
        Row(
             modifier = Modifier
                 .align(Alignment.Center)
         ) {
            Column {
                Row {
                    Image(
                        painter = painterResource(R.drawable.bazar_logo),
                        contentDescription = "logo_img",
                        modifier = Modifier
                            .padding(start = 40.dp)
                    )
                    Text(
                        text = "Bazar.",
                        color = Color.White,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = robotofontfamily,
                        modifier = Modifier
                            .padding(start = 10.dp, top = 10.dp)
                        //  .clickable { navController.navigate(OnBoardingPage1) }
                    )
                }
                Button(
                    onClick = {navController.navigate(OnBoardingPage1)},
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .padding(start = 25.dp, end = 25.dp, top = 10.dp),
                    enabled = true,
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color(0xff54408C),
                        containerColor = Color.White,
                    )
                ) {
                    Text(
                        text = "Continue",
                        fontSize = 16.sp,
                        fontFamily = robotofontfamily
                    )
                }
            }
         }

    }

}

@Composable
fun PagerScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    val pagerState = rememberPagerState(
        initialPage = 0,

        pageCount = { 4 }
    )

    HorizontalPager(
        state = pagerState,
        modifier = Modifier.fillMaxSize()
    ) { page ->

        when (page) {
            0 -> SplashScreen(navController = navController)
            1 -> OnBoardingScreen1(navController = navController)
            2 -> OnBoardingScreen2(navController = navController)
            3 -> OnBoardingScreen3(navController = navController)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BazarApp_1Theme {
        SplashScreen(navController = rememberNavController())
    }
}
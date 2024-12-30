package com.example.bazarapp_1.onBoarding


import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.bazarapp_1.AuthState
import com.example.bazarapp_1.AuthViewModel
import com.example.bazarapp_1.HomePage
import com.example.bazarapp_1.IntroPage
import com.example.bazarapp_1.R
import com.example.bazarapp_1.SplashScreen1
import com.example.bazarapp_1.ui.theme.robotofontfamily
@Composable
fun SplashScreen(navController: NavHostController, authViewModel: AuthViewModel) {
    Log.e("Splash screen", "Successfully open splash screen ")

    val authState by authViewModel.authState.observeAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xff54408C))
    ) {
        Row(
            modifier = Modifier.align(Alignment.Center)
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
                    )
                }
                Button(
                    onClick = {

                        if (authState is AuthState.Authenticated) {

                            navController.navigate(HomePage) {
                                popUpTo(SplashScreen1) { inclusive = true }
                            }
                            Log.e("Splash Page", "User is logged in. Navigating to Home Page.")
                        } else {

                            navController.navigate(IntroPage) {
                                popUpTo(SplashScreen1) { inclusive = true }
                            }
                            Log.e("Splash Page", "User is not logged in. Navigating to Intro Page.")
                        }
                    },
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
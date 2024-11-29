package com.example.bazarapp_1.ForgetPassword

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.bazarapp_1.AuthViewModel
import com.example.bazarapp_1.ForgetPasswordEmailPage
import com.example.bazarapp_1.ForgetPasswordPNPage
import com.example.bazarapp_1.ProfilePage
import com.example.bazarapp_1.R
import com.example.bazarapp_1.common.ForgetPasswordPageHeader
import com.example.bazarapp_1.ui.theme.BazarApp_1Theme
import com.example.bazarapp_1.ui.theme.robotofontfamily

@Composable
fun ForgetPasswordScreen(modifier: Modifier = Modifier, navController: NavHostController, authViewModel: AuthViewModel) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Column {
            Image(
                painter = painterResource(R.drawable.arrow_left_outline),
                contentDescription = "backward",
                modifier =Modifier
                    .padding(top = 20.dp, start = 20.dp)
                    .clickable { navController.popBackStack() }
            )
            ForgetPasswordPageHeader(
                modifier = Modifier,
                headerText = "Forgot Password\n",
                textP1 = "Select which contact detail we use to \n",
                colorP1 = Color(0xffA6A6A6),
                textP2 = "reset your password",
                colorP2 = Color(0xffA6A6A6)
            )
        }
      //  ChoseOption()
        SelectPasswordResetOption(
            modifier = Modifier,
            navController = navController
        )
        ForgetPasswordContinue(
            navController = navController,
            authViewModel = AuthViewModel()
        )
    }
}


@Composable
fun SelectPasswordResetOption(modifier: Modifier = Modifier,navController: NavHostController) {
    var selectedOption by remember { mutableStateOf(0) }
    Row (horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.padding(start = 20.dp, top = 220.dp)){

        Box(

            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .height(158.dp)
                .width(151.dp)
                .padding(start = 0.dp)
                .background(color = Color(0xffFAFAFA))
                .border(
                    width = 2.dp,
                    color = if (selectedOption == 1) Color(0xff54408C) else Color.Transparent,
                    shape = RoundedCornerShape(16.dp)
                )
                .clickable {
                    selectedOption = 1;
navController.navigate(ForgetPasswordEmailPage)
                }

        ) {

            Column {
                Image(
                    painter = painterResource(R.drawable.email),
                    contentDescription = "Email",
                    modifier = Modifier
                        .padding(start = 20.dp, top = 10.dp)
                )

                Text(
                    text = "Email",
                    fontSize = 14.sp,
                    fontFamily = robotofontfamily,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xff121212),
                    modifier = Modifier
                        .padding(top = 6.dp, start = 20.dp)
                )


                Text(
                    text = "Send to your email",
                    fontSize = 14.sp,
                    fontFamily = robotofontfamily,
                    fontWeight = FontWeight.Normal,
                    color = Color(0xffA6A6A6),
                    modifier = Modifier
                        .padding(top = 4.dp, start = 20.dp)
                )
            }
        }


        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .height(158.dp)
                .width(151.dp)
                .padding(start = 0.dp)
                .background(color = Color(0xffFAFAFA))
                .border(
                    width = 2.dp,
                    color = if (selectedOption == 2) Color(0xff54408C) else Color.Transparent,
                    shape = RoundedCornerShape(16.dp)
                )
                .clickable { selectedOption = 2;
                    navController.navigate(ForgetPasswordPNPage)
                }
        ) {
            Column {
                Image(
                    painter = painterResource(R.drawable.phone),
                    contentDescription = "Email",
                    modifier = Modifier
                        .padding(start = 20.dp, top = 10.dp)
                )

                Text(
                    text = "Phone Number",
                    fontSize = 14.sp,
                    fontFamily = robotofontfamily,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xff121212),
                    modifier = Modifier
                        .padding(top = 6.dp, start = 20.dp)
                )


                Text(
                    text = "Send to your phone",
                    fontSize = 14.sp,
                    fontFamily = robotofontfamily,
                    fontWeight = FontWeight.Normal,
                    color = Color(0xffA6A6A6),
                    modifier = Modifier
                        .padding(top = 4.dp, start = 20.dp)
                )
            }
        }
    }
}

@Composable
fun ForgetPasswordContinue(navController: NavHostController, authViewModel: AuthViewModel) {
    Column {
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF54408C)
            ),
            shape = RoundedCornerShape(40.dp),
            onClick = {},
            modifier = Modifier
                .padding(start = 15.dp, end = 15.dp, top = 400.dp)
                .height(55.dp)

        ) {
            Text(
                text = "Continue",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .fillMaxWidth(),
                //   .padding(start = 60.dp),
                textAlign = TextAlign.Center

            )
        }
        Text(
            text = "Forword",
            color = Color(0xFF54408C),
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .fillMaxWidth()
                .clickable { navController.navigate(ProfilePage) },

            textAlign = TextAlign.Center,
            )
    }

}

@Preview
@Composable
fun ForgetPasswordPreview() {
    BazarApp_1Theme {
        ForgetPasswordScreen(
            modifier = Modifier,
            navController = rememberNavController(),
            authViewModel = AuthViewModel()
        )
    }
}
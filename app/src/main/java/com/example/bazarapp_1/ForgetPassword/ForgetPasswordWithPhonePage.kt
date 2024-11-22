package com.example.bazarapp_1.ForgetPassword

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.bazarapp_1.AuthViewModel
import com.example.bazarapp_1.R
import com.example.bazarapp_1.common.ForgetPasswordPageHeader
import com.example.bazarapp_1.ui.theme.BazarApp_1Theme
import com.example.bazarapp_1.ui.theme.robotofontfamily

@Composable
fun ForgetPasswordWithPhoneScreen(modifier: Modifier = Modifier, navController: NavHostController, authViewModel: AuthViewModel) {
    Box (
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ){
        Column(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(R.drawable.arrow_left_outline),
                contentDescription = "backward",
                modifier = Modifier
                    .padding(start = 20.dp, top = 20.dp)
            )
            ForgetPasswordPageHeader(
                modifier = Modifier,
                headerText = "Reset Password\n",
                textP1 = "Please enter your phone number,we will send\n",
                colorP1 = Color(0xffA6A6A6),
                textP2 = "a verification code to your phone number",
                colorP2 = Color(0xffA6A6A6)
            )

        }
        ForgetPasswordPnTextField()
    }
}

@Composable
fun ForgetPasswordPnTextField(modifier: Modifier = Modifier) {
    var PhoneNumber by remember { mutableStateOf("") }
    Column (modifier = Modifier.padding(top = 200.dp)){
        Text(
            text = "Phone Number",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = robotofontfamily,
            modifier = Modifier
                .padding(start = 20.dp)
        )
        OutlinedTextField(
            value = PhoneNumber,
            onValueChange = { PhoneNumber = it },
            placeholder = {
                Text(
                    text = " Your Phone Number",
                    color = Color(0xffB8B8B8)
                )
            },
            leadingIcon = { Icon(painter = painterResource(R.drawable.phone_outline), contentDescription = null,
                tint = Color(0xff54408C)
            )
            },
            modifier = Modifier

                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, top = 10.dp),


            shape = RoundedCornerShape(10.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = Color(0xffF5F5F5),
                focusedContainerColor = Color(0xffF5F5F5),
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true,
            textStyle = TextStyle(
                color = Color.Black
            )

        )
ForgetPasswordPnSendButton()

    }
}


@Composable
fun ForgetPasswordPnSendButton(modifier: Modifier = Modifier) {
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF54408C)
        ),
        shape = RoundedCornerShape(40.dp),
        onClick = {},
        modifier = Modifier
            .padding(start = 15.dp, end = 15.dp, top = 40.dp)
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
}

@Preview
@Composable
fun ForgetPasswordPhonePrev () {
    BazarApp_1Theme {
        ForgetPasswordWithPhoneScreen(
            modifier = Modifier,
            navController = rememberNavController(),
            authViewModel = AuthViewModel()
        )
    }

}
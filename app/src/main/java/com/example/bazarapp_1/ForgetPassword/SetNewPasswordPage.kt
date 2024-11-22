package com.example.bazarapp_1.ForgetPassword

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bazarapp_1.R
import com.example.bazarapp_1.common.ForgetPasswordPageHeader
import com.example.bazarapp_1.ui.theme.BazarApp_1Theme
import com.example.bazarapp_1.ui.theme.robotofontfamily

@Composable
fun SetNewPasswordScreen(modifier: Modifier = Modifier) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)){
        Column {
            Image(
                painter = painterResource(R.drawable.arrow_left_outline),
                contentDescription = "backword",
                modifier =Modifier
                    .padding(top = 20.dp, start = 20.dp)
            )

            ForgetPasswordPageHeader(
                modifier = Modifier,
                headerText = "New Password\n",
                textP1 = "Create your new password, so you can login\n",
                colorP1 = Color(0xffA6A6A6),
                textP2 = "to your account",
                colorP2 = Color(0xffA6A6A6)
            )
        }
        ConfirmationPassword()
        SendButtonNewPassword()
    }
}

@Composable
fun ConfirmationPassword(modifier: Modifier = Modifier) {
    var passwordInput by remember { mutableStateOf("") }
    var confirmPasswordInput by remember { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }
    var confirmPasswordVisibility by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, top = 170.dp)
    ) {
        // Password Field
        Text(
            text = "Password",
            color = Color.Black,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = robotofontfamily
        )

        OutlinedTextField(
            value = passwordInput,
            onValueChange = { passwordInput = it },
            placeholder = { Text(text = "Enter Password") },
            trailingIcon = {
                IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                    Icon(
                        painter = painterResource(if (passwordVisibility) R.drawable.visibility_118485 else R.drawable._3498),
                        contentDescription = "Visibility Icon",
                        modifier = Modifier.size(20.dp)

                    )
                }
            },
            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
            shape = RoundedCornerShape(16.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = Color(0xffF5F5F5),
                focusedContainerColor = Color(0xffF5F5F5),
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent
            ),
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            textStyle = TextStyle(color = Color.Black)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Confirm Password Field
        Text(
            text = "Confirm Password",
            color = Color.Black,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = robotofontfamily

        )

        OutlinedTextField(
            value = confirmPasswordInput,
            onValueChange = { confirmPasswordInput = it },
            placeholder = { Text(text = "Confirm Password") },
            trailingIcon = {
                IconButton(onClick = { confirmPasswordVisibility = !confirmPasswordVisibility }) {
                    Icon(
                        painter = painterResource(if (confirmPasswordVisibility) R.drawable.visibility_118485 else R.drawable._3498),
                        contentDescription = "Visibility Icon",
                        modifier = Modifier.size(20.dp)
                    )
                }
            },
            visualTransformation = if (confirmPasswordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
            shape = RoundedCornerShape(16.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = Color(0xffF5F5F5),
                focusedContainerColor = Color(0xffF5F5F5),
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent
            ),
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            textStyle = TextStyle(color = Color.Black)
        )

    }
}

@Composable
fun SendButtonNewPassword(modifier: Modifier = Modifier) {
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
            text = "Send",
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
 fun  SetPassPrew() {
     BazarApp_1Theme {
         SetNewPasswordScreen()
     }

}
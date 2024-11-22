package com.example.bazarapp_1.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bazarapp_1.R
import com.example.bazarapp_1.common.VerificationPageHeader
import com.example.bazarapp_1.ui.theme.robotofontfamily

@Composable
fun SignUpVerificationEmailScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Column {
            Image(
                painter = painterResource(R.drawable.arrow_left_outline),
                contentDescription = "Backword",
                modifier = Modifier
                    .padding(top = 20.dp, start = 20.dp)
            )
            VerificationPageHeader(
                modifier = Modifier,
                headerText = "Verification Email\n",
                textH1 = "Please enter the code we just send to email\n",
                textH2 = "Johndoe@gmail.com",
                colorH1 = Color(0xffA6A6A6),
                colorH2 = Color(0xff121212)
            )

        }
        TextFieldBarEmail(
            modifier = modifier.padding(top = 70.dp),
            codeLength = 4,
            onComplete = { code ->

                println("Entered Code: $code")
            }
        )
        ResendCodeEmailVeri()
        ContinueButtonVerificationEmail()
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldBarEmail(
    modifier: Modifier = Modifier,
    codeLength: Int = 4,
    onComplete: (String) -> Unit
) {
    var code by remember { mutableStateOf(List(codeLength) { "" }) }

    val focusRequesters = List(codeLength) { FocusRequester() }
    val focusManager = LocalFocusManager.current

    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.padding(start = 60.dp, end = 16.dp, top = 150.dp)
    ) {
        code.forEachIndexed { index, value ->
            TextField(
                value = value,
                onValueChange = { input ->
                    if (input.length <= 1) {
                        code = code.toMutableList().apply { this[index] = input }

                        if (input.isNotEmpty()) {
                            if (index < codeLength - 1) {
                                focusRequesters[index + 1].requestFocus()
                            } else {
                                focusManager.clearFocus()
                                onComplete(code.joinToString(""))
                            }
                        }
                    }
                },
                shape = RoundedCornerShape(8.dp),
                textStyle = TextStyle(
                    color = Color.Black
                ),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color(0xffF5F5F5),
                    focusedIndicatorColor = Color(0xffF5F5F5),
                    unfocusedIndicatorColor = Color(0xffF5F5F5)
                ),
                modifier = Modifier
                    .size(52.dp)
                    .focusRequester(focusRequesters[index]),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
        }
    }
}


@Composable
fun ResendCodeEmailVeri(modifier: Modifier = Modifier) {
    val annotatedString = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = Color(0xffA6A6A6),
                fontSize = 14.sp,
                fontFamily = robotofontfamily,
                fontWeight = FontWeight.Medium,
            )
        ) {
            append("If you didn't receive a code?")
        }
        withStyle(
            style = SpanStyle(
                color = Color(0xff54408C),
                fontSize = 14.sp,
                fontFamily = robotofontfamily,
                fontWeight = FontWeight.Medium,
            )
        ) {
            append("Resend")
        }
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = annotatedString,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .align(Alignment.Center)
                .padding(bottom = 130.dp,
                    start = 20.dp
               )

        )
    }
}

@Composable
fun ContinueButtonVerificationEmail(modifier: Modifier = Modifier) {
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
}
@Preview
@Composable
private fun SignupVariPrew() {
    SignUpVerificationEmailScreen()
}
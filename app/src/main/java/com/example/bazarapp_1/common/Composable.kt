package com.example.bazarapp_1.common


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bazarapp_1.ui.theme.robotofontfamily

@Composable
fun OnBoardButton(modifier: Modifier = Modifier, textButton: String, textSignIn: String) {
    Column(modifier = Modifier.padding(top = 80.dp)) {
        Button(
            onClick = {},
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
                text = textButton,
                fontSize = 16.sp,
                fontFamily = robotofontfamily
            )
        }

        Text(
            text = textSignIn,
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

@Composable
fun HeaderTextSignPages1(modifier: Modifier = Modifier, text1: String, text2: String) {
    Column {
        Text(
            text = text1,
            color = Color(0xff000000),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 20.dp, start = 20.dp)
        )

        Text(
            text = text2,
            color = Color(0xffA6A6A6),
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = robotofontfamily,
            modifier = Modifier
                .padding(top = 5.dp, start = 20.dp)
        )
    }
}

@Composable
fun Annotated(modifier: Modifier) {
    val annotatedString = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = Color(0xffA6A6A6),
                fontSize = 14.sp,
                fontFamily = robotofontfamily,
                fontWeight = FontWeight.Medium,
            )
        ) {
            append("By clicking Register, you agree to our\n")
        }
        withStyle(
            style = SpanStyle(
                color = Color(0xff54408C),
                fontSize = 14.sp,
                fontFamily = robotofontfamily,
                fontWeight = FontWeight.Medium,
            )
        ) {
            append("Terms and Data Policy")
        }
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = annotatedString,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(
                    bottom = 10.dp,
                    top = 35.dp
                )

        )
    }
}


// 4 append property
@Composable
fun AllPageHeaderDetail(
    modifier: Modifier, headerText: String,
    textP1: String,
    colorP1: Color,
    textP2: String,
    colorP2: Color,
    textP3:String,
    colorP3: Color
) {
    val annotatedString = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = Color(0xff121212),
                fontSize = 24.sp,


                fontFamily = robotofontfamily,
                fontWeight = FontWeight.Bold,

                )
        ) {
            append(headerText)
        }
        withStyle(
            style = SpanStyle(
                color = colorP1,
                fontSize = 16.sp,
                fontFamily = robotofontfamily,
                fontWeight = FontWeight.Normal,
            )
        ) {
            append(textP1)
        }
        withStyle(
            style = SpanStyle(
                color = colorP2,
                fontSize = 16.sp,
                fontFamily = robotofontfamily,
                fontWeight = FontWeight.Medium,
            )
        ) {
            append(textP2)
        }
        withStyle(
            style = SpanStyle(
                color = colorP3,
                fontSize = 16.sp,
                fontFamily = robotofontfamily,
                fontWeight = FontWeight.Medium,
            )
        ) {
            append(textP3)
        }
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = annotatedString,
            textAlign = TextAlign.Center,
            lineHeight = 25.sp,
            modifier = Modifier
                //    .align(Alignment.Center)
                .padding(top = 35.dp, start = 20.dp)

        )
    }
}



@Composable
fun ForgetPasswordPageHeader(
    modifier: Modifier, headerText: String,
    textP1: String,
    colorP1: Color,
    textP2: String,
    colorP2: Color
) {
    val annotatedString = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = Color(0xff121212),
                fontSize = 24.sp,


                fontFamily = robotofontfamily,
                fontWeight = FontWeight.Bold,

                )
        ) {
            append(headerText)
        }
        withStyle(
            style = SpanStyle(
                color = colorP1,
                fontSize = 16.sp,
                fontFamily = robotofontfamily,
                fontWeight = FontWeight.Normal,
            )
        ) {
            append(textP1)
        }
        withStyle(
            style = SpanStyle(
                color = colorP2,
                fontSize = 16.sp,
                fontFamily = robotofontfamily,
                fontWeight = FontWeight.Normal,
            )
        ) {
            append(textP2)
        }
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = annotatedString,
          //  textAlign = TextAlign.Center,
            lineHeight = 25.sp,
            modifier = Modifier
                //    .align(Alignment.Center)
                .padding(top = 20.dp, start = 25.dp)

        )
    }
}

@Composable
fun VerificationPageHeader(
    modifier: Modifier, headerText: String,
    textH1: String,
    colorH1: Color,
    textH2: String,
    colorH2: Color
) {
    val annotatedString = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = Color(0xff121212),
                fontSize = 24.sp,


                fontFamily = robotofontfamily,
                fontWeight = FontWeight.Bold,

                )
        ) {
            append(headerText)
        }
        withStyle(
            style = SpanStyle(
                color = colorH1,
                fontSize = 16.sp,
                fontFamily = robotofontfamily,
                fontWeight = FontWeight.Normal,
            )
        ) {
            append(textH1)
        }
        withStyle(
            style = SpanStyle(
                color = colorH2,
                fontSize = 16.sp,
                fontFamily = robotofontfamily,
                fontWeight = FontWeight.Medium,
            )
        ) {
            append(textH2)
        }
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = annotatedString,
            textAlign = TextAlign.Center,
            lineHeight = 25.sp,
            modifier = Modifier
                //    .align(Alignment.Center)
                .padding(top = 35.dp, start = 20.dp)

        )
    }
}

data class Book(val title: String, val price: String, val imageRes: Int, val category: String)
@Composable
fun CategoryBodyList(ImageBook: Int, Text1: String, Text2: String, modifier: Modifier,) {
    Column(modifier = Modifier) {
        Image(
            painter = painterResource(ImageBook),
            contentDescription = "Book The Code",
            modifier = Modifier
                .size(150.dp)
                /*.height(158.dp)
                .width(187.dp)*/
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = Text1,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Black,
            modifier = Modifier
        )
        Text(
            text = Text2,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xff54408C),
            modifier = Modifier
        )
    }
}
// "The Da vinci Code"
//"$19.99"
package com.example.bazarapp_1.Profile

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
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
import com.example.bazarapp_1.R
import com.example.bazarapp_1.ui.theme.BazarApp_1Theme
import com.example.bazarapp_1.ui.theme.robotofontfamily

@Composable
fun HelpCenterScreen(modifier: Modifier = Modifier, navController: NavHostController, authViewModel: AuthViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
TopBox(
    navController = navController,
    authViewModel = AuthViewModel()
)
        HelpOption()
    }
}

@Composable
fun TopBox(navController: NavHostController, authViewModel: AuthViewModel) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(230.dp)
            .background(color = Color(0xff54408C))
    ) {
        Column (modifier = Modifier){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp, top = 40.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.arrow_left_outline),
                    contentDescription = "Back",
                    colorFilter = ColorFilter.tint(Color.White),
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .clickable { navController.popBackStack()}
                )
                Text(
                    text = "Order History",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium,
                    fontFamily = robotofontfamily,
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 10.dp)
                )
            }
            //Row end column start

            val annotatedString = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Color.White,
                        fontSize = 24.sp,
                        fontFamily = robotofontfamily,
                        fontWeight = FontWeight.SemiBold,

                        )
                ) {
                    append("Help Center\n")
                }
                // new text
                withStyle(
                    style = SpanStyle(
                        color = Color(0xffCABCEF),
                        fontSize = 16.sp,
                        fontFamily = robotofontfamily,
                        fontWeight = FontWeight.Normal,
                    )
                ) {
                    append("Tell us how can we help you \uD83D\uDC4B \n")
                }
                withStyle(
                    style = SpanStyle(
                        color = Color(0xffCABCEF),
                        fontSize = 15.sp,
                        fontFamily = robotofontfamily,
                        fontWeight = FontWeight.Normal,
                    )
                ) {
                    append("Chapter are standing for services & support!")
                }
            }

            Text(
                text = annotatedString,
                  textAlign = TextAlign.Center,
                lineHeight = 26.sp,
                modifier = Modifier
                    //    .align(Alignment.Center)
                    .padding(top = 30.dp, start = 25.dp, )

            )
        }

    }
}

@Composable
fun HelpOption(modifier: Modifier = Modifier) {
    var selectedOption by remember { mutableStateOf(0) }
    Row (horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.padding(start = 20.dp, top = 40.dp)){

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
                .clickable { selectedOption = 1 }


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
                .clickable { selectedOption = 2 }
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


@Preview
@Composable
fun HelpPreview() {
    BazarApp_1Theme {
        HelpCenterScreen(
            modifier = Modifier,
            navController = rememberNavController(),
            authViewModel = AuthViewModel()
        )
    }
}
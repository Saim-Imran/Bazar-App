package com.example.bazarapp_1.Notification

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
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
import com.example.bazarapp_1.R
import com.example.bazarapp_1.ui.theme.BazarApp_1Theme
import com.example.bazarapp_1.ui.theme.robotofontfamily

@Composable
fun NewsPromoScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        NewsTopBar(
            navController = navController
        )
        NewsBody()
        PromoBody()
    }
}

@Composable
fun NewsTopBar(navController: NavHostController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 20.dp, end = 20.dp,
                top = 40.dp
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(R.drawable.arrow_left_outline),
            contentDescription = "Back",
            modifier = Modifier
                .padding(end = 8.dp)
                .clickable {navController.popBackStack() }
        )
        Text(
            text = "Notification",
            color = Color.Black,
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = robotofontfamily,
            modifier = Modifier
                .weight(1f)
                .padding(end = 10.dp)
        )
    }
}

@Composable
fun NewsBody(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .padding(start = 20.dp, end = 20.dp)
    ) {
        Text(
            text = "October 2021",
            color = Color.Black,
            fontSize = 16.sp,
            fontFamily = robotofontfamily,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 20.dp)
        )
//column
        Column {
//Row
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(/*start = 15.dp, end = 15.dp,*/ top = 20.dp)
            ) {
                Text(
                    text = "Promotion",
                    color = Color(0xff54408C),
                    fontSize = 16.sp,
                    fontFamily = robotofontfamily,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                )
                Spacer(modifier = Modifier.width(150.dp))
                Text(
                    text = "Oct 21 * 08.00",
                    color = Color(0xffA6A6A6),
                    fontSize = 12.sp,
                    textAlign = TextAlign.End,
                    fontFamily = robotofontfamily,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier
                )
            }
            // text append

            val annotatedString = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Color(0xff121212),
                        fontSize = 14.sp,
                        fontFamily = robotofontfamily,
                        fontWeight = FontWeight.Normal,

                        )
                ) {
                    append("Today")
                }
                withStyle(
                    style = SpanStyle(
                        color = Color.Black,
                        fontSize = 14.sp,
                        fontFamily = robotofontfamily,
                        fontWeight = FontWeight.Bold,
                    )
                ) {
                    append(" 50% discount")
                }
                withStyle(
                    style = SpanStyle(
                        color = Color.Black,
                        fontSize = 14.sp,
                        fontFamily = robotofontfamily,
                        fontWeight = FontWeight.Normal,
                    )
                ) {
                    append(" on all Books in Novel category with online orders worldwide.")
                }
            }


            Text(
                text = annotatedString,
                //  textAlign = TextAlign.Center,
                lineHeight = 25.sp,
                modifier = Modifier
                    //    .align(Alignment.Center)
                    .padding(top = 10.dp)

            )
            HorizontalDivider(
                thickness = 1.dp,
                color = Color(0xffE5E4E2),
                modifier = Modifier
                    .padding(top = 15.dp, bottom = 8.dp)

            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(/*start = 15.dp, end = 15.dp,*/ top = 20.dp)
            ) {
                Text(
                    text = "Promotion",
                    color = Color(0xff54408C),
                    fontSize = 16.sp,
                    fontFamily = robotofontfamily,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                )
                Spacer(modifier = Modifier.width(150.dp))
                Text(
                    text = "Oct 08 * 20.30",
                    color = Color(0xffA6A6A6),
                    fontSize = 12.sp,
                    textAlign = TextAlign.End,
                    fontFamily = robotofontfamily,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier
                )
            }
            // text append

            val annotatedString1 = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Color(0xff121212),
                        fontSize = 14.sp,
                        fontFamily = robotofontfamily,
                        fontWeight = FontWeight.Normal,

                        )
                ) {
                    append("")
                }
                withStyle(
                    style = SpanStyle(
                        color = Color.Black,
                        fontSize = 14.sp,
                        fontFamily = robotofontfamily,
                        fontWeight = FontWeight.Bold,
                    )
                ) {
                    append("Buy 2 get 1 free ")
                }
                withStyle(
                    style = SpanStyle(
                        color = Color.Black,
                        fontSize = 14.sp,
                        fontFamily = robotofontfamily,
                        fontWeight = FontWeight.Normal,
                    )
                ) {
                    append("for since books from 08 -10 October 2021.")
                }
            }


            Text(
                text = annotatedString1,
                //  textAlign = TextAlign.Center,
                lineHeight = 25.sp,
                modifier = Modifier
                    //    .align(Alignment.Center)
                    .padding(top = 10.dp)

            )
        }


    }
}

@Composable
fun PromoBody(modifier: Modifier = Modifier) {
    Column(modifier = Modifier
        .padding(start = 20.dp, end = 20.dp)) {
        Text(
            text = "September 2021",
            color = Color.Black,
            fontSize = 16.sp,
            fontFamily = robotofontfamily,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 20.dp)
        )
//column
        Column {
//Row
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(/*start = 15.dp, end = 15.dp,*/ top = 20.dp)
            ) {
                Text(
                    text = "Information",
                    color = Color(0xff3784FB),
                    fontSize = 16.sp,
                    fontFamily = robotofontfamily,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                )
                Spacer(modifier = Modifier.width(140.dp))
                Text(
                    text = "Sep 16 * 11.00",
                    color = Color(0xffA6A6A6),
                    fontSize = 12.sp,
                    textAlign = TextAlign.End,
                    fontFamily = robotofontfamily,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier
                )
            }   //row end
Text(
    text = "There is a new book now are available",
    color = Color.Black,
    fontSize = 14.sp,
    fontFamily = robotofontfamily,
    fontWeight = FontWeight.Normal,
)
        }
    }
}

@Preview
@Composable
fun NewsPreview() {
    BazarApp_1Theme {
        NewsPromoScreen(
            navController = rememberNavController()
        )
    }
}
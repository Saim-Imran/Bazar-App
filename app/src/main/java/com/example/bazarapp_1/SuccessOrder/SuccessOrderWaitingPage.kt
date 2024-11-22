package com.example.bazarapp_1.SuccessOrder

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bazarapp_1.ui.theme.BazarApp_1Theme
import com.example.bazarapp_1.ui.theme.robotofontfamily

@Composable
fun SuccessOrderWaitingScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        TopBox()
        CancelOrderText()
        OrderDetail()
        SuccessButton()
    }

}

@Composable
fun TopBox(modifier: Modifier = Modifier) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(170.dp)
            .padding(start = 30.dp, end = 30.dp, top = 25.dp)
            .clip(RoundedCornerShape(8.dp)) // Clip the Box
            .background(color = Color(0xFFF6F6F6))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Thank you\uD83D\uDC4B",
                color = Color(0xff121212),
                fontSize = 16.sp,
                fontFamily = robotofontfamily,
                fontWeight = FontWeight.Normal,
                modifier = Modifier
            )

            Text(
                text = "Lorem ipsum dolor sit",
                color = Color(0xff54408C),
                fontSize = 24.sp,
                fontFamily = robotofontfamily,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Text(
                text = "Order #2930541",
                color = Color(0xff121212),
                fontSize = 14.sp,
                fontFamily = robotofontfamily,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(top = 0.dp)
            )

        }
    }
}

@Composable
fun CancelOrderText(modifier: Modifier = Modifier) {
    val annotatedString = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = Color(0xff121212),
                fontSize = 14.sp,
                fontFamily = robotofontfamily,
                fontWeight = FontWeight.SemiBold,

                )
        ) {
            append("Do you want to cancel your order?")
        }
        withStyle(
            style = SpanStyle(
                color = Color(0xff54408C),
                fontSize = 14.sp,
                fontFamily = robotofontfamily,
                fontWeight = FontWeight.Bold,
            )
        ) {
            append("Cancel")
        }
    }
    Text(
        text = annotatedString,
        textAlign = TextAlign.Center,
        lineHeight = 25.sp,
        modifier = Modifier
            .padding(top = 20.dp, start = 50.dp, end = 15.dp)

    )
}

@Composable
fun OrderDetail(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .padding(start = 20.dp, top = 20.dp, end = 20.dp, bottom = 10.dp)
    ) {
        Text(
            text = "Order Detail",
            color = Color(0xff121212),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = robotofontfamily,
            modifier = Modifier
        )
        OrderDetailBody()
    }
}


@Composable
fun OrderDetailBody(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .padding(top = 10.dp)
            .fillMaxWidth()
            .height(380.dp)
            .border(
                width = 2.dp,
                brush = SolidColor(Color(0xffF6F6F6)),
                shape = RoundedCornerShape(8.dp)
            )
            .background(color = Color.White)
    ) {
        Column(modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 15.dp)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "1x",
                    color = Color(0xff121212),
                    fontSize = 14.sp,
                    fontFamily = robotofontfamily,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier
                        .weight(0.2f)
                        .padding(start = 20.dp)
                )
                Text(
                    text = "Carrie Fisher",
                    color = Color(0xff121212),
                    fontSize = 14.sp,
                    fontFamily = robotofontfamily,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.weight(0.5f)

                )
                Text(
                    text = "$19.99",
                    color = Color(0xff121212),
                    fontSize = 14.sp,
                    fontFamily = robotofontfamily,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.End,
                    modifier = Modifier
                        .weight(0.3f)
                        .padding(end = 20.dp)
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "1x",
                    color = Color(0xff121212),
                    fontSize = 14.sp,
                    fontFamily = robotofontfamily,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier
                        .weight(0.2f)
                        .padding(start = 20.dp)
                )
                Text(
                    text = "The Da Vinci Code",
                    color = Color(0xff121212),
                    fontSize = 14.sp,
                    fontFamily = robotofontfamily,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.weight(0.5f)
                )
                Text(
                    text = "$39.99",
                    color = Color(0xff121212),
                    fontSize = 14.sp,
                    fontFamily = robotofontfamily,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.End,
                    modifier = Modifier
                        .weight(0.3f)
                        .padding(end = 20.dp)
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "1x",
                    color = Color(0xff121212),
                    fontSize = 14.sp,
                    fontFamily = robotofontfamily,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier
                        .weight(0.2f)
                        .padding(start = 20.dp)
                )
                Text(
                    text = "Arcu ipsum feugiat leo odio",
                    color = Color(0xff121212),
                    fontSize = 14.sp,
                    fontFamily = robotofontfamily,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.weight(0.5f)
                )
                Text(
                    text = "$27.12",
                    color = Color(0xff121212),
                    fontSize = 14.sp,
                    fontFamily = robotofontfamily,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.End,
                    modifier = Modifier
                        .weight(0.3f)
                        .padding(end = 20.dp)
                )
            }
            HorizontalDivider(
                color = Color(0xffA6A6A6), modifier = Modifier
                    .fillMaxWidth()
                    .width(2.dp)
                    .padding(top = 15.dp, end = 20.dp, start = 20.dp)
            )
            Row(modifier = Modifier.padding(top = 15.dp)) {
                Spacer(modifier = Modifier.width(20.dp))
                Text(
                    text = "Subtotal",
                    color = Color(0xff121212),
                    fontSize = 14.sp,
                    fontFamily = robotofontfamily,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier
                        .weight(.75f)
                )
                Text(
                    text = "$87.10",
                    color = Color(0xff121212),
                    fontSize = 14.sp,
                    fontFamily = robotofontfamily,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier
                        .weight(.25f)
                        .padding(end = 20.dp)

                )
            }

            HorizontalDivider(
                modifier = Modifier
                    .fillMaxWidth()
                    .width(2.dp)
                    .padding(top = 15.dp, end = 20.dp, start = 20.dp),
                color = Color(0xffA6A6A6)
            )
            Row(modifier = Modifier.padding(top = 15.dp)) {
                Spacer(modifier = Modifier.width(20.dp))
                Text(
                    text = "Shipping",
                    color = Color(0xff121212),
                    fontSize = 14.sp,
                    fontFamily = robotofontfamily,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier
                        .weight(.82f)
                )
                Text(
                    text = "$2",
                    color = Color(0xff121212),
                    fontSize = 14.sp,
                    fontFamily = robotofontfamily,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier
                        .weight(.18f)

                )
            }

            HorizontalDivider(
                color = Color(0xffA6A6A6), modifier = Modifier
                    .fillMaxWidth()
                    .width(2.dp)
                    .padding(top = 15.dp, end = 20.dp, start = 20.dp)
            )
            Row(modifier = Modifier.padding(top = 15.dp)) {
                Spacer(modifier = Modifier.width(20.dp))
                Text(
                    text = "Total Payment",
                    color = Color(0xff121212),
                    fontSize = 14.sp,
                    fontFamily = robotofontfamily,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .weight(.75f)
                )
                Text(
                    text = "$89.10",
                    color = Color(0xff54408C),
                    fontSize = 14.sp,
                    fontFamily = robotofontfamily,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .weight(.25f)
                        .padding(end = 20.dp)

                )
            }
            Row(modifier = Modifier.padding(top = 4.dp)) {
                Spacer(modifier = Modifier.width(20.dp))
                Text(
                    text = "Delivery in",
                    color = Color(0xff121212),
                    fontSize = 14.sp,
                    fontFamily = robotofontfamily,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier
                        .weight(.62f)
                )
                Text(
                    text = "10 - 15 mins",
                    color = Color(0xff121212),
                    fontSize = 14.sp,
                    fontFamily = robotofontfamily,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier
                        .weight(.38f)
                        .padding(end = 20.dp)

                )
            }
            Row(modifier = Modifier.padding(top = 4.dp)) {
                Spacer(modifier = Modifier.width(20.dp))
                Text(
                    text = "Time",
                    color = Color(0xff121212),
                    fontSize = 14.sp,
                    fontFamily = robotofontfamily,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier
                        .weight(.60f)
                )
                Text(
                    text = "15.24 - 15.39",
                    color = Color(0xff121212),
                    fontSize = 14.sp,
                    fontFamily = robotofontfamily,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier
                        .weight(.40f)
                        .padding(end = 20.dp)
                )
            }


        }
    }
}

@Composable
fun SuccessButton(modifier: Modifier = Modifier) {
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFF6F6F6)
        ),
        shape = RoundedCornerShape(40.dp),
        onClick = {},
        modifier = Modifier
            .padding(start = 15.dp, end = 15.dp, top = 16.dp)
            .height(55.dp)

    ) {
        Text(
            text = "Order Status",
            color = Color(0xff54408C),
            fontSize = 24.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .fillMaxWidth(),
            //   .padding(start = 60.dp),
            textAlign = TextAlign.Center

        )
    }
}


@Preview
@Composable
fun OrderWaitingPrev() {
    BazarApp_1Theme {
        SuccessOrderWaitingScreen()
    }
}
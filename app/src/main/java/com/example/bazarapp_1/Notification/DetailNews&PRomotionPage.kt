package com.example.bazarapp_1.Notification

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.bazarapp_1.R
import com.example.bazarapp_1.ui.theme.BazarApp_1Theme
import com.example.bazarapp_1.ui.theme.robotofontfamily

@Composable
fun DetailNewsPromoScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .verticalScroll(rememberScrollState())
    ) {
        DetailPromoTopBar(
            navController = navController
        )
        DetailPromoBox()
DetailPromoBodyDetail()

    }
}

@Composable
fun DetailPromoTopBar(navController: NavHostController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 20.dp, end = 20.dp,
                top = 40.dp, bottom = 20.dp
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(R.drawable.arrow_left_outline),
            contentDescription = "Back",
            modifier = Modifier
                .padding(end = 8.dp)
                .clickable { navController.popBackStack()}
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
fun DetailPromoBox(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 15.dp, end = 15.dp,
            //    top = 15.dp
            )
            .height(220.dp)
            .background(color = Color(0xffE5E4E2),
                shape = RoundedCornerShape(16.dp)
            )

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            //  .background(color = Color(0xFFF2F2F2)),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.padding(24.dp)) {
                Text(
                    text = "50% Discount\nOn All Desert",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xff54408C),
                    lineHeight = 25.sp,
                    fontFamily = robotofontfamily,

                    )
                Text(
                    text = "Grab it now!",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xff54408C),
                    lineHeight = 25.sp,
                    fontFamily = robotofontfamily,
                )
                Spacer(modifier = Modifier.height(20.dp))
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF54408C))
                ) {
                    Text(
                        text = "Order Now",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                    color = Color.White
                    )
                }
            }
            Image(
                painter = painterResource(id = R.drawable.image),
                contentDescription = "Little Prince",
                modifier = Modifier
                    .fillMaxHeight()
//                    .padding(end = 10.dp)
                 //   .size(220.dp)
            //  .height(200.dp)
            )

        }
    }
}


@Composable
fun DetailPromoBodyDetail(modifier: Modifier = Modifier) {
Column (modifier = Modifier
    .padding(top = 20.dp, start = 15.dp, end = 20.dp)){
    Text(
        text = "Today 50% discount on all products in Chapter with online order",
        fontSize = 18.sp,
        color = Color(0xff121212),
        fontWeight = FontWeight.Bold,
        fontFamily = robotofontfamily,
        modifier =Modifier
    )
    Text(
        text = "Excuse me… Who could ever resist a discount feast? \uD83D\uDC40",
        fontSize = 14.sp,
        color = Color(0xff7A7A7A),
        fontWeight = FontWeight.Normal,
        fontFamily = robotofontfamily,
        modifier =Modifier
            .padding(top = 10.dp, bottom = 20.dp)
    )
    Text(
        text = "Hear me out. Today, October 21, 2021, Chapter has a 50% discount for any product. What are you waiting for, let's order now before it runs out.",
        fontSize = 14.sp,
        color = Color(0xff7A7A7A),
        fontWeight = FontWeight.Normal,
        fontFamily = robotofontfamily,
        modifier =Modifier
            .padding(top = 0.dp,bottom = 15.dp)
    )
    Text(
        text = "All of the products are discounted, just order through the Chapter app to enjoy this discount. From the best to the best we have prepared for you, may you always be happy when ordering at Chapter. Please choose the best product you want.",
        fontSize = 14.sp,
        color = Color(0xff7A7A7A),
        fontWeight = FontWeight.Normal,
        fontFamily = robotofontfamily,
        modifier =Modifier
            .padding(top = 0.dp,bottom = 20.dp)
    )
    Text(
        text = "So, what’s your call? Let’s roll, order your comfort food now \uD83D\uDE09",
        fontSize = 14.sp,
        color = Color(0xff7A7A7A),
        fontWeight = FontWeight.Normal,
        fontFamily = robotofontfamily,
        modifier =Modifier
            .padding(top = 0.dp,bottom = 15.dp)
    )
}
}

@Preview
@Composable
fun DetailPrev() {
    BazarApp_1Theme {
        DetailNewsPromoScreen(
            navController = rememberNavController()
        )
    }
}
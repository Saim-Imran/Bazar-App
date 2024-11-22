package com.example.bazarapp_1.SuccessOrder

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bazarapp_1.R
import com.example.bazarapp_1.ui.theme.BazarApp_1Theme
import com.example.bazarapp_1.ui.theme.robotofontfamily

@Composable
fun SuccessOrderReceivingScreen(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,

        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        ReceivedInfo()
        SuccessBox()
        ReceivedButton()
    }
}

@Composable
fun ReceivedInfo(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.padding(top = 90.dp,)) {
        Image(
            painter = painterResource(R.drawable.signupsuccess),
            contentDescription = "null",
            modifier = Modifier
                .padding(start = 25.dp)
        )
        Text(
            text = "You Received The Order!",
            color = Color(0xff121212),
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            fontFamily = robotofontfamily,
            modifier =Modifier
                .padding(start = 10.dp, top = 25.dp)
        )

        Text(
            text = "Order #2930541",
            color = Color(0xffA6A6A6),
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
            fontFamily = robotofontfamily,
            modifier =Modifier
                .padding(start = 80.dp, top = 18.dp)
        )
    }
}

@Composable
fun SuccessBox(modifier: Modifier = Modifier) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, top = 20.dp)

            .height(280.dp)
            .clip(shape = RoundedCornerShape(16.dp))
            .background(color = Color(0xffF5F5F5))

    ) {
        Text(
            text = "Tell us your feedback\uD83D\uDE4C",
            color = Color(0xff54408C),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = robotofontfamily,
            modifier = Modifier
                .padding(top = 40.dp)
        )

        Text(
            text = "      Lorem ipsum dolor sit amet\nconsectetur.Dignissim magna vitae.",
            color = Color(0xff54408C),
            fontSize = 16.sp,
            lineHeight = 24.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = robotofontfamily,
            modifier = Modifier
                .padding(start = 10.dp, top = 6.dp, bottom = 15.dp)
        )

        NewStarRatingBar(
            rating = 4,
            maxStars = 5
        )

        Text(
            text = "Write something for us!",
            color = Color(0xff121212),
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = robotofontfamily,
            modifier = Modifier
                .padding(top = 20.dp)
        )
    }
}


@Composable

fun NewStarRatingBar(
    rating: Int, // Number of selected stars
    maxStars: Int = 5
) {

    Spacer(modifier = Modifier.padding(top = 10.dp))

    // Adjust the size of the stars

    val starSize = 34.dp
    val starSpacing = 6.dp

    Row(

        modifier = Modifier.selectableGroup(),

        verticalAlignment = Alignment.CenterVertically

    ) {
        for (i in 1..maxStars) {

            // Determine which icon to display: filled or outlined

            val icon = if (i <= rating) Icons.Filled.Star else Icons.Outlined.Star
            val iconTintColor = if (i <= rating) Color(0xFFFFC700) else Color(0xffA6A6A6)


            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = iconTintColor,
                modifier = Modifier
                    .size(starSize)
            )

            if (i < maxStars) {
                Spacer(modifier = Modifier.width(starSpacing))
            }
        }

    }
}


@Composable
fun ReceivedButton(modifier: Modifier = Modifier) {
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xff54408C)
        ),
        shape = RoundedCornerShape(40.dp),
        onClick = {},
        modifier = Modifier
            .padding(start = 15.dp, end = 15.dp, top = 16.dp)
            .height(55.dp)

    ) {
        Text(
            text = "Done",
            color = Color.White,
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
fun SuccessPrev() {
    BazarApp_1Theme {
        SuccessOrderReceivingScreen()
    }
}
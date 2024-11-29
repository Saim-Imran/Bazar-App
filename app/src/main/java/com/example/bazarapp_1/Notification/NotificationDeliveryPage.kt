package com.example.bazarapp_1.Notification

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.bazarapp_1.DetailNewsPage
import com.example.bazarapp_1.NewsPromoPage
import com.example.bazarapp_1.R
import com.example.bazarapp_1.ui.theme.BazarApp_1Theme
import com.example.bazarapp_1.ui.theme.robotofontfamily

@Composable
fun NotificationDeliveryScreen(modifier: Modifier = Modifier,navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
        //   .padding(start = 20.dp, end = 20.dp)
    ) {
        NotificationTopBar(
            modifier = Modifier,
            navController = navController
        )
        NotificationBox(
            modifier = Modifier,
            navController = navController
        )
        NotificationBodyItems()
    }
}

@Composable
fun NotificationTopBar(modifier: Modifier = Modifier,navController: NavHostController) {
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
                .clickable { navController.navigate(NewsPromoPage) }
        )
    }
}

@Composable
fun NotificationBox(modifier: Modifier = Modifier,navController: NavHostController) {
    Column(modifier = Modifier.padding(start = 20.dp, top = 20.dp, end = 20.dp)) {
    Text(
        text = "Current",
        color = Color.Black,
        fontSize = 18.sp,
        fontWeight = FontWeight.SemiBold,
        fontFamily = robotofontfamily,
        modifier = Modifier
            .padding(bottom = 15.dp)
            .clickable { navController.navigate(DetailNewsPage) }
    )
//Box
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .size(80.dp)
            .border(
                width = 1.dp,
                color = Color(0xffE5E4E2),
                shape = RoundedCornerShape(8.dp)
            )
            .padding(top = 20.dp)
    ) {

        Row(
            modifier = Modifier
                .padding(start = 0.dp, end = 15.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.codef4),
                contentDescription = "F1",
                modifier = Modifier
                    .size(50.dp)
                    .weight(.2f)
            )
            Column(
                modifier = Modifier

                    .weight(.5f)
            ) {
                Text(
                    text = "Carrie Fisher",
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = robotofontfamily,
                    modifier = Modifier


                )
                Row(modifier = Modifier) {
                    Text(
                        text = "On the way",
                        color = Color(0xff3784FB),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        fontFamily = robotofontfamily,
                        modifier = Modifier

                    )
                    Text(
                        text = " .  1 items",
                        color = Color(0xff7A7A7A),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        fontFamily = robotofontfamily,
                        modifier = Modifier
                            .padding(start = 10.dp)
                    )

                }
            }

        }
    }
}
}

@Composable
fun NotificationBodyItems(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.padding(start = 20.dp, top = 20.dp, end = 20.dp)) {
        Text(
            text = "October 2021",
            color = Color.Black,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = robotofontfamily,
            modifier = Modifier
                .padding(bottom = 20.dp)
        )
//Box
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .size(260.dp)
                .border(
                    width = 1.dp,
                    color = Color(0xffE5E4E2),
                    shape = RoundedCornerShape(8.dp)
                )
                .padding(top = 20.dp)
        ) {
            Column {
                Row(
                    modifier = Modifier
                        .padding(start = 0.dp, end = 15.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.carrierf1),
                        contentDescription = "F1",
                        modifier = Modifier
                            .size(50.dp)
                            .weight(.2f)
                    )
                    Column(
                        modifier = Modifier

                            .weight(.5f)
                    ) {
                        Text(
                            text = "The da vinci Code",
                            color = Color.Black,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold,
                            fontFamily = robotofontfamily,
                            modifier = Modifier


                        )
                        Row(modifier = Modifier) {
                            Text(
                                text = "Delivered",
                                color = Color(0xff18A057),
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium,
                                fontFamily = robotofontfamily,
                                modifier = Modifier

                            )
                            Text(
                                text = " .  1 items",
                                color = Color(0xff7A7A7A),
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium,
                                fontFamily = robotofontfamily,
                                modifier = Modifier
                                    .padding(start = 10.dp)
                            )

                        }
                    }

                }
                HorizontalDivider(
                    thickness = 1.dp,
                    color = Color(0xffE5E4E2),
                    modifier = Modifier
                        .padding(top = 15.dp)

                )

                //2nd Order
                Row(
                    modifier = Modifier
                        .padding(start = 0.dp, end = 15.dp, top = 20.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.waitingf2),
                        contentDescription = "F2",
                        modifier = Modifier
                            .size(50.dp)
                            .weight(.2f)
                    )
                    Column(
                        modifier = Modifier
                            .weight(.5f)
                    ) {
                        Text(
                            text = "Carrie Fisher",
                            color = Color.Black,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold,
                            fontFamily = robotofontfamily,
                            modifier = Modifier


                        )
                        Row(modifier = Modifier) {
                            Text(
                                text = "Delivered",
                                color = Color(0xff18A057),
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium,
                                fontFamily = robotofontfamily,
                                modifier = Modifier

                            )
                            Text(
                                text = " .  5 items",
                                color = Color(0xff7A7A7A),
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium,
                                fontFamily = robotofontfamily,
                                modifier = Modifier
                                    .padding(start = 10.dp)
                            )

                        }
                    }

                }
                HorizontalDivider(
                    thickness = 1.dp,
                    color = Color(0xffE5E4E2),
                    modifier = Modifier
                        .padding(top = 15.dp)

                )
                //3rd Order
                Row(
                    modifier = Modifier
                        .padding(start = 0.dp, end = 15.dp, top = 20.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.womenf3),
                        contentDescription = "F3",
                        modifier = Modifier
                            .size(50.dp)
                            .weight(.2f)
                    )
                    Column(
                        modifier = Modifier
                            .weight(.5f)
                    ) {
                        Text(
                            text = "Carrie Fisher",
                            color = Color.Black,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold,
                            fontFamily = robotofontfamily,
                            modifier = Modifier


                        )
                        Row(modifier = Modifier) {
                            Text(
                                text = "Cancelled",
                                color = Color.Red,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium,
                                fontFamily = robotofontfamily,
                                modifier = Modifier

                            )
                            Text(
                                text = " .  2 items",
                                color = Color(0xff7A7A7A),
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium,
                                fontFamily = robotofontfamily,
                                modifier = Modifier
                                    .padding(start = 10.dp)
                            )

                        }
                    }

                }
            }

        }
        //Box scope end
    }
}


@Preview
@Composable
fun NotificationPreview() {
    BazarApp_1Theme {
        NotificationDeliveryScreen(
            modifier = Modifier,
            navController = rememberNavController()
        )
    }
}
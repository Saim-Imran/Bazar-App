package com.example.bazarapp_1.Cart


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.bazarapp_1.ConfirmOrderDeliveryDatePage
import com.example.bazarapp_1.ConfirmOrderEmptyNotificationPage
import com.example.bazarapp_1.ConfirmOrderLocationPage
import com.example.bazarapp_1.ConfirmOrderPaymentDetailPage
import com.example.bazarapp_1.ConfirmOrderPaymentMethodPage
import com.example.bazarapp_1.R
import com.example.bazarapp_1.ui.theme.BazarApp_1Theme


@Composable
fun ConfirmOrderScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Column (modifier = Modifier.verticalScroll(rememberScrollState())){
            Row(
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.arrow_left_outline),
                    contentDescription = "searchIcon",
                    tint = Color.Black
                )
                Text(
                    text = "Confirm Order",
                    style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Black),
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
                Icon(
                    painter = painterResource(id = R.drawable.notification),
                    contentDescription = "notification",
                    tint = Color.Black,
                    modifier = Modifier.clickable { navController.navigate(ConfirmOrderEmptyNotificationPage) }
                )
            }
            // Address Card
            Column(
                modifier = Modifier.padding(15.dp),
            ) {
                Card(
                    border = BorderStroke(width = 2.dp, color = Color(0xffE8E8E8)),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.Transparent
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(230.dp)
                        .background(color = Color.Transparent)
                ) {
                    Text(
                        text = "Address",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                                    color = Color.Black
                        ),
                        modifier = Modifier.padding(12.dp)
                    )
                    Row(
                        modifier = Modifier
                            .padding(10.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Button(onClick = {}, colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF2F2F2)),modifier = Modifier.size(width = 70.dp, height = 70.dp),) {
                            Image(
                                painter = painterResource(R.drawable.loci),
                                modifier = Modifier.size(width = 40.dp, height = 40.dp),
//                                colorFilter = ColorFilter.tint(Color(0XFF54408C)),
                                contentDescription = null
                            )
                        }
                        Column(modifier = Modifier.padding(start = 10.dp)) {
                            Text(
                                text = "Utama Street No.20",
                                style = TextStyle(
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp,
                                    color = Color.Black
                                )
                            )
                            Text(
                                color = Color(0xffA6A6A6),
                                text = "Dumbo Street No.20, \nDumbo,New York\n 10001, United States"

                            )
                        }
                        Image(
                            painter = painterResource(id = R.drawable.arrow_right),
                            contentDescription = null,
                            modifier = Modifier.padding(top = 10.dp),
                            colorFilter = ColorFilter.tint(Color.Black)
                        )
                    }
                    Button(
                        onClick = {navController.navigate(ConfirmOrderLocationPage)},
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent,
                            contentColor = Color(0XFF54408C)
                        ),
                        modifier = Modifier.padding(horizontal = 70.dp)
                    ) {
                        Text(text = "Change")

                    }
                }
            }
            Column(
                modifier = Modifier.padding(15.dp),
            ) {
                Card(
                    border = BorderStroke(width = 2.dp, color = Color(0xffE8E8E8)),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.Transparent
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(230.dp)
                        .background(color = Color.Transparent)
                ) {
                    Text(
                        text = "Summary",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        ),
                        modifier = Modifier.padding(12.dp)
                    )
                    Column {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 20.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Price",color = Color.Black
                            )
                            Text(
                                text = "$87.10",color = Color.Black
                            )
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 20.dp, vertical = 10.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Shipping",color = Color.Black
                            )
                            Text(
                                text = "$2",color = Color.Black
                            )
                        }
                        HorizontalDivider(thickness = 1.dp)
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 20.dp, vertical = 15.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Total Payment",
                                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 18.sp,color = Color.Black)
                            )
                            Text(
                                text = "$89.10",
                                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 18.sp,color = Color.Black)
                            )
                        }
                        HorizontalDivider(thickness = 1.dp)
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(top = 20.dp, start = 14.dp)
                        ) {
                            Text(
                                text = "See details",
                                color = Color(0XFF54408C),
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp,
                                modifier = Modifier.clickable { navController.navigate(ConfirmOrderPaymentDetailPage) }
                            )
                            Image(
                                painter = painterResource(id = R.drawable.arrow___right_2),
                                contentDescription = null,
                            )
                        }

                    }

                }
            }
            //Date and Time
            Column(
                modifier = Modifier.padding(15.dp),
            ) {
                Card(
                    border = BorderStroke(width = 2.dp, color = Color(0xffE8E8E8)),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.Transparent
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .background(color = Color.Transparent)
                ) {
                    Text(
                        text = "Date and time",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        ),
                        modifier = Modifier.padding(12.dp)
                    )
                    Row(
                        modifier = Modifier
                            .padding(20.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Button(onClick = {}, colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF2F2F2)),modifier = Modifier.size(width = 70.dp, height = 70.dp),) {
                            Image(
                                painter = painterResource(R.drawable.date_time),
                                colorFilter = ColorFilter.tint(Color(0XFF54408C)),
                                contentDescription = null
                            )
                        }

                        Column(modifier = Modifier.padding(start = 10.dp)) {
                            Text(
                                text = "Date & time",
                                style = TextStyle(
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp,
                                    color = Color.Black
                                )
                            )
                            Text(
                                color = Color(0xffA6A6A6),
                                text = "Choose date and time"
                            )
                        }
                        Image(
                            painter = painterResource(id = R.drawable.arrow_right),
                            contentDescription = null,
                            modifier = Modifier.padding(top = 10.dp)
                                .clickable { navController.navigate(ConfirmOrderDeliveryDatePage) }
                        )
                    }

                }
            }
            //Payment
            Column(
                modifier = Modifier.padding(15.dp),
            ) {
                Card(
                    border = BorderStroke(width = 2.dp, color = Color(0xffE8E8E8)),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.Transparent
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .background(color = Color.Transparent)
                ) {
                    Text(
                        text = "Payment",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        ),
                        modifier = Modifier.padding(12.dp)
                    )
                    Row(
                        modifier = Modifier
                            .padding(20.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Button(onClick = {}, colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF2F2F2)),modifier = Modifier.size(width = 70.dp, height = 70.dp),) {
                            Image(
                                painter = painterResource(R.drawable.wallet),
                                colorFilter = ColorFilter.tint(Color(0XFF54408C)),
                                contentDescription = null
                            )
                        }

                        Column(modifier = Modifier.padding(start = 10.dp)) {
                            Text(
                                text = "Payment",
                                style = TextStyle(
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp,color = Color.Black
                                )
                            )
                            Text(
                                color = Color(0xffA6A6A6),
                                text = "Choose your payment",

                            )
                        }
                        Image(
                            painter = painterResource(id = R.drawable.arrow_right),
                            contentDescription = null,
                            modifier = Modifier.padding(top = 10.dp)
                                .clickable { navController.navigate(ConfirmOrderPaymentMethodPage) }
                        )
                    }

                }
            }
            Button(onClick = {},modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)) {
                Text(
                    text = "Order",color = Color.White
                )
            }
        }

    }
}

@Preview
@Composable
 fun ConfirmOrderPreview() {
BazarApp_1Theme {  }
}
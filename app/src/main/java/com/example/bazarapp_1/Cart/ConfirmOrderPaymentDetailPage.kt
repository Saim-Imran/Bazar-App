package com.example.bazarapp_1.Cart


import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.bazarapp_1.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConfirmOrderPaymentDetailScreen(modifier: Modifier = Modifier,navController: NavHostController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        val sheetState = rememberModalBottomSheetState()

        ModalBottomSheet(
            sheetState = sheetState,
            onDismissRequest = {}
        ) {
            PaymentDetails(
                navController = navController
            )
        }
    }
}


@Composable
fun PaymentDetails(navController: NavHostController) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            Row(
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Payment Details",
                    style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
                    modifier = Modifier.align(Alignment.CenterVertically)
                )

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
                    Column(modifier = Modifier.padding(top = 20.dp)) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 20.dp, vertical = 5.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Price"
                            )
                            Text(
                                text = "$87.10"
                            )
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 20.dp, vertical = 5.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Squid Sweet and Sour Salad",
                                style = TextStyle(color = Color(0xFFA6A6A6))

                            )
                            Text(
                                text = "$19.99",
                                style = TextStyle(color = Color(0xFFA6A6A6))

                            )
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 20.dp, vertical = 5.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Japan Hainanese Sashimi",
                                style = TextStyle(color = Color(0xFFA6A6A6))
                            )
                            Text(
                                text = "$39.99",
                                style = TextStyle(color = Color(0xFFA6A6A6))

                            )
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 20.dp, vertical = 5.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Black Pepper Beef Lumpia",
                                style = TextStyle(color = Color(0xFFA6A6A6))

                            )
                            Text(
                                text = "$27.12",
                                style = TextStyle(color = Color(0xFFA6A6A6))

                            )
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 20.dp, vertical = 10.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Shipping"
                            )
                            Text(
                                text = "$2"
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
                                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 18.sp)
                            )
                            Text(
                                text = "$89.10",
                                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 18.sp)
                            )
                        }
//                        HorizontalDivider(thickness = 1.dp)
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(top = 20.dp, start = 14.dp)
                        ) {
                            Text(
                                text = "See details",
                                color = Color(0XFF54408C),
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp
                            )
                            Image(
                                painter = painterResource(id = R.drawable.arrow___right_2),
                                contentDescription = null,
                            )
                        }

                    }

                }
            }

        }

    }
}
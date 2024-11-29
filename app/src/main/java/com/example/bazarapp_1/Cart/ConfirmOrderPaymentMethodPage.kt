package com.example.bazarapp_1.Cart



import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.ui.graphics.ColorFilter
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
fun ConfirmOrderPaymentMethodScreen(navController: NavHostController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        val sheetState = rememberModalBottomSheetState()

        ModalBottomSheet(
            sheetState = sheetState,
            onDismissRequest = {}
        ) {
            YourPayment(
                navController = navController
            )
        }
    }
}



@Composable
fun YourPayment(navController: NavHostController) {
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
                    text = "Your Payments",
                    style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
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
                        .height(90.dp)
                        .background(color = Color.Transparent)
                ) {
                    Row(
                        modifier = Modifier
                            .padding(20.dp)
                            .fillMaxWidth(),
//                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Image(
                            painter = painterResource(R.drawable.knet),
                            contentDescription = null
                        )


                        Column(modifier = Modifier.padding(start = 10.dp)) {
                            Text(
                                text = "KNET",
                                style = TextStyle(
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp
                                ),
                                modifier = Modifier.padding(top = 10.dp)
                            )
                        }
                        Image(
                            painter = painterResource(id = R.drawable.arrow_right),
                            contentDescription = null,
                            modifier = Modifier.padding(top = 10.dp, start = 140.dp),
                            colorFilter = ColorFilter.tint(Color.White)
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
                        .height(90.dp)
                        .background(color = Color.Transparent)
                ) {
                    Row(
                        modifier = Modifier
                            .padding(20.dp)
                            .fillMaxWidth(),
//                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Image(
                            painter = painterResource(R.drawable.card),
                            contentDescription = null,

                        )
                        Column(modifier = Modifier.padding(start = 10.dp)) {
                            Text(
                                text = "Credit Card",
                                style = TextStyle(
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp
                                ),
                                modifier = Modifier.padding(top = 10.dp)
                            )
                        }
                        Image(
                            painter = painterResource(id = R.drawable.arrow_right),
                            contentDescription = null,
                            modifier = Modifier.padding(top = 10.dp, start = 110.dp),
                            colorFilter = ColorFilter.tint(Color.White)
                        )
                    }

                }
            }
        }
    }
}
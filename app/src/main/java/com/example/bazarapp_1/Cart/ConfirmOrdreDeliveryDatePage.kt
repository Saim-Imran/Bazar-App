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
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConfirmOrderDeliveryDateScreen(navController: NavHostController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        val sheetState = rememberModalBottomSheetState()

        ModalBottomSheet(
            sheetState = sheetState,
            onDismissRequest = {}
        ) {
            DeliveryDate(
                modifier = Modifier,
                navController = navController
            )

        }
    }
}



@Composable
fun DeliveryDate(modifier: Modifier = Modifier,navController: NavHostController) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(modifier = Modifier) {
            Row(
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Delivery date",
                    style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }
            //Payment
            Column(
                modifier = Modifier.padding(15.dp),
            ) {
                Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
                    Card(
                        border = BorderStroke(width = 2.dp, color = Color(0xffE8E8E8)),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.Transparent
                        ),
                        modifier = Modifier
                            .width(90.dp)
                            .height(90.dp)
                            .background(color = Color.Transparent)
                    ) {
                        Column (modifier = Modifier.fillMaxSize(),verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                            Text(
                                text = "Today",
                            )
                            Text(
                                text = "12 Jan"
                            )
                        }

                    }
                    Card(
                        border = BorderStroke(width = 2.dp, color = Color(0xffE8E8E8)),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.Transparent
                        ),
                        modifier = Modifier
                            .width(90.dp)
                            .height(90.dp)
                            .background(color = Color.Transparent)
                    ) {
                        Column (modifier = Modifier.fillMaxSize(),verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                            Text(
                                text = "Tomorrow"
                            )
                            Text(
                                text = "12 Jan"
                            )
                        }
                    }
                    Card(
                        border = BorderStroke(width = 2.dp, color = Color(0xffE8E8E8)),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.Transparent
                        ),
                        modifier = Modifier
                            .width(90.dp)
                            .height(90.dp)
                            .background(color = Color.Transparent)
                    ) {
                        Column (modifier = Modifier.fillMaxSize(),verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                            Text(
                                text = "Pick"
                            )
                            Text(
                                text = "a date"
                            )
                        }
                    }
                }
            }
            Row(
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Delivery time",
                    style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }
            Row (modifier = Modifier.fillMaxWidth(),Arrangement.Center){
                Card(
                    border = BorderStroke(width = 2.dp, color = Color(0xffE8E8E8)),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.Transparent
                    ),
                    modifier = Modifier
                        .width(170.dp)
                        .height(100.dp)
                        .background(color = Color.Transparent)
                        .padding(horizontal = 10.dp)
                ) {
                    Column (modifier = Modifier.fillMaxSize(),verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                        Text(
                            text = "Between"
                        )
                        Text(
                            text = "10PM : 11PM"
                        )
                    }
                }
                Card(
                    border = BorderStroke(width = 2.dp, color = Color(0xffE8E8E8)),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.Transparent
                    ),
                    modifier = Modifier
                        .width(170.dp)
                        .height(100.dp)
                        .background(color = Color.Transparent)
                        .padding(horizontal = 10.dp)

                ) {
                    Column (modifier = Modifier.fillMaxSize(),verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                        Text(
                            text = "Between"
                        )
                        Text(
                            text = "10PM : 11PM"
                        )
                    }
                }
            }
            Column(modifier = Modifier.fillMaxWidth().padding(vertical = 10.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                Button(
                    onClick = {},
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
                ) {
                    Text(
                        text = "Confirm"
                    )
                }
            }
        }
    }

}
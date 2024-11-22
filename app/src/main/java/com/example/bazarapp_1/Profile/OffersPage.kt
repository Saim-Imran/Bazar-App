package com.example.bazarapp_1.Profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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
fun OfferScreen(navController: NavHostController, authViewModel: AuthViewModel) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)) {
        OfferTopBar(
            navController = navController,
            authViewModel = AuthViewModel()
        )
OffersBody()
    }
}

@Composable
fun OfferTopBar(navController: NavHostController, authViewModel: AuthViewModel) {
    Column (modifier = Modifier){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 30.dp, top = 60.dp),
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
                text = "Offers History",
                color = Color.Black,
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = robotofontfamily,
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 10.dp)
            )
        }
        // column
        Text(
            text = "You have 6 Copons to use",
            color = Color.Black,
            fontFamily = robotofontfamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
            modifier = Modifier
                .padding(top = 20.dp, start = 20.dp)
        )
    }
}

@Composable
fun OffersBody(modifier: Modifier = Modifier) {
    Column (modifier = Modifier){
        Row (modifier=Modifier.fillMaxWidth()
            .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly, ){

            Box(
                modifier = Modifier
                    .size(width = 140.dp, height = 160.dp)
                    .background(
                        color = Color(0xff54408C),
                        shape = RoundedCornerShape(12.dp)
                    ),

                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {

                    Text(
                        text = "50%\nOFF",
                        lineHeight = 35.sp,
                        color = Color.White,
                        fontSize = 32.sp,

                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 4.dp)
                    )


                    Button(
                        onClick = { },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White
                        ),
                        modifier = Modifier.padding(4.dp)
                    ) {
                        Text(
                            text = "Copy",
                            color = Color(0xff54408C),
                            fontSize = 14.sp
                        )
                    }
                }
            }
            // 2nd box in row

            Box(
                modifier = Modifier
                    .size(width = 140.dp, height = 160.dp)
                    .background(
                        color = Color(0xffF5BE00),
                        shape = RoundedCornerShape(12.dp)
                    ),

                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {

                    Text(
                        text = "23%\nOFF",
                        lineHeight = 35.sp,
                        color = Color.White,
                        fontSize = 32.sp,

                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 4.dp)
                    )


                    Button(
                        onClick = { },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White
                        ),
                        modifier = Modifier.padding(4.dp)
                    ) {
                        Text(
                            text = "Copy",
                            color = Color(0xffF5BE00),
                            fontSize = 14.sp
                        )
                    }
                }
            }
        }
        //2nd row
        Row (modifier=Modifier.fillMaxWidth()
            .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly, ){

            Box(
                modifier = Modifier
                    .size(width = 140.dp, height = 160.dp)
                    .background(
                        color = Color(0xff3784FB),
                        shape = RoundedCornerShape(12.dp)
                    ),

                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {

                    Text(
                        text = "50%\nOFF",
                        lineHeight = 35.sp,
                        color = Color.White,
                        fontSize = 32.sp,

                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 4.dp)
                    )


                    Button(
                        onClick = { },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White
                        ),
                        modifier = Modifier.padding(4.dp)
                    ) {
                        Text(
                            text = "Copy",
                            color = Color(0xff3784FB),
                            fontSize = 14.sp
                        )
                    }
                }
            }
            // 2nd box in 2nd row

            Box(
                modifier = Modifier
                    .size(width = 140.dp, height = 160.dp)
                    .background(
                        color = Color(0xffFF8C39),
                        shape = RoundedCornerShape(12.dp)
                    ),

                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {

                    Text(
                        text = "23%\nOFF",
                        lineHeight = 35.sp,
                        color = Color.White,
                        fontSize = 32.sp,

                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 4.dp)
                    )


                    Button(
                        onClick = { },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White
                        ),
                        modifier = Modifier.padding(4.dp)
                    ) {
                        Text(
                            text = "Copy",
                            color = Color(0xffFF8C39),
                            fontSize = 14.sp
                        )
                    }
                }
            }
        }
        //column
        Row (modifier=Modifier.fillMaxWidth()
            .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly, ){

            Box(
                modifier = Modifier
                    .size(width = 140.dp, height = 160.dp)
                    .background(
                        color = Color(0xff121212),
                        shape = RoundedCornerShape(12.dp)
                    ),

                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {

                    Text(
                        text = "50%\nOFF",
                        lineHeight = 35.sp,
                        color = Color.White,
                        fontSize = 32.sp,

                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 4.dp)
                    )


                    Button(
                        onClick = { },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White
                        ),
                        modifier = Modifier.padding(4.dp)
                    ) {
                        Text(
                            text = "Copy",
                            color = Color(0xff121212),
                            fontSize = 14.sp
                        )
                    }
                }
            }
            // 2nd box in row

            Box(
                modifier = Modifier
                    .size(width = 140.dp, height = 160.dp)
                    .background(
                        color = Color(0xff34A853),
                        shape = RoundedCornerShape(12.dp)
                    ),

                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {

                    Text(
                        text = "23%\nOFF",
                        lineHeight = 35.sp,
                        color = Color.White,
                        fontSize = 32.sp,

                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 4.dp)
                    )


                    Button(
                        onClick = { },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White
                        ),
                        modifier = Modifier.padding(4.dp)
                    ) {
                        Text(
                            text = "Copy",
                            color = Color(0xff34A853),
                            fontSize = 14.sp
                        )
                    }
                }
            }
        }
        //column
    }
}

@Preview
@Composable
 fun OfferPrev () {
    BazarApp_1Theme {
        OfferScreen(
            navController = rememberNavController(),
            authViewModel = AuthViewModel()
        )
    }
}
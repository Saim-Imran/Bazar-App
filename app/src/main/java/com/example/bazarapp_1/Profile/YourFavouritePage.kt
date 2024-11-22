package com.example.bazarapp_1.Profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import com.example.bazarapp_1.AuthViewModel
import com.example.bazarapp_1.R
import com.example.bazarapp_1.ui.theme.BazarApp_1Theme
import com.example.bazarapp_1.ui.theme.robotofontfamily

@Composable
fun YourFavouriteScreen(navController: NavHostController, authViewModel: AuthViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        TopBarFavourite(
            navController = navController,
            authViewModel = AuthViewModel()
        )
        FavouriteBody()
    }
}

@Composable
fun TopBarFavourite(navController: NavHostController, authViewModel: AuthViewModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, top = 40.dp),
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
            text = "Your Favourite",
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
fun FavouriteBody(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.padding(top = 30.dp)) {
// first favourite
        Row(
            modifier = Modifier
                .padding(start = 15.dp, end = 15.dp)
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
                    .padding(start = 0.dp, top = 4.dp)
                    .weight(.5f)
            ) {
                Text(
                    text = "In in amet ultrices sit.",
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    fontFamily = robotofontfamily,
                    modifier = Modifier
                        .padding(start = 10.dp)

                )

                Text(
                    text = "$19.99",
                    color = Color(0xff54408C),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = robotofontfamily,
                    modifier = Modifier
                        .padding(start = 10.dp)
                )
            }
            Image(
                painter = painterResource(R.drawable.heart),
                contentDescription = "Favourite",
                modifier = Modifier
                    .weight(.2f)
                    .padding(top = 6.dp)
            )
        }
        HorizontalDivider(
            thickness = 1.dp,
            color = Color(0xffE5E4E2),
            modifier = Modifier
                .padding(top = 15.dp)

        )
        // 2nd favourite
        Row(
            modifier = Modifier
                .padding(start = 15.dp, end = 15.dp, top = 20.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.waitingf2),
                contentDescription = "F1",
                modifier = Modifier
                    .size(50.dp)
                    .weight(.2f)
            )
            Column(
                modifier = Modifier
                    .padding(start = 0.dp, top = 4.dp)
                    .weight(.5f)
            ) {
                Text(
                    text = "Bibendum facilisis.",
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    fontFamily = robotofontfamily,
                    modifier = Modifier
                        .padding(start = 10.dp)

                )

                Text(
                    text = "$27.12",
                    color = Color(0xff54408C),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = robotofontfamily,
                    modifier = Modifier
                        .padding(start = 10.dp)
                )
            }
            Image(
                painter = painterResource(R.drawable.heart),
                contentDescription = "Favourite",
                modifier = Modifier
                    .weight(.2f)
                    .padding(top = 6.dp)
            )
        }
        HorizontalDivider(
            thickness = 1.dp,
            color = Color(0xffE5E4E2
            ),
            modifier = Modifier
                .padding(top = 15.dp)

        )
        // 3rd favourite
        Row(
            modifier = Modifier
                .padding(start = 15.dp, end = 15.dp, top = 20.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.womenf3),
                contentDescription = "F1",
                modifier = Modifier
                    .size(50.dp)
                    .weight(.2f)
            )
            Column(
                modifier = Modifier
                    .padding(start = 0.dp, top = 4.dp)
                    .weight(.5f)
            ) {
                Text(
                    text = "Nulla et diam cras.",
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    fontFamily = robotofontfamily,
                    modifier = Modifier
                        .padding(start = 10.dp)

                )

                Text(
                    text = "$13.52",
                    color = Color(0xff54408C),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = robotofontfamily,
                    modifier = Modifier
                        .padding(start = 10.dp)
                )
            }
            Image(
                painter = painterResource(R.drawable.heart),
                contentDescription = "Favourite",
                modifier = Modifier
                    .weight(.2f)
                    .padding(top = 6.dp)
            )
        }
        HorizontalDivider(
            thickness = 1.dp,
            color = Color(0xffE5E4E2),
            modifier = Modifier
                .padding(top = 15.dp)

        )
        // 2nd favourite
        Row(
            modifier = Modifier
                .padding(start = 15.dp, end = 15.dp, top = 20.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.namef4),
                contentDescription = "F1",
                modifier = Modifier
                    .size(50.dp)
                    .weight(.2f)
            )
            Column(
                modifier = Modifier
                    .padding(start = 0.dp, top = 4.dp)
                    .weight(.5f)
            ) {
                Text(
                    text = "Risus malesuada in.",
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    fontFamily = robotofontfamily,
                    modifier = Modifier
                        .padding(start = 10.dp)

                )

                Text(
                    text = "$31.00",
                    color = Color(0xff54408C),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = robotofontfamily,
                    modifier = Modifier
                        .padding(start = 10.dp)
                )
            }
            Image(
                painter = painterResource(R.drawable.heart),
                contentDescription = "Favourite",
                modifier = Modifier
                    .weight(.2f)

                    .padding(top = 6.dp)
            )
        }
        HorizontalDivider(
            thickness = 1.dp,
            color = Color(0xffE5E4E2
            ),
            modifier = Modifier
                .padding(top = 15.dp)

        )
    }
}


@Preview
@Composable
fun FavouritePrev() {
    BazarApp_1Theme {
        YourFavouriteScreen(
            navController = rememberNavController(),
            authViewModel = AuthViewModel()
        )
    }
}
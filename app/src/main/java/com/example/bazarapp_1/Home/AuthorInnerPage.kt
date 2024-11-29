package com.example.bazarapp_1.Home


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
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
import com.example.bazarapp_1.R
import com.example.bazarapp_1.SuccessOrder.NewStarRatingBar



@Composable
fun AuthorInnerScreen(modifier: Modifier = Modifier,navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize()){
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState())
        ) {
            Row(
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(space = 110.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.arrow_left_outline),
                    contentDescription = "searchIcon",
                    modifier = Modifier.clickable { navController.popBackStack() }
                )
                Text(
                    text = "Authors",
                    style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.tess),
                    contentDescription = null,
                    Modifier.size(width = 124.dp, height = 124.dp)
                )
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp)
                ) {
                    Text(
                        text = "Novelist"
                    )
                }
                Text(
                    modifier = Modifier.padding(top = 10.dp),
                    text = "Tess Gunty",
                    style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold)
                )
                NewStarRatingBar(rating = 4)
            }
            Column (modifier = Modifier.padding(horizontal = 20.dp, vertical = 20.dp)){
                Text(
                    text = "About",
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                    )
                )
                Spacer(modifier = Modifier.padding(top = 10.dp))
                Text(
                    color = Color(0xFF7A7A7A),
                    text = "Gunty was born and raised in South Bend, Indiana.She graduated from the University of Notre Dame with a Bachelor of Arts in English and from New York University.\n"
                )
                Popular()
            }
        }
    }
}

@Composable
fun Popular(modifier: Modifier = Modifier) {
    val imageHeight = 150.dp // Define a consistent height for the images

    // First Row
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp), // Spacing between columns
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Column(
            modifier = Modifier
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.davinchi),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(imageHeight) // Make the image take full width with defined height
            )
            Text(
                text = "The Da Vinci Code",
                modifier = Modifier.padding(vertical = 5.dp),
                style = TextStyle(
                    fontWeight = FontWeight.Medium
                )
            )
            Text(text = "$19.99",textAlign = TextAlign.Start,
                color =Color(0xff54408C),)
        }
        Column(
            modifier = Modifier
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.fisher),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(imageHeight) // Make the image take full width with defined height
            )
            Text(
                text = "Carrie Fisher",
                modifier = Modifier.padding(vertical = 5.dp),
                style = TextStyle(
                    fontWeight = FontWeight.Medium
                )
            )
            Text(text = "$27.12",textAlign = TextAlign.Start,
                color =Color(0xff54408C),)
        }
    }

    // Second Row
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp), // Spacing between columns
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 20.dp, start = 16.dp, end = 16.dp)
    ) {
        Column(
            modifier = Modifier
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.goodsister1),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(imageHeight) // Make the image take full width with defined height
            )
            Text(
                text = "The Good Sister",
                modifier = Modifier.padding(vertical = 5.dp),
                style = TextStyle(
                    fontWeight = FontWeight.Medium
                )
            )
            Text(text = "$19.99",
                textAlign = TextAlign.Start,
                color =Color(0xff54408C),)
        }
        Column(
            modifier = Modifier
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.waiting),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(imageHeight) // Make the image take full width with defined height
            )
            Text(
                text = "The Waiting Room",
                modifier = Modifier.padding(vertical = 5.dp),
                style = TextStyle(
                    fontWeight = FontWeight.Medium
                )
            )
            Text(text = "$27.12",
                textAlign = TextAlign.Start,
                color =Color(0xff54408C),
//                modifier = Modifier
                        )
        }
    }
}

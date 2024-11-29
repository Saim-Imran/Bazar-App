package com.example.bazarapp_1.Home


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.bazarapp_1.R


@Composable
fun DetailMenuScreen(modifier: Modifier = Modifier,navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 50.dp) // Adding padding before clipping
            .clip(RoundedCornerShape(topStart = 55.dp, topEnd = 55.dp))
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.horizontalline),
                contentDescription = null,
                modifier = modifier.clickable { navController.popBackStack() }
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 22.dp,
                    //    start = 20.dp, end = 20.dp
                    ),
                horizontalArrangement = Arrangement.Center,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.kiteruuner1),
                    contentDescription = null,
                    modifier = Modifier
                        .size(220.dp)
                )
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp, vertical = 15.dp)
            ) {
                Text(
                    text = "The Kite Runner",
                    style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Black)
                )
                Image(painter = painterResource(id = R.drawable.heart), contentDescription = null)
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 40.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.gooday11),
                    contentDescription = null
                )
                Text(
                    lineHeight = 18.sp,
                    text = "Lorem ipsum dolor sit amet, consectetur\nadipiscing elit. Viverra dignissim ac ac ac. Nibh et\nsed ac, eget malesuada.",
                    style = TextStyle(fontSize = 14.sp),
                    modifier = Modifier.padding(top = 15.dp)
                )
                Text(
                    text = "Review",
                    style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Black),
                    modifier = Modifier.padding(top = 20.dp)
                )
                NewStarRatingBar(rating = 4)

                Counter()
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    FilledButtonExample(onClick = {})
                    FilledTonalButtonExample(onClick = {})
                    Spacer(modifier = Modifier.padding(horizontal = 10.dp))

                }
            }
        }

    }
}

@Composable
fun NewStarRatingBar(
    rating: Int, // Number of selected stars
    maxStars: Int = 5
) {
    Spacer(modifier = Modifier.padding(top = 10.dp))
    // Adjust the size of the stars
    val starSize = 24.dp
    val starSpacing = 1.dp

    Row(
        modifier = Modifier.selectableGroup(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        for (i in 1..maxStars) {
            // Determine which icon to display: filled or outlined
            val icon = if (i <= rating) Icons.Filled.Star else Icons.Outlined.Star
            val iconTintColor = if (i <= rating) Color(0xFFFFC700) else Color.Black

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
        Text(
            text = "(4.0)"
        )
    }
}
@Composable
fun Counter(modifier: Modifier = Modifier) {
    val counter = rememberSaveable { mutableStateOf(1) }
    val price = rememberSaveable { mutableStateOf(39.99) }

    Row(modifier = Modifier.padding(top = 15.dp)) {
        Row(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(10.dp))
                .background(color = Color(0xFFE8E8E8))
                .padding(top = 10.dp)
        ) {
            // Less Button
            Box(
                modifier = Modifier
                    .size(30.dp) // Set consistent size for round buttons
                    .clip(CircleShape)
                    .background(color = Color(0xFFA6A6A6))
                    .clickable {
                        if (counter.value > 1) {
                            counter.value -= 1
                        }
                    }
//                    .padding(top = 6.dp)

            ) {
                Icon(
                    painter = painterResource(id = R.drawable.minus),
                    contentDescription = "Decrease",
                    tint = Color.White,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(20.dp) // Adjust icon size
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            // Counter Value
            Text(
                text = "${counter.value}",
                color = Color.Black,
                modifier = Modifier.padding(
                    start = 10.dp, end = 10.dp,
                )
            )
            Spacer(modifier = Modifier.width(10.dp))
            // Add Button
            Box(
                modifier = Modifier
                    .size(30.dp) // Set consistent size for round buttons
                    .clip(CircleShape)
                    .background(color = Color(0xFF54408C))
                    .clickable {
                        counter.value += 1
                    }
//                .padding(top = 6.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.plus),
                    contentDescription = "Increase",
                    tint = Color.White,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(20.dp) // Adjust icon size
                )
            }
        }
        // Total Price
        Text(
            text = "$${price.value * counter.value}",
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(start = 20.dp),
            color = Color(0xFF54408C)
        )
    }
}

@Composable
fun FilledButtonExample(onClick: () -> Unit) {
    Button(
        onClick = { onClick() },
        modifier = Modifier.size(width = 180.dp, height = 50.dp)
            .padding(end = 4.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0XFF54408C))
    ) {
        Text("Continue shopping",
            color = Color.White)
    }
}

@Composable
fun FilledTonalButtonExample(onClick: () -> Unit) {
    FilledTonalButton(
        onClick = { onClick() },
        modifier = Modifier.size(width = 120.dp, height = 50.dp)
    ) {
        Text("View cart")
    }
}
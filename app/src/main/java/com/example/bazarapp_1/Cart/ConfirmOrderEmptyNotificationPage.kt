package com.example.bazarapp_1.Cart


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
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



@Composable
fun ConfirmOrderEmptyNotificationScreen(modifier: Modifier = Modifier,navController: NavHostController) {
    Column (modifier = Modifier.fillMaxSize()){
        Column() {
            Row(
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxWidth(),
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.arrow_left_outline),
                    contentDescription = "notification",
                    modifier =Modifier.clickable { navController.popBackStack() }
                )
                Text(
                    text = "Notification",
                    style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
                    modifier = Modifier.weight(1f).padding(start = 90.dp)
                )

            }
        }
        Column (horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth().fillMaxHeight(), verticalArrangement = Arrangement.Center){
            Image(painter = painterResource(id = R.drawable.bignotification), contentDescription = null)
            Text(
                text = "There is no notification",
                modifier = Modifier.padding(vertical = 20.dp)
            )
        }
    }
}
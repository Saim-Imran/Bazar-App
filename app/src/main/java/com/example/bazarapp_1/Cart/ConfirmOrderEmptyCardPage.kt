package com.example.bazarapp_1.Cart


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import com.example.bazarapp_1.ConfirmOrderEmptyCardPage
import com.example.bazarapp_1.HomePage
import com.example.bazarapp_1.MenuPage1
import com.example.bazarapp_1.ProfilePage
import com.example.bazarapp_1.R


@Composable
fun ConfirmOrderEmptyCartScreen(modifier: Modifier = Modifier,navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize()
        .background(color = Color.White)) {

        Column(modifier = Modifier.weight(.3f)) {
            Row(
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxWidth(),
            ) {
                Text(
                    text = "My Cart",
                    style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
                    modifier = Modifier.weight(1f).padding(start = 130.dp)
                )
                Icon(
                    painter = painterResource(id = R.drawable.notification),
                    contentDescription = "notification",

                    )
            }
        }
        Column (horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize().weight(.6f) ,
            verticalArrangement = Arrangement.Center){
            Image(painter = painterResource(id = R.drawable.bigcart), contentDescription = null)
            Text(
                text = "There is no products",
                modifier = Modifier.padding(vertical = 20.dp)
            )
        }
            Column (modifier = Modifier.weight(.1f)){
                BottomNavigationScreen(
                    modifier = Modifier,
                    navController = navController
                )
            }
    } }


@Composable
fun BottomNavigationScreen(modifier: Modifier = Modifier, navController: NavHostController) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .padding(bottom = 0.dp)
            .background(color = Color.White),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically

    ) {
        Column {
            Image(
                painter = painterResource(R.drawable.home_fill),
                contentDescription = "Home",

                modifier = Modifier.clickable { navController.navigate(HomePage) }
            )
            Text(
                text = "Home",
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                color = Color(0xffA6A6A6),
                modifier = Modifier.clickable { navController.navigate(HomePage) }
                )
        }
        Column {
            Image(
                painter = painterResource(R.drawable.menu_fill),
                contentDescription = "menu",

                modifier = Modifier.clickable { navController.navigate(MenuPage1) }
            )
            Text(
                text = "Category",
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                color = Color(0xffA6A6A6),
               modifier = Modifier.clickable { navController.navigate(MenuPage1) }
                )
        }
        Column {
            Image(
                painter = painterResource(R.drawable.cart_fill),
                contentDescription = "cart",
                modifier = Modifier.clickable {navController.navigate(ConfirmOrderEmptyCardPage) }

            )
            Text(
                text = "Cart",
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                color = Color(0xffA6A6A6),
                modifier = Modifier.clickable { navController.navigate(ConfirmOrderEmptyCardPage) }
            )
        }
        Column {
            Image(
                painter = painterResource(R.drawable.profile),
                contentDescription = "Home",
                modifier = Modifier.clickable { navController.navigate(ProfilePage)

                }
            )
            Text(
                text = "Profile",
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                color = Color(0xffA6A6A6),
            modifier = Modifier.clickable { navController.navigate(ProfilePage) }
                )
        }
    }
}
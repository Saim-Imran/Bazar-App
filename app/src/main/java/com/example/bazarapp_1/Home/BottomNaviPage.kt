package com.example.bazarapp_1.Home


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.bazarapp_1.MenuPage1
import com.example.bazarapp_1.ProfilePage
import com.example.bazarapp_1.R

data class BottomNavigationItem(
    val title: String,
    val selectedIcon: Int,
    val unselectedIcon: Int,
    val modifier: Modifier
)

/*

@Composable
fun BottomNavigationScreen(modifier: Modifier = Modifier, navController: NavHostController
) {
    val items = listOf(
        BottomNavigationItem(
            title = "Home",
            selectedIcon = R.drawable.homefillnew,
            unselectedIcon = R.drawable.homen,
            modifier =Modifier
                .clickable {  }
        ),
        BottomNavigationItem(
            title = "Category",
            selectedIcon = R.drawable.menufillnew,
            unselectedIcon = R.drawable.menun,
            modifier =Modifier
                .clickable { navController.navigate(MenuPage1) }
        ),
        BottomNavigationItem(
            title = "Cart",
            selectedIcon = R.drawable.cartfillnew,
            unselectedIcon = R.drawable.cartn,
            modifier =Modifier
                .clickable {  }
        ),
        BottomNavigationItem(
            title = "Profile",
            selectedIcon = R.drawable.profilefillnew,
            unselectedIcon = R.drawable.profilen,
            modifier =Modifier
                .clickable { navController.navigate(ProfilePage) }
        )
    )

    var selectedItemIndex by rememberSaveable { mutableStateOf(0) }

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(bottom = 8.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        NavigationBar(
            containerColor = Color.White // Explicitly set the background color here
        ) {
            items.forEachIndexed { index, item ->
                NavigationBarItem(
                    selected = selectedItemIndex == index,
                    onClick = { selectedItemIndex = index },
                    icon = {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            // Display the icon using painterResource
                            Image(
                                painter = painterResource(
                                    id = if (index == selectedItemIndex) {
                                        item.selectedIcon
                                    } else {
                                        item.unselectedIcon
                                    }
                                ),
                                contentDescription = item.title,
                                modifier = Modifier.size(28.dp) // Adjusted size
                            )
                            // Display the text label below the icon
                            Text(
                                text = item.title,
                                fontSize = 12.sp,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(top = 4.dp)
                            )
                        }
                    },
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = Color.Transparent, // Removes the selection highlight
                        selectedIconColor = Color.Black,    // Customize selected icon color
                        unselectedIconColor = Color.Gray    // Customize unselected icon color
                    )
                )
            }
        }
    }
}
*/

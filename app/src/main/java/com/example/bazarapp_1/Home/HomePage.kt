package com.example.bazarapp_1.Home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.bazarapp_1.AuthorPage
import com.example.bazarapp_1.ConfirmOrderPage
import com.example.bazarapp_1.DetailPage
import com.example.bazarapp_1.HomePage
import com.example.bazarapp_1.MenuPage1
import com.example.bazarapp_1.NotificationDeliveryPage
import com.example.bazarapp_1.ProfilePage
import com.example.bazarapp_1.R
import com.example.bazarapp_1.VenderPage
import com.example.bazarapp_1.ui.theme.BazarApp_1Theme

@Composable
fun HomeScreenNew(modifier: Modifier = Modifier, navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize()) {
        // Top section (HomeScreen)
        Column(
            modifier = Modifier
                .weight(0.1f)
                .background(Color.White)
        ) {
            HomeScreen(
                modifier = Modifier,
                navController = navController
            )
        }

        // Middle section (Scrollable content)
        Column(
            modifier = Modifier
                .weight(0.8f)
                .background(Color.White)
                .verticalScroll(rememberScrollState()) // Make this section scrollable
        ) {
            SpecialOffer(
                modifier = Modifier,
                navController = navController
            )

            TopOfWeek(
                modifier = Modifier,
                navController = navController
            )

            BestVendors(
                modifier = Modifier,
                navController = navController
            )
            Authors(
                modifier = Modifier,
                navController = navController
            )
        }

        // Bottom section (Bottom navigation)
        Column(
            modifier = Modifier
                .weight(0.1f)
                .background(Color.White) // Set a background color for bottom navigation
        ) {
            BottomNavigationScreen(
                modifier = Modifier.background(color = Color.White),
                navController = navController,
            )
        }
    }
}


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {

    Column(
        modifier = Modifier
            .fillMaxSize()

            .background(color = Color.White)

    ) {
        Row(
            modifier = Modifier

                .padding(15.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                painter = painterResource(id = R.drawable.search),
                contentDescription = "searchIcon",
                tint = Color.Black
            )
            Text(
                text = "Home",
                fontSize = 20.sp, fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
            Icon(
                painter = painterResource(id = R.drawable.notification),
                contentDescription = "notification",
                tint = Color.Black,
                modifier = Modifier.clickable { navController.navigate(NotificationDeliveryPage) }

            )
        }

    }
    Column(
        modifier
            .fillMaxSize()
            .padding(top = 20.dp)
            .verticalScroll(rememberScrollState())
    ) {

    }
}

@Composable
fun SpecialOffer(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    Row(
        modifier = Modifier

            .fillMaxWidth()


            .padding(20.dp)
            .background(color = Color(0xFFF2F2F2)),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(modifier = Modifier.padding(24.dp)) {
            Text(
                text = "Special Offer",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Text(
                text = "Discount 25%",
                fontSize = 14.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.padding(top = 20.dp))
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF54408C))
            ) {
                Text(
                    text = "Order Now",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }
        Image(painter = painterResource(id = R.drawable.appolo), contentDescription = "Appolo")

    }

}

@Composable
fun TopOfWeek(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp), horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Top of Week",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Text(
            text = "See all",
            style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .clickable { navController.navigate(DetailPage) },

            color = Color(0xFF54408C),

            )
    }
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(5.dp) // Set the space between items to 5.dp
    ) {
        item {
            BooksInfo(
                bookImage = R.drawable.homekiterunner,
                title = "The Kite Runner",
                price = "$14.99"
            )
        }
        item {
            BooksInfo(
                bookImage = R.drawable.homesubtitle,
                title = "The Subtle Art of not",
                price = "$20.99"
            )
        }
        item {
            BooksInfo(
                bookImage = R.drawable.homewar,
                title = "The Kite Runner",
                price = "$14.99"
            )
        }
        item {
            BooksInfo(
                bookImage = R.drawable.homekiterunner,
                title = "The Subtle Art of not",
                price = "$20.99"
            )
        }
        item {
            BooksInfo(
                bookImage = R.drawable.homesubtitle,
                title = "The Kite Runner",
                price = "$14.99"
            )
        }
        item {
            BooksInfo(
                bookImage = R.drawable.homekiterunner,
                title = "The Subtle Art of not",
                price = "$20.99"
            )
        }
    }

    // Authors()
}

@Composable
fun BooksInfo(modifier: Modifier = Modifier, bookImage: Int, title: String, price: String) {
    Column(
        modifier = Modifier
            .padding(horizontal = 4.dp, vertical = 5.dp)
            .width(IntrinsicSize.Min)
    ) {

        Image(
            painter = painterResource(bookImage),
            contentDescription = null,
            modifier = Modifier
                .size(120.dp)
            //               .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.padding(top = 5.dp))


        Text(
            text = title,
            fontSize = 14.sp,
            color = Color.Black,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                //   .width(100.dp)
                .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.padding(top = 5.dp))


        Text(
            text = price,
            style = TextStyle(fontSize = 12.sp, color = Color(0xFF54408C)),
            modifier = Modifier
                .padding(start = 8.dp)
        )
    }
}

@Composable
fun BestVendors(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp), horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Best Vendors",
            fontSize = 18.sp, fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Text(
            text = "See all",
            style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier
                .align(Alignment.CenterVertically)

                .clickable { navController.navigate(VenderPage) },

            color = Color(0xFF54408C)
        )
    }
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        items(4) { index ->

            when (index) {
                0 -> Image(
                    painter = painterResource(id = R.drawable.warehouse),
                    contentDescription = null
                )

                1 -> Image(
                    painter = painterResource(id = R.drawable.kuromi),
                    contentDescription = null
                )

                2 -> Image(
                    painter = painterResource(id = R.drawable.gooday),
                    contentDescription = null
                )

                3 -> Image(
                    painter = painterResource(id = R.drawable.black),
                    contentDescription = null
                )
            }
        }
    }


    // Authors()
}

@Composable
fun Authors(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp), horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Authors",
            fontSize = 18.sp, fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Text(
            text = "See all",
            style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .clickable { navController.navigate(AuthorPage) },
            color = Color(0xFF54408C)
        )
    }
    LazyRow {
        item {
            AuthorInfo(
                authorImage = R.drawable.freeman,
                authorName = "John Freeman",
                authorTitle = "Writer"
            )
        }
        item {
            AuthorInfo(
                authorImage = R.drawable.tess,
                authorName = "Tess Gunty",
                authorTitle = "Novelist"
            )
        }
        item {
            AuthorInfo(
                authorImage = R.drawable.richard,
                authorName = "Richard Perston",
                authorTitle = "Writer"
            )
        }
        item {
            AuthorInfo(
                authorImage = R.drawable.freeman,
                authorName = "John Freeman",
                authorTitle = "Writer"
            )
        }
        item {
            AuthorInfo(
                authorImage = R.drawable.tess,
                authorName = "Tess Gunty",
                authorTitle = "Novelist"
            )
        }
        item {
            AuthorInfo(
                authorImage = R.drawable.richard,
                authorName = "Richard Perston",
                authorTitle = "Writer"
            )
        }

    }
}

@Composable
fun AuthorInfo(
    modifier: Modifier = Modifier,
    authorImage: Int,
    authorName: String,
    authorTitle: String
) {
    Column(modifier = Modifier.padding(20.dp)) {
        Image(
            painter = painterResource(authorImage), contentDescription = null,
            modifier = Modifier.size(70.dp)
        )
        Spacer(modifier = Modifier.padding(5.dp))
        Text(
            text = authorName,
            fontSize = 14.sp, fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.align(Alignment.Start)
        )
        Spacer(modifier = Modifier.padding(3.dp))
        Text(
            text = authorTitle,
            style = TextStyle(fontSize = 12.sp, color = Color(0xffA6A6A6))
        )

    }
}


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

                )
        }
        Column {
            Image(
                painter = painterResource(R.drawable.cart_fill),
                contentDescription = "cart",
                modifier = Modifier.clickable { }

            )
            Text(
                text = "Cart",
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                color = Color(0xffA6A6A6),
                modifier = Modifier.clickable { navController.navigate(ConfirmOrderPage) }
            )
        }
        Column {
            Image(
                painter = painterResource(R.drawable.profile),
                contentDescription = "Home",
                modifier = Modifier.clickable { navController.navigate(ProfilePage) }
            )
            Text(
                text = "Profile",
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                color = Color(0xffA6A6A6),
            )
        }
    }
}


@Preview
@Composable
fun HomePrev() {
    BazarApp_1Theme {
        HomeScreen(
            modifier = Modifier,
            navController = rememberNavController()
        )
    }

}
package com.example.bazarapp_1.Category

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.Column


import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.example.bazarapp_1.AuthState
import com.example.bazarapp_1.AuthViewModel
import com.example.bazarapp_1.LoginPage

import com.example.bazarapp_1.R
import com.example.bazarapp_1.SignupPage
import com.example.bazarapp_1.common.CategoryBodyList
import com.example.bazarapp_1.ui.theme.BazarApp_1Theme

@Composable
fun MenuScreen(navController: NavHostController,authViewModel: AuthViewModel) {
    var selectedCategory by remember { mutableStateOf("All") }



    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)

    ) {
        TopBar(
            modifier = Modifier
                .weight(0.2f),
            navController = navController,
            authViewModel = authViewModel,
        )
        Column (modifier = Modifier.weight(.6f)){
            CategoryRow(
                selectedCategory = selectedCategory,
                onCategorySelected = { newCategory -> selectedCategory = newCategory },
                modifier = Modifier
                //        .weight(0.2f)
            )

            CategoryBody(
                selectedCategory = selectedCategory,
                modifier = Modifier
                //      .fillMaxSize()
                //      .weight(0.4f)
            )
        }
        BottomNavigation(
            modifier = Modifier
                .weight(.2f)
                .fillMaxWidth()
//                .align(Alignment.BottomCenter)
        )
    }
}


@Composable
fun TopBar(modifier: Modifier,navController: NavHostController,authViewModel: AuthViewModel) {

    val authState by authViewModel.authState.observeAsState()

    // Monitor logout state
    LaunchedEffect(authState) {
        if (authState is AuthState.Unauthenticated) {
            navController.navigate(SignupPage)


        }
    }

    Row(
        modifier = Modifier
            .padding(top = 30.dp, start = 20.dp, end = 20.dp)
            .fillMaxWidth(),
        //   horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Image(
            painter = painterResource(R.drawable.search),
            contentDescription = "Search",

            modifier = Modifier
                .size(25.dp)

        )
        Spacer(modifier = Modifier.width(100.dp))
        Text(
            text = "Category",
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,

            modifier = Modifier

        )
        Spacer(modifier = Modifier.width(90.dp))
        Image(
            painter = painterResource(R.drawable.notification),
            contentDescription = "Notification",
            modifier = Modifier
                .size(25.dp)
                .clickable {
                    authViewModel.signout()
                }
        )
    }
}

@Composable
fun CategoryRow(
    selectedCategory: String,
    onCategorySelected: (String) -> Unit,
    modifier: Modifier
) {
    val categories = listOf("All", "Novels", "Self Love", "Science", "Romantic")

    LazyRow(modifier = Modifier.padding(top = 25.dp, start = 20.dp, end = 20.dp)) {
        items(categories.size) { index ->
            val category = categories[index]
            Text(
                text = category,
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                fontWeight = if (category == selectedCategory) FontWeight.Bold else FontWeight.Normal,
                color = if (category == selectedCategory) Color.Black else Color.Gray,
                modifier = Modifier
                    .clickable { onCategorySelected(category) }
                    .padding(horizontal = 8.dp)
            )
            if (index < categories.size - 1) {
                Spacer(modifier = Modifier.width(16.dp))
            }
        }
    }
}

data class Book(val title: String, val price: String, val imageRes: Int, val category: String)

@Composable
fun CategoryBody(selectedCategory: String, modifier: Modifier) {

    val books = listOf(
        Book("The Da Vinci Code", "$19.99", R.drawable.thecode, "Novels"),
        Book("Carrie Fisher", "$27.12", R.drawable.carriefisher, "Novels"),
        Book("The Good Sisters", "$27.12", R.drawable.goodsisters, "Self Love"),
        Book("The Waiting", "$27.12", R.drawable.waiting, "Science"),
        Book("Where Are You", "$27.12", R.drawable.where, "Romantic"),
        Book("Bright Young Women", "$27.12", R.drawable.youngwomen, "Self Love")
    )

    val filteredBooks =
        if (selectedCategory == "All") books else books.filter { it.category == selectedCategory }

    LazyColumn(
        modifier = Modifier.padding(
            start = 20.dp,
            end = 20.dp,
            top = 25.dp,
           // bottom = 20.dp
        )
    ) {
        items(filteredBooks.chunked(2)) { rowBooks ->
            Row(modifier = Modifier.fillMaxWidth()) {
                rowBooks.forEach { book ->
                    CategoryBodyList(
                        ImageBook = book.imageRes,
                        Text1 = book.title,
                        Text2 = book.price,
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(modifier = Modifier.width(15.dp))
                }


                if (rowBooks.size == 1) {
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
        }
    }

}


@Composable
fun BottomNavigation(modifier: Modifier = Modifier) {

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
                modifier = Modifier
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
                modifier = Modifier
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
                modifier = Modifier
            )
            Text(
                text = "Cart",
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                color = Color(0xffA6A6A6),
            )
        }
        Column {
            Image(
                painter = painterResource(R.drawable.profile),
                contentDescription = "Home",
                modifier = Modifier
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
fun MenuPreview() {
    BazarApp_1Theme {
        MenuScreen(
            navController = rememberNavController(),
            authViewModel = AuthViewModel(),
        )
    }
}
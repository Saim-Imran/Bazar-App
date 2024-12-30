package com.example.bazarapp_1.Home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
fun VendorsScreen(modifier: Modifier = Modifier, navController: NavHostController) {
    var selectedCategory by remember { mutableStateOf("All") }

    val vendors = listOf(
        "All" to listOf(
            Pair(R.drawable.watttpad, "Wattpad"),
            Pair(R.drawable.kuromi, "Kuromi"),
            Pair(R.drawable.crane, "Crane & Co"),
            Pair(R.drawable.gooday, "GooDay"),
            Pair(R.drawable.warehouse, "Warehouse"),
            Pair(R.drawable.peppa_pig, "Peppa Pig"),
            Pair(R.drawable.jstor, "Jstor"),
            Pair(R.drawable.peleton, "Peloton"),
            Pair(R.drawable.haymarket, "Haymarket")
        ),
        "Books" to listOf(
            Pair(R.drawable.watttpad, "Wattpad"),
            Pair(R.drawable.jstor, "Jstor")
        ),
        "Poems" to listOf(
            Pair(R.drawable.crane, "Crane & Co"),
            Pair(R.drawable.haymarket, "Haymarket")
        ),
        "Special for you" to listOf(
            Pair(R.drawable.gooday, "GooDay"),
            Pair(R.drawable.peppa_pig, "Peppa Pig")
        ),
        "Stationary" to listOf(
            Pair(R.drawable.kuromi, "Kuromi"),
            Pair(R.drawable.warehouse, "Warehouse")
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(color = Color.White)
    ) {
        Row(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                painter = painterResource(id = R.drawable.arrow_left_outline),
                contentDescription = "Back",
                tint = Color.Black,
                modifier = Modifier.clickable { navController.popBackStack() }
            )
            Text(
                text = "Vendors",
                style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Black),
                modifier = Modifier.align(Alignment.CenterVertically)
            )
            Icon(
                painter = painterResource(id = R.drawable.search),
                contentDescription = "Search",
                tint = Color.Black
            )
        }
        Title(title = "Our Vendors", mainTitle = "Vendors")
        HorizontalSlider(
            items = vendors.map { it.first },
            selectedCategory = selectedCategory,
            onCategorySelected = { selectedCategory = it }
        )
        AllVendors(vendors = vendors.firstOrNull { it.first == selectedCategory }?.second ?: emptyList())
    }
}
@Composable
fun Title(modifier: Modifier = Modifier,title:String,mainTitle:String) {
    Column(modifier = Modifier.padding(start = 20.dp)) {
        Text(
            text = title,
            style = TextStyle(fontSize = 16.sp, color = Color(0xFFA6A6A6))
        )
        Spacer(modifier = Modifier.padding(top = 5.dp))
        Text(
            text = mainTitle,
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF54408C)
            )
        )
        // HorizontalSlider()
    }
}
@Composable
fun HorizontalSlider(
    items: List<String>,
    selectedCategory: String,
    onCategorySelected: (String) -> Unit
) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 24.dp, start = 20.dp, end = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        items(items) { item ->
            Text(
                text = item,
                style = TextStyle(
                    fontSize = 16.sp,
                    color = if (item == selectedCategory) Color.Black else Color(0xffA6A6A6)
                ),
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .clickable { onCategorySelected(item) }
            )
        }
    }
}

@Composable
fun AllVendors(vendors: List<Pair<Int, String>>, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        vendors.chunked(3).forEach { rowVendors ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                rowVendors.forEach { (imageRes, name) ->
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(horizontal = 8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = imageRes),
                            contentDescription = null,
                            modifier = Modifier.size(100.dp)
                        )
                        Text(
                            text = name,
                            style = TextStyle(
                                fontWeight = FontWeight.Bold,
                                fontSize = 14.sp,
                                color = Color.Black
                            ),
                            modifier = Modifier.padding(top = 8.dp)
                        )
                        StarRatingBar(rating = (2..5).random())
                    }
                }
            }
        }
    }
}



@Composable
fun StarRatingBar(
    rating: Int, // Number of selected stars
    maxStars: Int = 5
) {
    Spacer(modifier = Modifier.padding(top = 10.dp))
    // Adjust the size of the stars
    val starSize = 18.dp
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
    }
}
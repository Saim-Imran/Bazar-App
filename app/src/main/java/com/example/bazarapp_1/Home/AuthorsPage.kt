package com.example.bazarapp_1.Home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.bazarapp_1.AuthorInnerPage
import com.example.bazarapp_1.R


@Composable
fun AuthorsScreen(modifier: Modifier = Modifier,navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
        //.verticalScroll(rememberScrollState())
//         .padding(top = 20.dp)
        //.background(color = Color(0xFFF3F3F3))
    ) {
        Row(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                painter = painterResource(id = R.drawable.arrow_left_outline),
                contentDescription = "searchIcon",
                modifier =Modifier.clickable { navController.popBackStack() }
            )
            Text(
                text = "Authors",
                style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
                modifier = Modifier.align(Alignment.CenterVertically)
            )
            Icon(
                painter = painterResource(id = R.drawable.search),
                contentDescription = "notification",
                modifier = Modifier.clickable { navController.navigate(AuthorInnerPage) }
            )
        }
        Title(title = "Check the authors", mainTitle = "Authors")
        HorizontalSliderAuthors()
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            AuthorsInfo(
                image = R.drawable.johnfreeman,
                name = "John Freeman",
                note = "American writer he was the\neditor of the"
            )
            AuthorsInfo(
                image = R.drawable.adam,
                name = "Adam Dalva",
                note = "He is the senior fiction editor of guernica ma"
            )
            AuthorsInfo(
                image = R.drawable.abrahim,
                name = "Abraham verghese",
                note = "He is the professor and Linda R . Meier and "
            )
            AuthorsInfo(
                image = R.drawable.tess1,
                name = "Tess Gunty",
                note = "Gunty was born and raised in south bend,indiana",
                modifier = Modifier.clickable { navController.navigate(AuthorInnerPage) }
            )
            AuthorsInfo(
                image = R.drawable.ann,
                name = "Ann Napolitano",
                note = "She is the author of the novels A Good Hard"
            )
            AuthorsInfo(
                image = R.drawable.harnan,
                name = "Hernan Diaz",
                note = "Lorem ipsum dolor sit amet..."
            )
        }


    }
}


@Composable
fun HorizontalSliderAuthors(modifier: Modifier = Modifier) {
    LazyRow(
        modifier = Modifier
            .padding(vertical = 24.dp, horizontal = 24.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        item {
            Text(
                text = "All",
                style = TextStyle(fontSize = 16.sp),
                modifier = Modifier.padding(end = 20.dp)
            )
        }
        item {
            Text(
                text = "Poets",
                style = TextStyle(fontSize = 16.sp, color = Color(0xffA6A6A6)),
                modifier = Modifier.padding(end = 20.dp)

            )
        }
        item {
            Text(
                text = "Playwrights",
                style = TextStyle(fontSize = 16.sp, color = Color(0xffA6A6A6)),
                modifier = Modifier.padding(end = 20.dp)

            )
        }
        item {
            Text(
                text = "Novelists",
                style = TextStyle(fontSize = 16.sp, color = Color(0xffA6A6A6)),
                modifier = Modifier.padding(end = 20.dp)

            )
        }
        item {
            Text(
                text = "Journalists",
                style = TextStyle(fontSize = 16.sp, color = Color(0xffA6A6A6)),
                modifier = Modifier.padding(end = 20.dp)

            )
        }

        item {
            Text(
                text = "Journalists",
                style = TextStyle(fontSize = 16.sp, color = Color(0xffA6A6A6)),
                modifier = Modifier.padding(end = 20.dp)


            )
        }

    }


    // AllVendors()
}

@Composable
fun AuthorsInfo(modifier: Modifier = Modifier, image: Int, name: String, note: String) {
    Row(modifier = Modifier.padding(horizontal = 20.dp, vertical = 20.dp)) {
        Image(painter = painterResource(image), contentDescription = null)
        Column(modifier = Modifier.padding(horizontal = 10.dp)) {
            Text(
                text = name,
                style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(top = 16.dp)
            )
            Text(
                text = note,
                style = TextStyle(fontSize = 16.sp),
                modifier = Modifier.padding(top = 10.dp)
            )
        }
    }
}
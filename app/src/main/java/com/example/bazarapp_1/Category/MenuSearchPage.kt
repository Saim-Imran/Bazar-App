package com.example.bazarapp_1.Category

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bazarapp_1.R
import com.example.bazarapp_1.ui.theme.BazarApp_1Theme
import com.example.bazarapp_1.ui.theme.robotofontfamily

@Composable
fun MenuSearchScreen(modifier: Modifier = Modifier) {
    Column (modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)
    ){
TopBarMenuSearch()
        SearchTextField()
        RecentText()
    }
}


@Composable
fun TopBarMenuSearch(modifier: Modifier = Modifier) {

        Row (modifier = Modifier.padding(top = 30.dp)
            ){
        Image(
            painter = painterResource(R.drawable.arrow_left_outline),
            contentDescription = "Back",
            modifier = Modifier
                .padding(start = 20.dp)
        )
            Text(
                text = "Search",
                textAlign = TextAlign.Center,
                color = Color.Black,
                fontSize = 20.sp,
                fontFamily = robotofontfamily ,
                fontWeight = FontWeight.Bold,

                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .weight(1f)
            )
    }
}

@Composable
fun SearchTextField(modifier: Modifier = Modifier) {
    var searchInput by remember { mutableStateOf("") }
    OutlinedTextField(
        value = searchInput,
        onValueChange = { searchInput =it },
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = "Email Icon",
                tint = Color.Gray
            )
        },
        placeholder = {
            Text(
                text = " Search",
                color = Color(0xffB8B8B8)
            )
        },
        modifier = Modifier

            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, top = 20.dp),
        shape = RoundedCornerShape(10.dp),
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedContainerColor = Color(0xffF5F5F5),
            focusedContainerColor = Color(0xffF5F5F5),
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent
        ),
        singleLine = true,
        textStyle = TextStyle(
            color = Color.Black // Set text color here
        )
        

    )
}

@Composable
fun RecentText(modifier: Modifier = Modifier) {
    Text(
        text = "Recent Searches",
        fontSize = 16.sp,
        fontFamily = robotofontfamily ,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .padding(start = 20.dp, top = 20.dp)
    )
}

@Preview
@Composable
 fun MenuSearchPrew() {
    BazarApp_1Theme {
        MenuSearchScreen()
    }
}
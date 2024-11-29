package com.example.bazarapp_1.Cart


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

import com.example.bazarapp_1.R


@Composable
fun ConfirmOrderLocationScreen(modifier: Modifier = Modifier,navController: NavHostController) {
    Column {
        Column() {
            Row(
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.arrow_left_outline),
                    contentDescription = "searchIcon",
                    modifier=Modifier.clickable { navController.popBackStack() }
                )
                Text(
                    text = "Location",
                    style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
                Icon(
                    painter = painterResource(id = R.drawable.target),
                    contentDescription = "notification",
                    tint = Color(0xff54408C)
                )
            }
        }
        Column (modifier.verticalScroll(rememberScrollState())){
            EmptyFields()
            Button(
                onClick = {},
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 16.dp)
            ) {
                Text(
                    text = "Confirmation"
                )
            }
        }
    }
}
@Composable
fun EmptyFields(modifier: Modifier = Modifier) {
    var phoneInput by remember { mutableStateOf("") }
    var nameInput by remember { mutableStateOf("") }
    var governorateInput by remember { mutableStateOf("") }
    var passwordInput by remember { mutableStateOf("") }
    var phoneNumberInput by remember { mutableStateOf("") }
// for password visibility



//Name field
    Text(
        text = "Phone",
        color = Color(0xff121212),
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .padding(start = 20.dp, top = 20.dp)

    )
    OutlinedTextField(
        value = phoneInput,
        onValueChange = { phoneInput = it },
        placeholder = {
            Text(
                text = "Phone",
                color = Color(0xffB8B8B8)
            )
        },

        modifier = Modifier

            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, top = 10.dp),
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

// Email Field
    Text(
        text = "Name ",
        color = Color(0xff121212),
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .padding(start = 20.dp, top = 20.dp)

    )
    OutlinedTextField(
        value = nameInput,
        onValueChange = { nameInput = it },
        placeholder = {
            Text(
                text = " Name",
                color = Color(0xffB8B8B8)
            )
        },

        modifier = Modifier

            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, top = 10.dp),
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
// Phone number field
    Text(
        text = "Governorate ",
        color = Color(0xff121212),
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .padding(start = 20.dp, top = 20.dp)

    )
    OutlinedTextField(
        value = phoneNumberInput,
        onValueChange = { phoneNumberInput = it },
        placeholder = {
            Text(
                text = " Governorate",
                color = Color(0xffB8B8B8)
            )
        },

        modifier = Modifier

            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, top = 10.dp),
        shape = RoundedCornerShape(10.dp),
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedContainerColor = Color(0xffF5F5F5),
            focusedContainerColor = Color(0xffF5F5F5),
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent
        ),
        singleLine = true,
        textStyle = TextStyle(
            color = Color.Black
        )

    )

// Phone number field
    Text(
        text = "City ",
        color = Color(0xff121212),
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .padding(start = 20.dp, top = 20.dp)

    )
    OutlinedTextField(
        value = phoneNumberInput,
        onValueChange = { phoneNumberInput = it },
        placeholder = {
            Text(
                text = " City",
                color = Color(0xffB8B8B8)
            )
        },

        modifier = Modifier

            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, top = 10.dp),
        shape = RoundedCornerShape(10.dp),
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedContainerColor = Color(0xffF5F5F5),
            focusedContainerColor = Color(0xffF5F5F5),
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent
        ),
        singleLine = true,
        textStyle = TextStyle(
            color = Color.Black
        )

    )

// Block
    Text(
        text = "Block ",
        color = Color(0xff121212),
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .padding(start = 20.dp, top = 20.dp)

    )
    OutlinedTextField(
        value = phoneNumberInput,
        onValueChange = { phoneNumberInput = it },
        placeholder = {
            Text(
                text = " Block",
                color = Color(0xffB8B8B8)
            )
        },

        modifier = Modifier

            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, top = 10.dp),
        shape = RoundedCornerShape(10.dp),
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedContainerColor = Color(0xffF5F5F5),
            focusedContainerColor = Color(0xffF5F5F5),
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent
        ),
        singleLine = true,
        textStyle = TextStyle(
            color = Color.Black
        )

    )

// Phone number field
    Text(
        text = "Street name /number ",
        color = Color(0xff121212),
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .padding(start = 20.dp, top = 20.dp)

    )
    OutlinedTextField(
        value = phoneNumberInput,
        onValueChange = { phoneNumberInput = it },
        placeholder = {
            Text(
                text = " Street name /number",
                color = Color(0xffB8B8B8)
            )
        },

        modifier = Modifier

            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, top = 10.dp),
        shape = RoundedCornerShape(10.dp),
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedContainerColor = Color(0xffF5F5F5),
            focusedContainerColor = Color(0xffF5F5F5),
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent
        ),
        singleLine = true,
        textStyle = TextStyle(
            color = Color.Black
        )

    )

// Building name /number
    Text(
        text = "Building name /number ",
        color = Color(0xff121212),
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .padding(start = 20.dp, top = 20.dp)

    )
    OutlinedTextField(
        value = phoneNumberInput,
        onValueChange = { phoneNumberInput = it },
        placeholder = {
            Text(
                text = " Building name /number",
                color = Color(0xffB8B8B8)
            )
        },

        modifier = Modifier

            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, top = 10.dp),
        shape = RoundedCornerShape(10.dp),
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedContainerColor = Color(0xffF5F5F5),
            focusedContainerColor = Color(0xffF5F5F5),
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent
        ),
        singleLine = true,
        textStyle = TextStyle(
            color = Color.Black
        )

    )

// Building name /number
    Text(
        text = "Floor (option) ",
        color = Color(0xff121212),
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .padding(start = 20.dp, top = 20.dp)

    )
    OutlinedTextField(
        value = phoneNumberInput,
        onValueChange = { phoneNumberInput = it },
        placeholder = {
            Text(
                text = " Floor (option)",
                color = Color(0xffB8B8B8)
            )
        },

        modifier = Modifier

            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, top = 10.dp),
        shape = RoundedCornerShape(10.dp),
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedContainerColor = Color(0xffF5F5F5),
            focusedContainerColor = Color(0xffF5F5F5),
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent
        ),
        singleLine = true,
        textStyle = TextStyle(
            color = Color.Black
        )
    )

// Building name /number
    Text(
        text = "Flat (option) ",
        color = Color(0xff121212),
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .padding(start = 20.dp, top = 20.dp)

    )
    OutlinedTextField(
        value = phoneNumberInput,
        onValueChange = { phoneNumberInput = it },
        placeholder = {
            Text(
                text = " Flat (option)",
                color = Color(0xffB8B8B8)
            )
        },

        modifier = Modifier

            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, top = 10.dp),
        shape = RoundedCornerShape(10.dp),
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedContainerColor = Color(0xffF5F5F5),
            focusedContainerColor = Color(0xffF5F5F5),
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent
        ),
        singleLine = true,
        textStyle = TextStyle(
            color = Color.Black
        )

    )

// Building name /number
    Text(
        text = "Avenue (option) ",
        color = Color(0xff121212),
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .padding(start = 20.dp, top = 20.dp)

    )
    OutlinedTextField(
        value = phoneNumberInput,
        onValueChange = { phoneNumberInput = it },
        placeholder = {
            Text(
                text = " Avenue (option)",
                color = Color(0xffB8B8B8)
            )
        },

        modifier = Modifier

            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, top = 10.dp),
        shape = RoundedCornerShape(10.dp),
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedContainerColor = Color(0xffF5F5F5),
            focusedContainerColor = Color(0xffF5F5F5),
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent
        ),
        singleLine = true,
        textStyle = TextStyle(
            color = Color.Black
        )

    )



}
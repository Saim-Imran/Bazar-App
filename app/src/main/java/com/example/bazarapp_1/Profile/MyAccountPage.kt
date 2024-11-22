package com.example.bazarapp_1.Profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.bazarapp_1.AuthViewModel
import com.example.bazarapp_1.R
import com.example.bazarapp_1.ui.theme.BazarApp_1Theme
import com.example.bazarapp_1.ui.theme.robotofontfamily

@Composable
fun MyAccountScreen(navController: NavHostController, authViewModel: AuthViewModel) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)) {
        TopBar(
            modifier = Modifier,
            navController = navController,
            authViewModel = AuthViewModel()
        )
        BodyFields()
        SaveButton()
    }
}

@Composable
fun TopBar(modifier: Modifier = Modifier,navController: NavHostController, authViewModel: AuthViewModel) {
    Column(
        modifier = modifier
            .padding(top = 20.dp, bottom = 0.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Row for Back Arrow and Title
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.arrow_left_outline),
                contentDescription = "Back",
                modifier = Modifier
                    .padding(end = 8.dp)
                    .clickable { navController.popBackStack()}
            )
            Text(
                text = "My Account",
                color = Color.Black,
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = robotofontfamily,
                modifier = Modifier.weight(1f)
            )
        }

        // Profile Picture
        Image(
            painter = painterResource(R.drawable.ellipse),
            contentDescription = "Profile",
            modifier = Modifier
                .padding(top = 20.dp)
                .size(120.dp)
        )


    Text(
            text = "Change Picture",
            color = Color(0xff54408C),
            fontSize = 16.sp,
            fontFamily = robotofontfamily,
            modifier = Modifier.padding(top = 6.dp)
        )
    }
}

@Composable
fun BodyFields(modifier: Modifier = Modifier) {
    var nameInput by remember { mutableStateOf("") }
    var emailInput by remember { mutableStateOf("") }
    var passwordInput by remember { mutableStateOf("") }
var phoneNumberInput by remember { mutableStateOf("") }
// for password visibility
    var passwordVisibility by remember { mutableStateOf(false) }
    var icon2 = if (passwordVisibility)
        painterResource(R.drawable.visibility_118485)
    else
        painterResource(R.drawable._3498)


//Name field
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
                text = " Your Email",
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
        text = "Email ",
        color = Color(0xff121212),
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .padding(start = 20.dp, top = 20.dp)

    )
    OutlinedTextField(
        value = emailInput,
        onValueChange = { emailInput = it },
        placeholder = {
            Text(
                text = " Your Email",
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
        text = "Phone Number ",
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
                text = " Your Email",
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
    //Password Field
    Text(
        text = "Password",
        color = Color(0xff121212),
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .padding(start = 20.dp, top = 15.dp)


    )
    OutlinedTextField(
        value = passwordInput,
        onValueChange = { passwordInput = it },

        trailingIcon = {
            IconButton(onClick = {
                passwordVisibility = !passwordVisibility
            }) {
                Image(
                    painter = icon2,
                    colorFilter = ColorFilter.tint(Color(0xffA6A6A6)),
                    contentDescription = "visibility Icon",
                    modifier = Modifier.size(20.dp)
                )
            }
        },
        visualTransformation = if (passwordVisibility) VisualTransformation.None
        else PasswordVisualTransformation(),


        placeholder = {
            Text(
                text = " Your password",
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

@Composable
fun SaveButton(modifier: Modifier = Modifier) {
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF54408C)
        ),
        shape = RoundedCornerShape(40.dp),
        onClick = {},
        modifier = Modifier
            .padding(start = 15.dp, end = 15.dp, top = 15.dp)
            .height(55.dp)

    ) {
        Text(
            text = "Save Changes",
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .fillMaxWidth(),
            //   .padding(start = 60.dp),
            textAlign = TextAlign.Center

        )
    }
}
@Preview
@Composable
fun MyPrev() {
    BazarApp_1Theme {
        MyAccountScreen(
            navController = rememberNavController(),
            authViewModel = AuthViewModel()
        )
    }
}
package com.example.bazarapp_1.Profile


import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
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
import coil.compose.rememberAsyncImagePainter
import com.example.bazarapp_1.AuthViewModel
import com.example.bazarapp_1.R
import com.example.bazarapp_1.ui.theme.BazarApp_1Theme
import com.example.bazarapp_1.ui.theme.robotofontfamily

@Composable
fun MyAccountScreen(navController: NavHostController, authViewModel: AuthViewModel) {
    var selectedImageUri by remember { mutableStateOf<Uri?>(null) }
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        if (uri != null) {
            selectedImageUri = uri
        }
    }

    // State for bottom sheet visibility
    var showConfirmationDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        TopBar(
            modifier = Modifier,
            navController = navController,
            authViewModel = authViewModel,
            selectedImageUri = selectedImageUri,
            onChangePictureClick = { launcher.launch("image/*") },
            onConfirmChangePicture = { showConfirmationDialog = true }
        )
        BodyFields()
        SaveButton()
    }

    // Confirmation dialog as a bottom sheet
    if (showConfirmationDialog) {
        ConfirmationBottomSheet(
            onConfirm = { showConfirmationDialog = false },
            onCancel = { showConfirmationDialog = false }
        )
    }
}

@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    authViewModel: AuthViewModel,
    selectedImageUri: Uri?,
    onChangePictureClick: () -> Unit,
    onConfirmChangePicture: () -> Unit
) {
    Column(
        modifier = modifier
            .padding(top = 20.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
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
                    .clickable { navController.popBackStack() }
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

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            // Display Profile Picture (rounded shape with consistent size)
            Image(
                painter = if (selectedImageUri != null) {
                    rememberAsyncImagePainter(selectedImageUri)
                } else {
                    painterResource(R.drawable.ellipse)
                },
                contentDescription = "Profile",
                modifier = Modifier
                    .padding(top = 20.dp)
                    .size(120.dp)
                    .background(Color.LightGray, shape = CircleShape)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )

            // Change Picture Button
            Text(
                text = "Change Picture",
                color = Color(0xff54408C),
                fontSize = 16.sp,
                fontFamily = robotofontfamily,
                modifier = Modifier
                    .padding(top = 6.dp)
                    .clickable { onChangePictureClick(); onConfirmChangePicture() }
            )
        }
    }
}

@Composable
fun ConfirmationBottomSheet(onConfirm: () -> Unit, onCancel: () -> Unit) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(16.dp),
        color = Color.White,
        tonalElevation = 4.dp
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Change Profile Picture?",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Are you sure you want to update your profile picture?",
                textAlign = TextAlign.Center,
                fontSize = 14.sp,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = { onConfirm() },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF54408C)),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(text = "Confirm", color = Color.White)
                }
                Button(
                    onClick = { onCancel() },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Gray),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(text = "Cancel", color = Color.White)
                }
            }
        }
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
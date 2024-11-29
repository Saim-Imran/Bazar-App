package com.example.bazarapp_1.signup


import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
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
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
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
import com.example.bazarapp_1.SignUpVerificationEmailPage
import com.example.bazarapp_1.common.Annotated
import com.example.bazarapp_1.common.HeaderTextSignPages1
import com.example.bazarapp_1.ui.theme.BazarApp_1Theme

@Composable
fun SignUPScreen1(navController: NavHostController, authViewModel: AuthViewModel) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .verticalScroll(rememberScrollState())
    ) {
        Column {
            Image(
                painter = painterResource(R.drawable.arrow_left_outline),
                contentDescription = "backward",
                modifier = Modifier
                    .padding(top = 20.dp, start = 20.dp)
                    .clickable {
                        navController.navigate(LoginPage)
                    }
            )
            // sign up text at top
            HeaderTextSignPages1(
                modifier = Modifier,
                text1 = "Sign Up",
                text2 = "Create account and choose favourite menu"
            )

            // main body fields like name signup and password
            SignUpFields2(
                navController = navController,
                authViewModel = AuthViewModel()
            )

            // Register Button
            RegisterButtonPage2(
                navController = navController,
                authViewModel = AuthViewModel()
            )

            // bottom text
            Annotated(
                modifier = Modifier
            )
        }
    }
}

@Composable
fun SignUpFields2(navController: NavHostController, authViewModel: AuthViewModel) {
    var nameInput by remember { mutableStateOf("") }
    var emailInput by remember { mutableStateOf("") }
    var passwordInput by remember { mutableStateOf("") }

// for password visibility
    var passwordVisibility by remember { mutableStateOf(false) }
    var icon2 = if (passwordVisibility)
        painterResource(R.drawable.visibility_118485)
    else
        painterResource(R.drawable._3498)

// launch effect
    val authState = authViewModel.authState.observeAsState()
    val context = LocalContext.current

    LaunchedEffect(authState.value) {
        when(authState.value){
            is AuthState.Authenticated -> navController.navigate(LoginPage)
            is AuthState.Error -> Toast.makeText(context,(authState.value as AuthState.Error).message,
                Toast.LENGTH_SHORT).show()
            else -> Unit
        }
    }



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

    PasswordValidation()

}

@Composable
fun PasswordValidation() {
    var passwordInput by remember { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }
    var hasStartedTyping by remember { mutableStateOf(false) }

    // Password validation checks as boolean values
    val isLongEnough = passwordInput.length >= 8
    val hasUppercase = passwordInput.any { it.isUpperCase() }
    val hasLowercase = passwordInput.any { it.isLowerCase() }
    val hasDigit = passwordInput.any { it.isDigit() }

    // Validation messages with conditions
    val validationChecks = listOf(
        "Password must be at least 8 characters long" to isLongEnough,
        "Password must contain at least one uppercase letter" to hasUppercase,
        "Password must contain at least one lowercase letter" to hasLowercase,
        "Password must contain at least one digit" to hasDigit
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        Text(
            text = "Password",
            color = Color(0xff121212),
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Password Text Field
        OutlinedTextField(
            value = passwordInput,
            onValueChange = {
                passwordInput = it
                hasStartedTyping = true
            },
            trailingIcon = {
                val icon: Painter = if (passwordVisibility) {
                    painterResource(R.drawable.visibility_118485)
                } else {
                    painterResource(R.drawable._3498)
                }
                IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                    Image(
                        painter = icon,
                        colorFilter = ColorFilter.tint(Color(0xffA6A6A6)),
                        contentDescription = "Visibility Icon",
                        modifier = Modifier.size(20.dp)
                    )
                }
            },
            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
            placeholder = { Text(text = "Your password", color = Color(0xffB8B8B8)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            shape = RoundedCornerShape(10.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = Color(0xffF5F5F5),
                focusedContainerColor = Color(0xffF5F5F5),
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            singleLine = true,
            textStyle = TextStyle(color = Color.Black)
        )

        // Display validation messages with icons only after typing has started
        if (hasStartedTyping) {
            Column(modifier = Modifier.padding(top = 8.dp)) {
                validationChecks.forEach { (message, condition) ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(start = 8.dp, top = 4.dp)
                    ) {
                        Icon(
                            imageVector = if (condition) Icons.Filled.Check else Icons.Filled.Close,
                            contentDescription = if (condition) "Check icon" else "Close icon",
                            tint = if (condition) Color.Green else Color.Red,
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp)) // Padding between icon and text
                        Text(
                            text = message,
                            color = if (condition) Color.Gray else Color.Red,
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun RegisterButtonPage2(navController: NavHostController, authViewModel: AuthViewModel) {
    var emailInput by remember { mutableStateOf("") }
    var passwordInput by remember { mutableStateOf("") }
    Column(modifier = Modifier.padding(top = 25.dp)) {

        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF54408C)
            ),
            shape = RoundedCornerShape(40.dp),
            onClick = { authViewModel.signup(emailInput , passwordInput  )},
            modifier = Modifier
                .padding(horizontal = 15.dp)
                .height(55.dp)

        ) {
            Text(
                text = "Register",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .fillMaxWidth(),
                //   .padding(start = 60.dp),
                textAlign = TextAlign.Center

            )
        }
        Row(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 20.dp)
        ) {

            Text(
                text = "Don't have an account",
                color = Color(0xffA6A6A6),
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                modifier = Modifier
                //.padding(start = 15.dp, top = 25.dp)
            )

            // Second Text (in a different color)
            Text(
                text = "Sign Up",
                color = Color(0xff54408C),
                fontSize = 20.sp,
                fontWeight = FontWeight.Normal,
                modifier = Modifier
                    //          .padding(top = 25.dp)
                    .clickable {
navController.navigate(SignUpVerificationEmailPage)
                    }
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun SignUp2Preview() {
    BazarApp_1Theme {
        SignUPScreen1(
            navController = rememberNavController(),
            authViewModel =AuthViewModel()
        )
    }
}
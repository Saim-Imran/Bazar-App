package com.example.bazarapp_1.signup

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.bazarapp_1.AuthState
import com.example.bazarapp_1.AuthViewModel
import com.example.bazarapp_1.HomePage
import com.example.bazarapp_1.MenuPage1
import com.example.bazarapp_1.R
import com.example.bazarapp_1.SignUpSuccessPage
import com.example.bazarapp_1.common.HeaderTextSignPages1
import com.example.bazarapp_1.ui.theme.BazarApp_1Theme
import com.example.bazarapp_1.ui.theme.robotofontfamily

@Composable
fun SignInScreen(
    navController: NavHostController,
    authViewModel: AuthViewModel,
    onGoogleSignInClick: () -> Unit,) {
    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
    ) {

        Column {
            Image(
                painter = painterResource(R.drawable.arrow_left_outline),
                contentDescription = "Zoom",
                modifier = Modifier
                    .padding(top = 20.dp, start = 20.dp)
                    .clickable { navController.popBackStack() }
            )

            //text welcome
            HeaderTextSignPages1(
                modifier = Modifier,
                text1 = "Welcome Back \uD83D\uDC4B",
                text2 = "Sign to your account"
            )

            // for Email and login
            LogInFields(
                modifier = Modifier,
                navController = navController,
                authViewModel = authViewModel,
            )
            //Login Button
            LoginButtonPage1(
                authViewModel = authViewModel,
                navController = navController,
            )
            // Also Login With
            OtherLoginWays(
                modifier = Modifier,
                navController = navController
            )
            // For android login
            LoginWithGoogle(
                modifier = Modifier,
                onGoogleSignInClick = onGoogleSignInClick
            )
            // for ios login
            LoginWithIOS()
        }

    }
}


@Composable
fun LogInFields(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    authViewModel: AuthViewModel
) {
    var emailInput by remember { mutableStateOf("") }
    var passwordInput by remember { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }
    val icon2 = if (passwordVisibility)
        painterResource(R.drawable.visibility_118485)
    else
        painterResource(R.drawable._3498)

    // Observe auth state
    val authState by authViewModel.authState.observeAsState()
    val context = LocalContext.current

    // Handle side-effects for authState
    LaunchedEffect(authState) {
        when (authState) {
            is AuthState.Authenticated -> {
                Log.i("TAG", "TAG LogInFields: ")
                navController.navigate(HomePage)
            }

            is AuthState.Error -> {
                val errorMessage = (authState as AuthState.Error).message
                Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show()
            }

            else -> Unit
        }
    }

    // UI for Email Input
    Text(
        text = "Email",
        color = Color(0xff121212),
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(start = 20.dp, top = 20.dp)
    )
    OutlinedTextField(
        value = emailInput,
        onValueChange = { emailInput = it },
        placeholder = { Text(text = "Your Email", color = Color(0xffB8B8B8)) },
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
        textStyle = TextStyle(color = Color.Black)
    )

    // UI for Password Input
    Text(
        text = "Password",
        color = Color(0xff121212),
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(start = 20.dp, top = 15.dp)
    )
    OutlinedTextField(
        value = passwordInput,
        onValueChange = { passwordInput = it },
        placeholder = { Text(text = "Your password", color = Color(0xffB8B8B8)) },
        trailingIcon = {
            IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                Image(
                    painter = icon2,
                    colorFilter = ColorFilter.tint(Color(0xffA6A6A6)),
                    contentDescription = "Toggle Password Visibility",
                    modifier = Modifier.size(20.dp)
                )
            }
        },
        visualTransformation = if (passwordVisibility) VisualTransformation.None
        else PasswordVisualTransformation(),
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
        textStyle = TextStyle(color = Color.Black)
    )

    // Forgot Password
    Text(
        text = "Forgot Password?",
        color = Color(0xff54408C),
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        modifier = Modifier.padding(top = 15.dp, start = 20.dp)
    )

    // Login Button
    Button(
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF54408C)),
        shape = RoundedCornerShape(40.dp),
        onClick = {
//            navController.navigate(SplashScreen1)
            authViewModel.login(emailInput, passwordInput)
        },
        modifier = Modifier
            .padding(start = 15.dp, end = 15.dp, top = 25.dp)
            .height(55.dp)
    ) {
        Text(
            text = "Login",
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }

    // Sign-up Navigation
    Row(
        modifier = Modifier
            //  .align(Alignment.CenterHorizontally)
            .padding(top = 20.dp)
    ) {
        Text(
            text = "Don't have an account",
            color = Color(0xffA6A6A6),
            fontSize = 16.sp
        )
        Text(
            text = "Sign Up",
            color = Color(0xff54408C),
            fontSize = 20.sp,
            modifier = Modifier.clickable {
               // navController.navigate(HomePage)
            }
        )
    }
}

@Composable
fun LoginButtonPage1(authViewModel: AuthViewModel, navController: NavController) {
    /* Column(modifier = Modifier.padding(top = 25.dp)) {

         Button(
             colors = ButtonDefaults.buttonColors(
                 containerColor = Color(0xFF54408C)
             ),
             shape = RoundedCornerShape(40.dp),
             onClick = {
               //  authViewModel.login(email, password  )

             },
             modifier = Modifier
                 .padding(horizontal = 15.dp)
                 .height(55.dp)

         ) {
             Text(
                 text = "Login",
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
 navController.navigate(SignupPage)
                     }
             )
         }
     }*/
}

@Composable
fun OtherLoginWays(modifier: Modifier = Modifier,navController: NavHostController,) {
    Row(
        modifier = Modifier
            .padding(top = 20.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.line),
            contentDescription = "Line",
            modifier = Modifier
                .width(150.dp)
                .padding(top = 10.dp)
        )
        Text(
            text = "Or with",
            color = Color(0xffA6A6A6),
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = robotofontfamily,
            modifier = Modifier
                .padding(start = 5.dp, end = 5.dp)
            //new nav
                .clickable {
                    navController.navigate(SignUpSuccessPage)
                }
        )
        Image(
            painter = painterResource(R.drawable.line),
            contentDescription = "Line",
            modifier = Modifier
                .padding(top = 10.dp)
        )
    }
}

@Composable
fun LoginWithGoogle(modifier: Modifier = Modifier,onGoogleSignInClick: () -> Unit,) {
    OutlinedButton(
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            /*(0xFFE8E8E8)*/

        ),
        shape = RoundedCornerShape(40.dp),
        border = BorderStroke(1.dp, Color(0xffE8E8E8)),
        onClick = {onGoogleSignInClick()},
        modifier = Modifier
            .padding(top = 20.dp, end = 15.dp, start = 15.dp)
            .height(55.dp)

    ) {
        Row(modifier = Modifier.align(Alignment.CenterVertically)) {

            Image(
                painter = painterResource(R.drawable.google___original),
                contentDescription = "Google",
                modifier = Modifier
                    .padding(start = 40.dp)
            )
            Text(
                text = "Sign in with Google",
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp),
                // textAlign = TextAlign.Center

            )
        }
    }
}

@Composable
fun LoginWithIOS(modifier: Modifier = Modifier) {
    OutlinedButton(
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            /*(0xFFE8E8E8)*/

        ),
        shape = RoundedCornerShape(40.dp),
        border = BorderStroke(1.dp, Color(0xffE8E8E8)),
        onClick = {

        },
        modifier = Modifier
            .padding(top = 20.dp, end = 15.dp, start = 15.dp)
            .height(55.dp)

    ) {
        Row(modifier = Modifier.align(Alignment.CenterVertically)) {

            Image(
                painter = painterResource(R.drawable.apple),
                contentDescription = "Google",
                modifier = Modifier
                    .padding(start = 40.dp)
            )
            Text(
                text = "Sign in with Apple",
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp),
                // textAlign = TextAlign.Center

            )
        }
    }
}
/*

@Preview(showBackground = true)
@Composable
fun Test2Preview() {
    BazarApp_1Theme {
        SignInScreen(
            navController = rememberNavController(),
            authViewModel = AuthViewModel(),
            onGoogleSignInClick = onGoogleSignInClick,
        )
    }
}*/

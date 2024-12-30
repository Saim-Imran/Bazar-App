package com.example.bazarapp_1.Profile

import android.app.Activity
import android.util.Log
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.example.bazarapp_1.AuthState
import com.example.bazarapp_1.AuthViewModel
import com.example.bazarapp_1.HelpCenterPage
import com.example.bazarapp_1.LoginPage
import com.example.bazarapp_1.MenuPage1
import com.example.bazarapp_1.MyAccountPage
import com.example.bazarapp_1.OfferPage
import com.example.bazarapp_1.OrderHistoryPage
import com.example.bazarapp_1.R
import com.example.bazarapp_1.SignupPage
import com.example.bazarapp_1.YourFavouritePage
import com.example.bazarapp_1.ui.theme.BazarApp_1Theme
import com.example.bazarapp_1.ui.theme.robotofontfamily
import kotlinx.coroutines.launch

@Composable
fun ProfileScreen(navController: NavHostController,authViewModel: AuthViewModel) {
    Log.e("Profile page", "Profile page successfully open ")
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Profile(
            modifier = Modifier,
            navController = navController,
            authViewModel = authViewModel
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Profile(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    authViewModel: AuthViewModel
) {
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val coroutineScope = rememberCoroutineScope()
    var isSheetOpen by remember { mutableStateOf(false) }

    val authState by authViewModel.authState.observeAsState()
    val userProfile by authViewModel.userProfile.observeAsState()

    LaunchedEffect(authState) {
        if (authState is AuthState.Unauthenticated) {
            navController.navigate(LoginPage)
        }
    }

    Column(modifier = Modifier.padding(top = 25.dp)) {
        // Header Text
        Text(
            text = "Profile",
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            fontFamily = robotofontfamily,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(start = 150.dp)
        )

        // Divider before the Row
        HorizontalDivider(
            color = Color.LightGray,
            thickness = 1.dp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp)
        )

        // The Row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, start = 20.dp, end = 20.dp)
        ) {
            // Dynamic User Image or First Letter
            ProfileImage(
                userImageUrl = userProfile?.profileImageUrl,
                userName = userProfile?.name ?: "Guest"
            )

            Column(
                modifier = Modifier.padding(start = 20.dp)
            ) {
                Text(
                    text = userProfile?.name ?: "User Name",
                    color = Color(0xff121212),
                    fontSize = 16.sp,
                    fontFamily = robotofontfamily,
                    fontWeight = FontWeight.Medium,
                )
                Text(
                    text = userProfile?.email ?: "user@example.com",
                    color = Color(0xffA6A6A6),
                    fontSize = 14.sp,
                    fontFamily = robotofontfamily,
                    fontWeight = FontWeight.Normal,
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "Logout",
                color = Color.Red,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = robotofontfamily,
                modifier = Modifier
                    .padding(top = 15.dp)
                    .clickable {
                        coroutineScope.launch { isSheetOpen = true }
                        Log.e("Profile page", "Open bottom sheet for signout")
                    }
            )
        }

        // Divider after the Row
        HorizontalDivider(
            color = Color.LightGray,
            thickness = 1.dp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        )

        // Profile body
        ProfileBody(
            navController = navController,
            authViewModel = authViewModel
        )

        // Bottom Sheet
        if (isSheetOpen) {
            ModalBottomSheet(
                containerColor = MaterialTheme.colorScheme.background,
                onDismissRequest = { isSheetOpen = false },
                sheetState = sheetState,
                shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
            ) {
                Column(
                    modifier = Modifier
                        .background(color = Color.White)
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "Logout?",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        text = "Are you sure you want to logout?",
                        fontSize = 14.sp,
                        color = Color.Gray,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        // Logout Button
                        Button(
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF54408C)
                            ),
                            shape = RoundedCornerShape(40.dp),
                            onClick = {
                                isSheetOpen = false
                                authViewModel.signout(
                                    activity = Activity(),
                                    navController = NavController(
                                        context = Activity()
                                    )
                                )
                                Log.e("Profile Page", "logout from the account ")
                            },
                            modifier = Modifier
                                .padding(start = 15.dp, end = 15.dp, top = 15.dp)
                                .height(55.dp)
                        ) {
                            Text(
                                text = "Logout",
                                color = Color.White,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center
                            )
                        }

                        // Cancel Button
                        Button(
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFFF9F6EE)
                            ),
                            shape = RoundedCornerShape(40.dp),
                            onClick = { isSheetOpen = false },
                            modifier = Modifier
                                .padding(start = 15.dp, end = 15.dp, top = 15.dp, bottom = 15.dp)
                                .height(55.dp)
                        ) {
                            Text(
                                text = "Cancel",
                                color = Color(0xFF54408C),
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ProfileImage(userImageUrl: String?, userName: String) {
    if (userImageUrl.isNullOrEmpty()) {
        // Display the first letter of the user's name
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .background(Color.Gray)
        ) {
            Text(
                text = userName.firstOrNull()?.toString() ?: "?",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
    } else {
        // Display the user's profile image
        Image(
            painter = rememberAsyncImagePainter(
                ImageRequest.Builder(LocalContext.current)
                    .data(userImageUrl)
                    .apply {
                        crossfade(true)
                        placeholder(R.drawable.profileimg)
                        error(R.drawable.profileimg)
                    }
                    .build()
            ),
            contentDescription = "User Profile Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
        )
    }
}



@Composable
fun ProfileBody(  navController:NavHostController,authViewModel: AuthViewModel) {

    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)
        .padding(top = 20.dp, start = 20.dp, end = 20.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.White)
        ) {

            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(color = Color(0xffF2F0EF)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.fire),
                    contentDescription = "Offers and promotions",
                )
            }
            Text(
                text = "My Account",
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = robotofontfamily,
                modifier = Modifier
                    .padding(top = 8.dp, start = 30.dp)
                    .weight(.9f)
            )
//        Spacer(modifier = Modifier.width(90.dp))
            Image(
                painter = painterResource(R.drawable.frwd),
                contentDescription = "frwd",
                modifier = Modifier
                    .clickable {
                        navController.navigate(
                            MyAccountPage
                        )
                    }
                    .size(30.dp)
                    .padding(start = 0.dp, top = 8.dp, end = 15.dp)

            )
        }

        Spacer(modifier = Modifier.height(25.dp))


//Address
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.White)
        ) {

            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(color = Color(0xffF2F0EF)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.location),
                    contentDescription = "profile",
                )
            }
            Text(
                text = "Address",
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = robotofontfamily,
                modifier = Modifier
                    .padding(top = 8.dp, start = 30.dp)
                    .weight(.9f)
            )

            Image(
                painter = painterResource(R.drawable.frwd),
                contentDescription = "frwd",
                modifier = Modifier
                    .size(30.dp)
                    .padding(start = 0.dp, top = 8.dp, end = 15.dp)
//                   .clickable { navController.navigate(MyAccountPage) }
            )
        }

        Spacer(modifier = Modifier.height(25.dp))
//Offers and promotions
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.White)
        ) {

            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(color = Color(0xffF2F0EF)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.fire),
                    contentDescription = "Offers and promotions",
                    modifier = Modifier
                        .clickable { navController.navigate(OfferPage) }
                )
            }
            Text(
                text = "Offers & Promotions",
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = robotofontfamily,
                modifier = Modifier
                    .padding(top = 8.dp, start = 30.dp)
                    .weight(.9f)
            )

            Image(
                painter = painterResource(R.drawable.frwd),
                contentDescription = "frwd",
                modifier = Modifier
                    .size(30.dp)
                    .padding(start = 0.dp, top = 8.dp, end = 15.dp)
                    .clickable { navController.navigate(OfferPage) }
            )
        }

        Spacer(modifier = Modifier.height(25.dp))
//Favourite
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.White)
        ) {

            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(color = Color(0xffF2F0EF)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.heart),
                    contentDescription = "Favourite",
                )
            }
            Text(
                text = "Favourite",
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = robotofontfamily,
                modifier = Modifier
                    .padding(top = 8.dp, start = 30.dp)
                    .weight(.9f)
            )

            Image(
                painter = painterResource(R.drawable.frwd),
                contentDescription = "frwd",
                modifier = Modifier
                    .size(30.dp)
                    .padding(start = 0.dp, top = 8.dp, end = 15.dp)
                    .clickable { navController.navigate(YourFavouritePage) }
            )
        }

        Spacer(modifier = Modifier.height(25.dp))
//Order History
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.White)
        ) {

            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(color = Color(0xffF2F0EF)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.document),
                    contentDescription = "Order History",
                )
            }
            Text(
                text = "Order History",
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = robotofontfamily,
                modifier = Modifier
                    .padding(top = 8.dp, start = 30.dp)
                    .weight(.9f)
            )

            Image(
                painter = painterResource(R.drawable.frwd),
                contentDescription = "frwd",
                modifier = Modifier
                    .size(30.dp)
                    .padding(start = 0.dp, top = 8.dp, end = 15.dp)
                    .clickable { navController.navigate(OrderHistoryPage) }
            )
        }

        Spacer(modifier = Modifier.height(25.dp))
//Help Center
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.White)
        ) {

            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(color = Color(0xffF2F0EF)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.chat),
                    contentDescription = "Help Center",
                )
            }
            Text(
                text = "Help Center",
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = robotofontfamily,
                modifier = Modifier
                    .padding(top = 8.dp, start = 30.dp)
                    .weight(.9f)
            )

            Image(
                painter = painterResource(R.drawable.frwd),
                contentDescription = "frwd",
                modifier = Modifier
                    .size(30.dp)
                    .padding(start = 0.dp, top = 8.dp, end = 15.dp)
                    .clickable { navController.navigate(HelpCenterPage) }
            )
        }

    }
}

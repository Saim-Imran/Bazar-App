package com.example.bazarapp_1

import android.os.Bundle
import android.view.Menu
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bazarapp_1.Category.MenuScreen
import com.example.bazarapp_1.Category.MenuSearchScreen
import com.example.bazarapp_1.ForgetPassword.ForgetPasswordScreen
import com.example.bazarapp_1.ForgetPassword.ForgetPasswordVerificationPNScreen
import com.example.bazarapp_1.ForgetPassword.ForgetPasswordWithEmailScreen
import com.example.bazarapp_1.ForgetPassword.ForgetPasswordWithPhoneScreen
import com.example.bazarapp_1.ForgetPassword.SetNewPasswordScreen
import com.example.bazarapp_1.ForgetPassword.SuccessfullyPasswordChangedScreen
import com.example.bazarapp_1.Notification.DetailNewsPromoScreen
import com.example.bazarapp_1.Notification.NewsPromoScreen
import com.example.bazarapp_1.Notification.NotificationDeliveryScreen
import com.example.bazarapp_1.Profile.HelpCenterScreen
import com.example.bazarapp_1.Profile.MyAccountScreen
import com.example.bazarapp_1.Profile.OfferScreen
import com.example.bazarapp_1.Profile.OrderHistoryScreen
import com.example.bazarapp_1.Profile.ProfileScreen
import com.example.bazarapp_1.Profile.YourFavouriteScreen
import com.example.bazarapp_1.SuccessOrder.SuccessOrderReceivingScreen
import com.example.bazarapp_1.SuccessOrder.SuccessOrderWaitingScreen
import com.example.bazarapp_1.onBoarding.OnBoardingScreen1
import com.example.bazarapp_1.signup.BoxTest


import com.example.bazarapp_1.signup.SignInScreen
import com.example.bazarapp_1.signup.SignUPScreen_2
import com.example.bazarapp_1.signup.SignUpInputPNScreen
import com.example.bazarapp_1.signup.SignUpSuccessScreen
import com.example.bazarapp_1.signup.SignUpVerificationEmailScreen
import com.example.bazarapp_1.signup.SignUpVerificationPhoneNumberScreen


import com.example.bazarapp_1.ui.theme.BazarApp_1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
val authViewModel :AuthViewModel by viewModels()
        setContent {
            BazarApp_1Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.surface
                ) {
                    //  SplashScreen()
                 //   OnBoardingScreen1()
                 //  SignInScreen()
                   // Test1()
                //    SignUPPage1()
              //      SignUPScreen_2()
                 //   SignInScreen()
//SignUpSuccessScreen()
                  //  SignUpVerificationEmailScreen()
                //   PhoneNumberTextFieldTest()
//SignUpInputPNScreen()
                //    SignUpVerificationPhoneNumberScreen()
       //    ForgetPasswordScreen()
              //  SelectPasswordResetOption()
                //    ForgetPasswordWithEmailScreen()
//ForgetPasswordWithPhoneScreen()
//ForgetPasswordVerificationPNScreen()
//                    SetNewPasswordScreen()
//                    SuccessfullyPasswordChangedScreen()
//MenuScreen()
//                    MenuScreen1()
//BottomNavigation()
//                    SearchView()
//MenuSearchScreen()
//SuccessOrderWaitingScreen()
//SuccessOrderReceivingScreen()
//SuccessBox()
//ProfileScreen()
//ProfileBody()
//MyAccountScreen()
//YourFavouriteScreen()
//OrderHistoryScreen()
//HelpCenterScreen()
//OfferScreen()
//BoxTest()
//NotificationDeliveryScreen()
//                    NewsPromoScreen()
//DetailNewsPromoScreen()
                Navigation(
                    modifier = Modifier,
                    authViewModel = authViewModel
                )
                }
            }
        }
    }
}



/*

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BazarApp_1Theme {
        Greeting("Android")
    }
}*/

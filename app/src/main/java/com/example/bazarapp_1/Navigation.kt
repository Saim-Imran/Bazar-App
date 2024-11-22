package com.example.bazarapp_1

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bazarapp_1.Category.MenuScreen
import com.example.bazarapp_1.ForgetPassword.ForgetPasswordScreen
import com.example.bazarapp_1.ForgetPassword.ForgetPasswordWithEmailScreen
import com.example.bazarapp_1.ForgetPassword.ForgetPasswordWithPhoneScreen
import com.example.bazarapp_1.Profile.HelpCenterScreen
import com.example.bazarapp_1.Profile.MyAccountScreen
import com.example.bazarapp_1.Profile.OfferScreen
import com.example.bazarapp_1.Profile.OrderHistoryScreen
import com.example.bazarapp_1.Profile.ProfileScreen
import com.example.bazarapp_1.Profile.YourFavouriteScreen
import com.example.bazarapp_1.onBoarding.OnBoardingScreen1
import com.example.bazarapp_1.onBoarding.OnBoardingScreen2
import com.example.bazarapp_1.onBoarding.OnBoardingScreen3
import com.example.bazarapp_1.onBoarding.PagerScreen
import com.example.bazarapp_1.onBoarding.SplashScreen
import com.example.bazarapp_1.signup.SignInScreen
import com.example.bazarapp_1.signup.SignUPScreen1
import com.example.bazarapp_1.signup.SignUpSuccessScreen
import kotlinx.serialization.Serializable

@Composable
fun Navigation(modifier: Modifier = Modifier, authViewModel: AuthViewModel) {
    val navController = rememberNavController()
//    val navController = NavHostController(navHostController)
//    navController.setGraph(navGraph) // Ensure this is called before getGraph()
//    val navGraph = navController.createGraph()
    NavHost(
        navController = navController,
        startDestination = PagerScreen
    ) {
        composable<SplashScreen1> {
            SplashScreen(navController)
        }
        composable<PagerScreen> {
            PagerScreen(navController = navController)
        }
        composable<OnBoardingPage1> {
            OnBoardingScreen1(navController)
        }
        composable<OnBoardingPage2> {
            OnBoardingScreen2(navController)
        }
        composable<OnBoardingPage3> {
            OnBoardingScreen3(navController)
        }
        // for signup and sign in
        composable<LoginPage> {
            SignInScreen(
                navController,
                authViewModel = authViewModel
            )
        }
        composable<SignupPage> {
            SignUPScreen1(
                navController,
                authViewModel = authViewModel
            )
        }
        composable<MenuPage1> {
            MenuScreen(
                navController,
                authViewModel = authViewModel
            )
        }
// new nav
        composable<SignUpSuccessPage> {
            SignUpSuccessScreen(

                authViewModel = authViewModel,
                navController = navController
            )
        }

        composable<ForgetPasswordPage> {
            ForgetPasswordScreen(

                authViewModel = authViewModel,
                navController = navController
            )
        }

        composable<ForgetPasswordEmailPage> {
            ForgetPasswordWithEmailScreen(

                authViewModel = authViewModel,
                navController = navController
            )
        }

        composable<ForgetPasswordPNPage> {
            ForgetPasswordWithPhoneScreen(

                authViewModel = authViewModel,
                navController = navController
            )
        }
//new
        composable<ProfilePage> {
            ProfileScreen(
                authViewModel = authViewModel,
                navController = navController

            )
        }

        composable<YourFavouritePage> {
            YourFavouriteScreen(
                authViewModel = authViewModel,
                navController = navController
            )
        }

        composable<OrderHistoryPage> {
            OrderHistoryScreen(
                authViewModel = authViewModel,
                navController = navController
            )
        }

        composable<OfferPage> {
            OfferScreen(
                authViewModel = authViewModel,
                navController = navController
            )
        }

        composable<MyAccountPage> {
            MyAccountScreen(
                authViewModel = authViewModel,
                navController = navController
            )
        }

        composable<HelpCenterPage> {
            HelpCenterScreen(
                authViewModel = authViewModel,
                navController = navController
            )
        }
    }

}

@Serializable
object SplashScreen1

@Serializable
object PagerScreen

@Serializable
object OnBoardingPage1

@Serializable
object OnBoardingPage2

@Serializable
object OnBoardingPage3

@Serializable
object LoginPage

@Serializable
object SignupPage

@Serializable
object MenuPage1

@Serializable
object SignUpSuccessPage

@Serializable
object ForgetPasswordPage

@Serializable
object ForgetPasswordEmailPage

@Serializable
object ForgetPasswordPNPage

@Serializable
object ProfilePage

@Serializable
object YourFavouritePage

@Serializable
object OrderHistoryPage

@Serializable
object OfferPage

@Serializable
object MyAccountPage

@Serializable
object HelpCenterPage


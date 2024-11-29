package com.example.bazarapp_1

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bazarapp_1.Cart.ConfirmOrderDeliveryDateScreen
import com.example.bazarapp_1.Cart.ConfirmOrderEmptyCartScreen
import com.example.bazarapp_1.Cart.ConfirmOrderEmptyNotificationScreen
import com.example.bazarapp_1.Cart.ConfirmOrderLocationScreen
import com.example.bazarapp_1.Cart.ConfirmOrderPaymentDetailScreen
import com.example.bazarapp_1.Cart.ConfirmOrderPaymentMethodScreen
import com.example.bazarapp_1.Cart.ConfirmOrderScreen
import com.example.bazarapp_1.Category.MenuScreen
import com.example.bazarapp_1.Category.MenuSearchScreen
import com.example.bazarapp_1.ForgetPassword.ForgetPasswordScreen
import com.example.bazarapp_1.ForgetPassword.ForgetPasswordWithEmailScreen
import com.example.bazarapp_1.ForgetPassword.ForgetPasswordWithPhoneScreen
import com.example.bazarapp_1.Home.AuthorInnerScreen
import com.example.bazarapp_1.Home.AuthorsScreen
import com.example.bazarapp_1.Home.BottomNavigationScreen
import com.example.bazarapp_1.Home.DetailMenuScreen
import com.example.bazarapp_1.Home.HomeScreen
import com.example.bazarapp_1.Home.HomeScreenNew
import com.example.bazarapp_1.Home.VendorsScreen
import com.example.bazarapp_1.Notification.DetailNewsPromoScreen
import com.example.bazarapp_1.Notification.NewsPromoScreen
import com.example.bazarapp_1.Notification.NotificationDeliveryScreen
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
fun Navigation(
    modifier: Modifier = Modifier,
    authViewModel: AuthViewModel,
    onGoogleSignInClick: () -> Unit
) {
    val navController = rememberNavController()

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
        // Login Screen with Google Sign-In
        composable<LoginPage> {
            SignInScreen(
                navController = navController,
                authViewModel = authViewModel,
                onGoogleSignInClick = onGoogleSignInClick // Pass the click handler here
            )
        }
        composable<SignupPage> {
            SignUPScreen1(
                navController = navController,
                authViewModel = authViewModel
            )
        }
        composable<MenuPage1> {
            MenuScreen(
                navController = navController,
                authViewModel = authViewModel
            )
        }
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

        composable<HomePage> {
            HomeScreenNew(

                navController = navController
            )
        }

        composable<VenderPage> {
            VendorsScreen(

                navController = navController
            )
        }

        composable<AuthorPage> {
            AuthorsScreen(
//                authViewModel = authViewModel,
                navController = navController
            )
        }

        composable<AuthorInnerPage> {
            AuthorInnerScreen(
//                authViewModel = authViewModel,
                navController = navController
            )
        }

        composable<DetailPage> {
            DetailMenuScreen(
//                authViewModel = authViewModel,
                navController = navController
            )
        }
        composable<BottomNaviPage> {
            BottomNavigationScreen(
//                authViewModel = authViewModel,
                navController = navController
            )
        }
        composable<MenuSearchPage> {
            MenuSearchScreen(
//                authViewModel = authViewModel,
                navController = navController
            )
        }
        composable<NotificationDeliveryPage> {
            NotificationDeliveryScreen(
//                authViewModel = authViewModel,
                navController = navController
            )
        }
        composable<NewsPromoPage> {
            NewsPromoScreen(
//                authViewModel = authViewModel,
                navController = navController
            )
        }
        composable<DetailNewsPage> {
            DetailNewsPromoScreen(
//                authViewModel = authViewModel,
                navController = navController
            )
        }
        //card
        composable<ConfirmOrderPage> {
            ConfirmOrderScreen(
//                authViewModel = authViewModel,
                navController = navController
            )
        }

        composable<ConfirmOrderPaymentDetailPage> {
            ConfirmOrderPaymentDetailScreen(
//                authViewModel = authViewModel,
                navController = navController
            )
        }

        composable<ConfirmOrderPaymentMethodPage> {
            ConfirmOrderPaymentMethodScreen(
//                authViewModel = authViewModel,
                navController = navController
            )
        }

        composable<ConfirmOrderDeliveryDatePage> {
            ConfirmOrderDeliveryDateScreen(
//                authViewModel = authViewModel,
                navController = navController
            )
        }

        composable<ConfirmOrderLocationPage> {
            ConfirmOrderLocationScreen(
//                authViewModel = authViewModel,
                navController = navController
            )
        }

        composable<ConfirmOrderEmptyCardPage> {
            ConfirmOrderEmptyCartScreen(
//                authViewModel = authViewModel,
                navController = navController
            )
        }

        composable<ConfirmOrderEmptyNotificationPage> {
            ConfirmOrderEmptyNotificationScreen(
//                authViewModel = authViewModel,
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

@Serializable
object HomePage

@Serializable
object VenderPage

@Serializable
object AuthorPage

@Serializable
object AuthorInnerPage

@Serializable
object DetailPage

@Serializable
object BottomNaviPage

@Serializable
object MenuSearchPage

@Serializable
object NotificationDeliveryPage

@Serializable
object NewsPromoPage

@Serializable
object DetailNewsPage

@Serializable
object ConfirmOrderPage

@Serializable
object ConfirmOrderPaymentDetailPage

@Serializable
object ConfirmOrderPaymentMethodPage

@Serializable
object ConfirmOrderDeliveryDatePage

@Serializable
object ConfirmOrderLocationPage

@Serializable
object ConfirmOrderEmptyCardPage

@Serializable
object ConfirmOrderEmptyNotificationPage


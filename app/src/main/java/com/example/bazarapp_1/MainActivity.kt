package com.example.bazarapp_1

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.bazarapp_1.Cart.ConfirmOrderDeliveryDateScreen
import com.example.bazarapp_1.Cart.ConfirmOrderEmptyCartScreen
import com.example.bazarapp_1.Cart.ConfirmOrderEmptyNotificationScreen
import com.example.bazarapp_1.Cart.ConfirmOrderLocationScreen
import com.example.bazarapp_1.Cart.ConfirmOrderPaymentDetailScreen

import com.example.bazarapp_1.Cart.ConfirmOrderPaymentMethodScreen
import com.example.bazarapp_1.Cart.ConfirmOrderScreen
import com.example.bazarapp_1.Home.AuthorInnerScreen
import com.example.bazarapp_1.Home.AuthorsScreen
import com.example.bazarapp_1.Home.DetailMenuScreen
import com.example.bazarapp_1.Home.HomeScreen
import com.example.bazarapp_1.Home.HomeScreenNew
import com.example.bazarapp_1.Home.VendorsScreen
import com.example.bazarapp_1.Profile.MyAccountScreen
import com.example.bazarapp_1.ui.theme.BazarApp_1Theme
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.tasks.Task


class MainActivity : ComponentActivity() {
    private val authViewModel: AuthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        authViewModel.initializeGoogleSignIn(this)


        val googleSignInLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->

            if (result.resultCode == RESULT_OK) {
                Log.i("TAG", "firebaseAuthWithGoogle: $result")
                val task: Task<GoogleSignInAccount> =
                    GoogleSignIn.getSignedInAccountFromIntent(result.data)
                authViewModel.handleGoogleSignInResult(task)
            }
        }

        setContent {
            BazarApp_1Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.surface
                ) {
                    // Pass Navigation with Google Sign-In handler
//ConfirmOrderScreen()
//ConfirmOrderPaymentDetailScreen()
//                    ConfirmOrderPaymentMethodScreen()
//ConfirmOrderDeliveryDateScreen()
//ConfirmOrderLocationScreen()
//ConfirmOrderEmptyCartScreen()
//ConfirmOrderEmptyNotificationScreen()
/*MyAccountScreen(
    navController = rememberNavController(),
    authViewModel = AuthViewModel()
)*/

                     Navigation(
                        modifier = Modifier,
                        authViewModel = authViewModel
                    ) { googleSignInLauncher.launch(authViewModel.getGoogleSignInIntent()) }
                }
            }
        }
    }
}

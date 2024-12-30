package com.example.bazarapp_1

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.userProfileChangeRequest

class AuthViewModel : ViewModel() {
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    private val _authState = MutableLiveData<AuthState>()
    val authState: LiveData<AuthState> = _authState

    private val _userProfile = MutableLiveData<UserProfile?>()
    val userProfile: LiveData<UserProfile?> = _userProfile

    lateinit var googleSignInClient: GoogleSignInClient

    init {
        checkAuthStatus()
    }

    // Check current authentication status
    fun checkAuthStatus() {
        val currentUser = auth.currentUser
        if (currentUser != null) {
            _authState.value = AuthState.Authenticated
            _userProfile.value = UserProfile(
                name = currentUser.displayName ?: "Anonymous",
                email = currentUser.email ?: "No email",
                profileImageUrl = currentUser.photoUrl?.toString() ?: ""
            )
        } else {
            _authState.value = AuthState.Unauthenticated
            _userProfile.value = null
        }
    }

    // Validate email format
    private fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    // Validate password format (minimum 6 characters as an example)
    private fun isValidPassword(password: String): Boolean {
        return password.length >= 6
    }

    // Login with email and password
    fun login(email: String, password: String) {
        if (email.isEmpty() || password.isEmpty()) {
            _authState.value = AuthState.Error("Email and password can't be empty")
            return
        }
        if (!isValidEmail(email)) {
            _authState.value = AuthState.Error("Invalid email format")
            return
        }
        _authState.value = AuthState.Loading
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    checkAuthStatus()
                } else {
                    val errorMessage = task.exception?.message ?: "Login failed"
                    Log.e("LOGIN_ERROR", errorMessage)
                    _authState.value = AuthState.Error(errorMessage)
                }
            }
    }

    // Signup with email and password
    fun signup(email: String, password: String) {
        if (email.isEmpty() || password.isEmpty()) {
            _authState.value = AuthState.Error("Email and password can't be empty")
            return
        }
        if (!isValidEmail(email)) {
            _authState.value = AuthState.Error("Invalid email format")
            return
        }
        if (!isValidPassword(password)) {
            _authState.value = AuthState.Error("Password must be at least 6 characters")
            return
        }
        _authState.value = AuthState.Loading
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Send email verification
                    auth.currentUser?.sendEmailVerification()?.addOnCompleteListener { verifyTask ->
                        if (verifyTask.isSuccessful) {
                            checkAuthStatus()
                        } else {
                            val errorMessage = verifyTask.exception?.message ?: "Verification email failed"
                            Log.e("SIGNUP_ERROR", errorMessage)
                            _authState.value = AuthState.Error(errorMessage)
                        }
                    }
                } else {
                    val errorMessage = task.exception?.message ?: "Signup failed"
                    Log.e("SIGNUP_ERROR", errorMessage)
                    _authState.value = AuthState.Error(errorMessage)
                }
            }
    }

    // Sign out
    fun signout(activity: Activity, navController: NavController) {
        if (::googleSignInClient.isInitialized) {
            googleSignInClient.signOut().addOnCompleteListener {
                auth.signOut()
                _authState.value = AuthState.Unauthenticated
                _userProfile.value = null
                Log.e("TAG", "Signout success")
            }
        } else {
            auth.signOut()
            _authState.value = AuthState.Unauthenticated
            _userProfile.value = null
        }
    }

    // Initialize Google Sign-In
    fun initializeGoogleSignIn(context: Context) {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(context.getString(R.string.web_client_id))
            .requestEmail()
            .build()
        googleSignInClient = GoogleSignIn.getClient(context, gso)
    }

    // Get Google Sign-In Intent
    fun getGoogleSignInIntent(): Intent {
        return googleSignInClient.signInIntent
    }

    // Handle Google Sign-In result
    fun handleGoogleSignInResult(task: Task<GoogleSignInAccount>) {
        try {
            val account = task.getResult(Exception::class.java)
            if (account != null) {
                firebaseAuthWithGoogle(account)
            } else {
                _authState.value = AuthState.Error("Google Sign-In failed")
            }
        } catch (e: Exception) {
            Log.e("GOOGLE_SIGNIN_ERROR", e.stackTraceToString())
            _authState.value = AuthState.Error(e.message ?: "Google Sign-In failed")
        }
    }

    // Authenticate with Firebase using Google credentials
    private fun firebaseAuthWithGoogle(account: GoogleSignInAccount) {
        val credential = GoogleAuthProvider.getCredential(account.idToken, null)
        _authState.value = AuthState.Loading
        auth.signInWithCredential(credential)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    checkAuthStatus()
                } else {
                    val errorMessage = task.exception?.message ?: "Google Authentication failed"
                    Log.e("GOOGLE_AUTH_ERROR", errorMessage)
                    _authState.value = AuthState.Error(errorMessage)
                }
            }
    }
}

// Authentication state sealed class
sealed class AuthState {
    object Authenticated : AuthState()
    object Unauthenticated : AuthState()
    object Loading : AuthState()
    data class Error(val message: String) : AuthState()
}

// User profile data class
data class UserProfile(
    val name: String,
    val email: String,
    val profileImageUrl: String
)

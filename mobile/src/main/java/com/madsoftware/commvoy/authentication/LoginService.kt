package com.madsoftware.commvoy.authentication

import android.app.Activity
import android.support.design.widget.Snackbar
import android.util.Log
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider




class LoginService {
    private val tag : String = "AUTHENTICATION"

    private val mAuth : FirebaseAuth = FirebaseAuth.getInstance()

    fun isUserAuthenticated (): Boolean {
        var currentUser = mAuth.currentUser
        if(currentUser != null) {
            return true
        }
        return false
    }

    fun signupNewUser(email : String, password : String) : Task<AuthResult> {
        return mAuth.createUserWithEmailAndPassword(email, password)
    }

    fun signoutUser() {
        mAuth.signOut()
    }

    fun buildGoogleSignInOptions(clientId: String) : GoogleSignInOptions {
        return GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(clientId)
                .requestEmail()
                .build()
    }

    fun signInWithGoogle(acct: GoogleSignInAccount, activity: Activity) {
        val credential : AuthCredential = GoogleAuthProvider.getCredential(acct.idToken, null)
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(activity, OnCompleteListener<AuthResult> {
                    if(it.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d("Login", "signInWithCredential:success")
                        val user = mAuth.currentUser
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w("Login", "signInWithCredential:failure", it.exception)
                    }
                })
    }
}
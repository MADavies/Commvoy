package com.madsoftware.commvoy.authentication

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.madsoftware.commvoy.profile.ProfileActivity
import android.support.v4.app.ActivityCompat.startActivityForResult
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient


class LoginController(val activity: Activity) {
    private val tag : String = "Authentication"

    private val loginService : LoginService = LoginService()
    private val firebaseCompletionListener = OnCompleteListener<AuthResult> {
        if(it.isSuccessful) {
            Log.d(tag, "Created User With Email : " + it.result.user.email)
            Toast.makeText(activity, "Authentication Successful Welcome to Commvoy",
                    Toast.LENGTH_SHORT).show()

            val intent = Intent(activity, ProfileActivity::class.java)
            activity.startActivity(intent)
            activity.finish()
        } else {
            Log.w(tag, "Failed to create user reason: " + it.exception!!.message)
            it.exception!!.printStackTrace()


            Toast.makeText(activity, "There was an issue whilst trying to Authenticate you account",
                    Toast.LENGTH_SHORT).show()
        }
    }


    /**
     * checks to see if there is already a user associated or if the user needs an account creating
     */
    fun signIn(email : String, password : String) {
        if(loginService.isUserAuthenticated()) {
            Toast.makeText(activity, "There is already an account associated with this email address",
                    Toast.LENGTH_SHORT).show()

            val intent = Intent(activity, ProfileActivity::class.java)
            activity.startActivity(intent)
            activity.finish()
        } else {
            var authTask = loginService.signupNewUser(email, password)
            authTask.addOnCompleteListener(firebaseCompletionListener)
        }
    }

    fun googleSignIn(context: Context, gso: GoogleSignInOptions) : Intent {
        return Intent()
    }

    fun getSignInOptions(clientId: String) : GoogleSignInOptions {
        return loginService.buildGoogleSignInOptions(clientId)
    }

    fun facebookSignIn() {

    }

    fun signUserOut() {
        loginService.signoutUser()
    }
}
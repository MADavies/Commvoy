package com.madsoftware.commvoy.authentication

import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth



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
}
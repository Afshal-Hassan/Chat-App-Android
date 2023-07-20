package com.example.chatapp


import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import com.example.chatapp.constants.AppConstants
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task


class Login : AppCompatActivity() {

    private lateinit var googleSignInOptions: GoogleSignInOptions;
    private lateinit var googleSignInClient: GoogleSignInClient;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login);
        onClickGoogleSignInButton();
    }


    override fun onResume() {
        super.onResume();
        AppConstants.RESUME_COUNT = AppConstants.RESUME_COUNT + 1;

        if (AppConstants.RESUME_COUNT >= 2) {
            AppConstants.RESUME_COUNT = 0;
            finish();
        } else {
            onClickGoogleSignInButton();
        }
    }


    private fun onClickGoogleSignInButton() {
        val account = GoogleSignIn.getLastSignedInAccount(this);
        if (account != null) {
            navigateToDashboard();
        }


        val googleSignInButton = findViewById<LinearLayout>(R.id.signInWithGoogleButton);
        googleSignInButton.setClickListenerForStartProcessingGoogleSignInAuth(::startProcessingOfGoogleAuthentication);

    }


    private fun LinearLayout.setClickListenerForStartProcessingGoogleSignInAuth(navigateFunction: () -> Unit) {
        setOnClickListener {
            navigateFunction.invoke()
        }
    }


    private fun startProcessingOfGoogleAuthentication() {
        googleSignInOptions =
            GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        googleSignInClient = GoogleSignIn.getClient(this, googleSignInOptions);
        val googleSignInIntent = googleSignInClient.signInIntent;
        startActivityForResult(googleSignInIntent, 1000);
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1000) {
            var task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleGoogleSignInResult(task);
        }
    }


    private fun handleGoogleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            completedTask.getResult(ApiException::class.java);
            navigateToDashboard();
            // Signed in successfully, you can now use the 'account' to access user information
            // For example: account.id, account.displayName, account.email, etc.
        } catch (e: ApiException) {
            // Sign-in failed, handle the error
            Log.e(TAG, "Sign-in failed: ${e.statusCode}")
        }
    }


    private fun navigateToDashboard(): Unit {
        val dashboardIntent = Intent(this, Dashboard::class.java);
        startActivity(dashboardIntent);
    }
}
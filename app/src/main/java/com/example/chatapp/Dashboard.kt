package com.example.chatapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.viewModels
import com.example.chatapp.factory.UserViewModelFactory
import com.example.chatapp.fragments.User
import com.example.chatapp.permissions.ContactPermissions
import com.example.chatapp.repos.UserRepo
import com.example.chatapp.services.ContactService
import com.example.chatapp.viewmodels.UserViewModel

class Dashboard : AppCompatActivity() {

    private val contactService: ContactService = ContactService()
    private val userViewModel: UserViewModel by viewModels { UserViewModelFactory(UserRepo()) }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)


        val contacts = contactService.getContactListOfUser(this, this)
        userViewModel.refreshUserData()
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        val isPermissionGranted = ContactPermissions.onRequestPermissionResult(this, grantResults, requestCode)
        if(isPermissionGranted) {
            contactService.getContactListOfUser(this,this)
        } else {
            Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show()

        }
    }


    @Deprecated("Deprecated")
    override fun onBackPressed() {

        val rootLayout = findViewById<LinearLayout>(R.id.roomLayout)

        // Load the exit animation
        val exitAnimation = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right)

        // Apply the animation to your activity's root layout (assuming your root layout has an ID of "rootLayout")
        rootLayout.startAnimation(exitAnimation)

        // Set a delay before finishing the activity to allow the animation to complete
        exitAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {}

            override fun onAnimationEnd(animation: Animation?) {
                // Finish the activity after the animation is complete
                finish()
                // If you want to close the app completely, you can use System.exit(0)
                // System.exit(0)
            }

            override fun onAnimationRepeat(animation: Animation?) {}
        })
    }
}
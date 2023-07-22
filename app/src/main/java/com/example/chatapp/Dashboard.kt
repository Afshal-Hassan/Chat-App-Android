package com.example.chatapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.LinearLayout

class Dashboard : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
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
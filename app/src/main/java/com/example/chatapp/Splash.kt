package com.example.chatapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import com.blogspot.atifsoftwares.animatoolib.Animatoo


class Splash : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        openSplashScreen()
    }


    private fun openSplashScreen() {
        val mainActivityIntent = Intent(this@Splash, Dashboard::class.java)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(mainActivityIntent)
            Animatoo.animateSlideLeft(this)
            finish()
        }, 3000)
    }
}
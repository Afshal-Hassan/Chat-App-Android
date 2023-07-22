package com.example.chatapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler


class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val mainActivityIntent = Intent(this@Splash,Dashboard::class.java)

        Handler().postDelayed({
            startActivity(mainActivityIntent)
        }, 4000)
    }
}
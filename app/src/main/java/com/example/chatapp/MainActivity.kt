package com.example.chatapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        onClickLetStartButton();
    }


    private fun onClickLetStartButton() {
        val letStartButton = findViewById<Button>(R.id.letsStartedButton)
        letStartButton.setClickListenerWithNavigation(::navigateToLogin)
    }


    private fun Button.setClickListenerWithNavigation(navigateFunction: () -> Unit) {
        setOnClickListener {
            navigateFunction.invoke()
        }
    }


    private fun navigateToLogin(): Unit {
        val loginIntent = Intent(this, Login::class.java);
        startActivity(loginIntent);
    }
}
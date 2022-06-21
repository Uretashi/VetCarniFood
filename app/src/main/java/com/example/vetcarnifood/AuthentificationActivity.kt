package com.example.vetcarnifood

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*
import kotlin.concurrent.schedule

class AuthentificationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentification)

        redirectToMain()
    }

    private fun redirectToMain() {
        Timer("goingTo", false).schedule(3000) {
            val intent = Intent(this@AuthentificationActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
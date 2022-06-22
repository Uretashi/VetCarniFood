package com.example.vetcarnifood

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import com.example.vetcarnifood.ui.login.LoginViewModel
import java.util.*
import kotlin.concurrent.schedule
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.vetcarnifood.ui.login.LoginViewModelFactory

class AuthentificationActivity : AppCompatActivity(R.layout.activity_authentification) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val model = ViewModelProvider(this, LoginViewModelFactory()).get(LoginViewModel::class.java)
        model.isConnected.observe(this) {
            if (it) {
                redirectToMain()
            }
        }
    }

    private fun redirectToMain() {
        Timer("goingTo", false).schedule(1000) {
            val intent = Intent(this@AuthentificationActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
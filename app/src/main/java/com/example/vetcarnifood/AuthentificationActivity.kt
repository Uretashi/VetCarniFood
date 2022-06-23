package com.example.vetcarnifood

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.vetcarnifood.auth.ui.login.LoginViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.vetcarnifood.auth.ui.login.LoginFragment
import com.example.vetcarnifood.auth.ui.login.LoginViewModelFactory
import com.example.vetcarnifood.auth.ui.login.RegisterFragment

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

    override fun onResumeFragments() {
        super.onResumeFragments()
        val loginFragment = supportFragmentManager.findFragmentById(R.id.login_container)
        if(loginFragment is LoginFragment) {
            loginFragment.getRegisterButton()?.setOnClickListener {
                val fragmentManager = supportFragmentManager.beginTransaction()
                fragmentManager.replace(R.id.login_container, RegisterFragment.newInstance()).commit()
            }
        }
    }

    private fun redirectToMain() {
        val intent = Intent(this@AuthentificationActivity, BarcodeActivity::class.java)
        startActivity(intent)
        finish()
    }
}
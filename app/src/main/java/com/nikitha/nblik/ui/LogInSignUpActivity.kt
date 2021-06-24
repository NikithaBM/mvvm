package com.nikitha.nblik.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.nikitha.nblik.R

class LogInSignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login_signup)
        val btnLogin = findViewById<Button>(R.id.btnLoginEmail)
        val btnSignUp = findViewById<Button>(R.id.btnSignUp)

        btnLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        btnSignUp.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }
    }

    public fun onTermsClick(v: View)
    {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.nblik.com/Terms_Condition"))
        startActivity(browserIntent)
    }
}

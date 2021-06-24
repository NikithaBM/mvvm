package com.nikitha.nblik.ui

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.nikitha.nblik.R
import com.nikitha.nblik.viewmodel.AuthViewModel


class LoginActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val etEmail = findViewById<EditText>(R.id.etEmail)
        val password = findViewById<EditText>(R.id.password)
        val btnLoginEmail = findViewById<Button>(R.id.btnLoginEmail)

       /* val viewModel = ViewModelProvider(this).get(AuthViewModel::class.java)

        btnLoginEmail.setOnClickListener {
            viewModel.login(etEmail.toString(), password.toString())
        }*/

    }

}

package com.nikitha.nblik.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nikitha.nblik.R

class SignUpActivity :AppCompatActivity(){
    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
    }

}

package com.nikitha.nblik.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.nikitha.nblik.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnContinue = findViewById<Button>(R.id.btnContinue);
        btnContinue.setOnClickListener {

            if(isFirstTime()) {
                val intent1 = Intent(this@MainActivity, OnBoardingActivity::class.java)
                startActivity(intent1)
                finish()
            }
            else
            {
                val intent2 = Intent(this@MainActivity, LogInSignUpActivity::class.java)
                startActivity(intent2)
                finish()
            }
        }
    }

    private fun isFirstTime():Boolean {
        val preferences = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
        val FirstTime = preferences.getString("FirstTimeInstall", "Yes")
        return FirstTime == "Yes"
    }
}
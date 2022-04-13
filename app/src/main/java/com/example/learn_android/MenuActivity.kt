package com.example.learn_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
    }

    fun moveToPenentuGenerasi(view: View) {
        startActivity(Intent(this, MainActivity::class.java))
    }

    fun moveToKalkulator(view: View) {
        startActivity(Intent(this, KalkulatorActivity::class.java))
    }
}
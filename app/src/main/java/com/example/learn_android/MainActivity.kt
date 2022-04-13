package com.example.learn_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inisialisasi komponen nya
        val edTanggalLahir = findViewById<EditText>(R.id.ed_tanggal_lahir)
        val btnKlik = findViewById<Button>(R.id.btn_klik)
        val tvHasil = findViewById<TextView>(R.id.tv_hasil)

        // logic
        btnKlik.setOnClickListener {
            val input = edTanggalLahir.text.toString()
            val hasil = when(input.toInt()){
                in 1946..1964 -> "Baby Boomers"
                in 1965..1980 -> "X"
                in 1981..2025 -> "Generasi Koplo"
                else -> "Tidak diakui"
             }

            tvHasil.text = "Kami generasi $hasil"
        }
    }

    fun moveToMenu(view: View) {
        startActivity(Intent(this, MenuActivity::class.java))
    }
}
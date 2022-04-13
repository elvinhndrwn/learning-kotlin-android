package com.example.learn_android

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class KalkulatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kalkulator)

        // Inisialisasi Variabel
        val angka1 = findViewById<EditText>(R.id.ed_angka1)
        val angka2 = findViewById<EditText>(R.id.ed_angka2)
        val hasil = findViewById<TextView>(R.id.tv_hasil_kalkulator)
        val cekResult = findViewById<Button>(R.id.btn_hitung)

        // Set value dropdown operasi
        val spinner : Spinner = findViewById(R.id.dropdown_operasi)
        ArrayAdapter.createFromResource(
            this,
            R.array.dropdown_operasi,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

        class SpinnerActivity : Activity(), AdapterView.OnItemSelectedListener {

            override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {
                // An item was selected. You can retrieve the selected item using
                parent.getItemAtPosition(pos)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Another interface callback
            }
        }

        cekResult.setOnClickListener {
            val res: Int = when(spinner.selectedItem.toString()){
                in "*" -> angka1.text.toString().toInt()*angka2.text.toString().toInt()
                in "/" -> angka1.text.toString().toInt()/angka2.text.toString().toInt()
                in "+" -> angka1.text.toString().toInt()+angka2.text.toString().toInt()
                in "-" -> angka1.text.toString().toInt()-angka2.text.toString().toInt()
                else -> 0
            }

            hasil.text = "Result: $res"
        }
    }

}
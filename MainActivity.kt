package com.example.baitap14023

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val inputText = findViewById<EditText>(R.id.inputText)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val btnEncode = findViewById<Button>(R.id.btnEncode)
        val resultText = findViewById<TextView>(R.id.resultText)

        btnEncode.setOnClickListener {
            val originalText = inputText.text.toString()

            val result = when (radioGroup.checkedRadioButtonId) {
                R.id.radioUpper -> originalText.uppercase()
                R.id.radioLower -> originalText.lowercase()
                R.id.radioReverse -> originalText.reversed()
                else -> "Vui lòng chọn kiểu mã hóa!"
            }

            resultText.text = result
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
package com.example.baitap14023

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val edtA = findViewById<EditText>(R.id.edtA)
        val edtB = findViewById<EditText>(R.id.edtB)
        val edtC = findViewById<EditText>(R.id.edtC)
        val btnSolve = findViewById<Button>(R.id.btnSolve)
        val txtResult = findViewById<TextView>(R.id.txtResult)

        btnSolve.setOnClickListener {
            try {
                val a = edtA.text.toString().toDouble()
                val b = edtB.text.toString().toDouble()
                val c = edtC.text.toString().toDouble()

                if (a == 0.0) {
                    txtResult.text = if (b != 0.0) {
                        "Phương trình bậc nhất: x = ${-c / b}"
                    } else {
                        if (c == 0.0) "Phương trình vô số nghiệm" else "Phương trình vô nghiệm"
                    }
                } else {
                    val delta = b * b - 4 * a * c
                    val result = when {
                        delta < 0 -> "Phương trình vô nghiệm"
                        delta == 0.0 -> {
                            val x = -b / (2 * a)
                            "Phương trình có nghiệm kép: x = $x"
                        }
                        else -> {
                            val x1 = (-b + sqrt(delta)) / (2 * a)
                            val x2 = (-b - sqrt(delta)) / (2 * a)
                            "Phương trình có 2 nghiệm:\nx₁ = $x1\nx₂ = $x2"
                        }
                    }
                    txtResult.text = result
                }
            } catch (e: Exception) {
                txtResult.text = "Vui lòng nhập đầy đủ và đúng định dạng số!"
            }
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
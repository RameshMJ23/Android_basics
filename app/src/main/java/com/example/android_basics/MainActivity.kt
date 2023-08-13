package com.example.android_basics

import android.os.Bundle
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_checkbox_radiobutton.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkbox_radiobutton)

        btnOrder.setOnClickListener{

            val meatSelected = findViewById<RadioButton>(rgMeat.checkedRadioButtonId)
                .text.toString()

            val finalOrder = "You ordered: \n" +
                    "$meatSelected \n" +
                    (if(cbCheese.isChecked) "Su cheese\n" else "") +
                    (if(cbOnion.isChecked) "Su Onion\n" else "") +
                    (if(cbSalad.isChecked) "Su Salad\n" else "")

            tvFinalOrder.text = finalOrder
        }
    }
}
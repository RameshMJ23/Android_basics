package com.example.android_basics

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        //With individual values
        /*val personName = intent.getStringExtra("EXTRA_NAME")

        val personAge = intent.getIntExtra("EXTRA_AGE", 0)

        val personCountry = intent.getStringExtra("EXTRA_COUNTRY")*/

        val personDetails = intent.getSerializableExtra("EXTRA_DETAILS") as Person

        saTextView.text = personDetails.toString()

        saBtnBack.setOnClickListener{
            finish()
        }

    }
}
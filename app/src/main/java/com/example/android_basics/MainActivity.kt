package com.example.android_basics

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main_first_screen.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_first_screen)

        firstScBtn.setOnClickListener{

            val name = etName.text.toString()

            val age = etAge.text.toString().toInt()

            val country = etCountry.text.toString()

            val personDetails = Person(name, age, country)

            Intent(this, SecondActivity::class.java).also {

                //With individual values
                /*it.putExtra("EXTRA_NAME", name)

                it.putExtra("EXTRA_AGE", age)

                it.putExtra("EXTRA_COUNTRY", country)*/

                //With data classes
                it.putExtra("EXTRA_DETAILS", personDetails)

                startActivity(it)
            }

        }
    }
}
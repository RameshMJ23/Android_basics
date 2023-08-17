package com.example.android_basics

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_toast.*
import kotlinx.android.synthetic.main.custom_toast.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toast)

        //Simple toast
        /*btnToast.setOnClickListener{
            Toast.makeText(this, "Simple toast!", Toast.LENGTH_SHORT).show()
        }*/

        btnToast.setOnClickListener{
            Toast(applicationContext).apply {
                duration = Toast.LENGTH_SHORT
                view = layoutInflater.inflate(R.layout.custom_toast, clToast)

                show()
            }
        }
    }
}
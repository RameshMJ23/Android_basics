package com.example.android_basics

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_bar_menu, menu)
        return true;
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.miAlarm -> Toast.makeText(this, "Alarm clicked", Toast.LENGTH_SHORT).show()
            R.id.miAddContact -> Toast.makeText(this, "Add contact clicked", Toast.LENGTH_SHORT).show()
            R.id.miTakePhoto -> Toast.makeText(this, "Took photo", Toast.LENGTH_SHORT).show()
            R.id.miClose -> finish()
        }
        return true
    }


}
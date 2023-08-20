package com.example.android_basics

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_alert_dialogues.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alert_dialogues)

        val options = arrayOf("Morn", "Noon", "Night")

        val normalDialog = AlertDialog.Builder(this)
            .setTitle("Add Alarm")
            .setIcon(R.drawable.ic_alarm)
            .setMessage("Do you want to set Alarm")
            .setPositiveButton("Yes"){dialogInterface, i ->
                Toast.makeText(this, "Alarm created", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("no"){dialogInterface, i ->
                Toast.makeText(this, "Alarm not created", Toast.LENGTH_SHORT).show()
            }.create()

        val radioDialog = AlertDialog.Builder(this)
            .setTitle("Select period")
            .setIcon(R.drawable.ic_alarm)
            .setSingleChoiceItems(options, 0){dialogInterface, i ->
                Toast.makeText(this, "${options[i]} is selected", Toast.LENGTH_SHORT).show()
            }
            .setPositiveButton("Yes"){dialogInterface, i ->
                Toast.makeText(this, "Alarm created", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("no"){dialogInterface, i ->
                Toast.makeText(this, "Alarm not created", Toast.LENGTH_SHORT).show()
            }.create()

        val multipleOptionDialog = AlertDialog.Builder(this)
            .setTitle("Select periods")
            .setIcon(R.drawable.ic_alarm)
            .setMultiChoiceItems(options, booleanArrayOf(true, true, false)){ dialogInterface, i, isChecked->
                if(isChecked){
                    Toast.makeText(this, "${options[i]} is checked", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "${options[i]} is unchecked", Toast.LENGTH_SHORT).show()
                }
            }
            .setPositiveButton("Yes"){dialogInterface, i ->
                Toast.makeText(this, "Alarm created", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("no"){dialogInterface, i ->
                Toast.makeText(this, "Alarm not created", Toast.LENGTH_SHORT).show()
            }.create()

        btnNormalDialog.setOnClickListener{
            normalDialog.show()
        }

        btnCheckDialog.setOnClickListener{
            multipleOptionDialog.show()
        }

        btnRadioDialog.setOnClickListener{
            radioDialog.show()
        }
    }

}
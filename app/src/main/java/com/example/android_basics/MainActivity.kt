package com.example.android_basics

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main_permissions.*

class MainActivity : AppCompatActivity() {

    lateinit var permissionLauncher: ActivityResultLauncher<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_permissions)


        permissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()){
            permissions -> Log.d("MainActivityPermissions", permissions.toString())
        }

        btnPermissions.setOnClickListener{
            requestPermissions()
        }

        ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_BACKGROUND_LOCATION)

    }

    private fun checkFgLocationPermission() = ContextCompat.checkSelfPermission(
        applicationContext,
        Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED

    private fun checkStoragePermission() = ContextCompat.checkSelfPermission(
        applicationContext,
        Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED

    private fun checkBgLocationPermission() = ContextCompat.checkSelfPermission(
        applicationContext,
        Manifest.permission.ACCESS_BACKGROUND_LOCATION) == PackageManager.PERMISSION_GRANTED


    private fun requestPermissions(){

        val permissionArray = mutableListOf<String>()

        /*if(!checkFgLocationPermission()){
           permissionArray.add(Manifest.permission.ACCESS_COARSE_LOCATION)
        }
        if(!checkBgLocationPermission()){
           permissionArray.add(Manifest.permission.ACCESS_BACKGROUND_LOCATION)
        }*/

        if(!checkStoragePermission()){
           permissionArray.add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        }

        if(permissionArray.isNotEmpty()){
            Log.d("MainActivityPermissions", "Permission array is not empty")
            //ActivityCompat.requestPermissions(this,permissionArray.toTypedArray(), 0)

            permissionLauncher.launch(permissionArray[0])
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        for(i in grantResults.indices){

            if(grantResults[i] == PackageManager.PERMISSION_GRANTED){
                Log.d("MainActivityPermissions", "Permission granted for ${permissions[i]}, with $requestCode")
            }
        }
    }

}
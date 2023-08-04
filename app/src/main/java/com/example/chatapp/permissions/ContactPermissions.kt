package com.example.chatapp.permissions

import android.content.Context
import android.content.pm.PackageManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.chatapp.constants.ContactConstants

class ContactPermissions {


    companion object {


        fun isPermissionGranted(context: Context, permission: String): Boolean {
            return (ContextCompat.checkSelfPermission(
                context,
                permission
            ) == PackageManager.PERMISSION_GRANTED)
        }


        fun askForPermission(
            appCompatActivity: AppCompatActivity,
            permissions: Array<String>,
            requestCode: Int
        ) {
            ActivityCompat.requestPermissions(
                appCompatActivity, permissions,
                requestCode
            )
        }


        fun onRequestPermissionResult(
            context: Context,
            grantResults: IntArray,
            requestCode: Int
        ): Boolean {
            when (requestCode) {
                ContactConstants.readContactPermissionRequest() -> {
                    if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                        return true
                    } else {
                        Toast.makeText(context, "Permission Denied", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            return false
        }


    }
}
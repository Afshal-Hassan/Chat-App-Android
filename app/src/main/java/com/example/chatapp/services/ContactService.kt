package com.example.chatapp.services

import android.content.Context
 import android.provider.ContactsContract
 import androidx.appcompat.app.AppCompatActivity
import com.example.chatapp.constants.ContactConstants
import com.example.chatapp.permissions.ContactPermissions


class ContactService {


    fun getContactListOfUser(
        appCompatActivity: AppCompatActivity,
        context: Context
    ): ArrayList<String> {
        if (ContactPermissions.isPermissionGranted(
                context,
                android.Manifest.permission.READ_CONTACTS
            )
        ) {
            return fetchAllContactsFromUserPhone(context)
        } else {
            ContactPermissions.askForPermission(
                appCompatActivity,
                arrayOf(android.Manifest.permission.READ_CONTACTS),
                ContactConstants.readContactPermissionRequest()
            )
        }
        return ArrayList()
    }


    private fun fetchAllContactsFromUserPhone(context: Context): ArrayList<String> {
        val contactsList = ArrayList<String>()
        val projection: Array<String> = arrayOf(
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
            ContactsContract.CommonDataKinds.Phone.NUMBER
        )

        val cursor = context.contentResolver.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            projection,
            null,
            null,
            null
        )

        cursor?.use {
            val nameIndex = it.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)
            val numberIndex = it.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)

            while (it.moveToNext()) {
                val name = it.getString(nameIndex)
                val number = it.getString(numberIndex)
                val contactInfo = "$name: $number"
                contactsList.add(contactInfo)
            }
        }

        return contactsList

    }
}
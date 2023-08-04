package com.example.chatapp.constants

class ContactConstants {


    companion object {


        private const val READ_CONTACTS_PERMISSION_REQUEST_CONSTANT = 1


        fun readContactPermissionRequest(): Int {
            return READ_CONTACTS_PERMISSION_REQUEST_CONSTANT
        }


    }

}
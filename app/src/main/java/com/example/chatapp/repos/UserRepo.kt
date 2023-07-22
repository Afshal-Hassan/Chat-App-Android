package com.example.chatapp.repos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.chatapp.pojos.UserData

class UserRepo {

    private val mutableUserData = MutableLiveData<UserData>()

    val userData: LiveData<UserData>
        get() = this.mutableUserData


    fun getUserData() {
        val data = UserData("Selina Gomez");
        mutableUserData.postValue(data)
    }
}
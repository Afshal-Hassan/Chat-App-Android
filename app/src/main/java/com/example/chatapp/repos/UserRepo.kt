package com.example.chatapp.repos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.chatapp.pojos.UserData


class UserRepo {

    private val mutableUserData = MutableLiveData<List<UserData>>()

    val userData: LiveData<List<UserData>>
        get() = this.mutableUserData


    fun getUserData() {
        val data = UserData("Testfar")
        val data1 = UserData("Tester tester")
        val data2 = UserData("Tester tester")
        val currentList = mutableUserData.value ?: emptyList()
        val updatedList = currentList.toMutableList()
        updatedList.add(data)
        updatedList.add(data1)
        updatedList.add(data2)


        mutableUserData.postValue(updatedList)

    }
}
package com.example.chatapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.chatapp.pojos.UserData
import com.example.chatapp.repos.UserRepo

class UserViewModel(private val repository: UserRepo) : ViewModel() {

    val userData: LiveData<List<UserData>>
        get() = repository.userData

    init {
        repository.getUserData()
    }


    fun refreshUserData() {
        repository.getUserData();
    }
}
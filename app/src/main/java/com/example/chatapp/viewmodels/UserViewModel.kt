package com.example.chatapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.chatapp.pojos.UserData
import com.example.chatapp.repos.UserRepo

class UserViewModel(private val repository: UserRepo) : ViewModel() {

    val userData: LiveData<UserData>
        get() = repository.userData

    init {
        repository.getUserData("Selina Gomez")
    }


    fun refreshUserData() {
        repository.getUserData("Tester tester");
    }
}
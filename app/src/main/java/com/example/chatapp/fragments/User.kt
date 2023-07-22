package com.example.chatapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.chatapp.R
import com.example.chatapp.databinding.FragmentUserBinding
import com.example.chatapp.factory.UserViewModelFactory
import com.example.chatapp.repos.UserRepo
import com.example.chatapp.viewmodels.UserViewModel


class User : Fragment() {

    private lateinit var binding: FragmentUserBinding
    private lateinit var userViewModel: UserViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = prepareView(inflater, container)
        val userViewModel = prepareUserViewModel()


        binding.userViewModel = userViewModel
        binding.lifecycleOwner = this


        return view
    }


    private fun prepareView(inflater: LayoutInflater, container: ViewGroup?): View {
        binding = FragmentUserBinding.inflate(inflater, container, false)
        return binding.root
    }


    private fun prepareUserViewModel(): UserViewModel {
        val userRepository = UserRepo()
        return ViewModelProvider(
            this,
            UserViewModelFactory(userRepository)
        ).get(UserViewModel::class.java)
    }


}
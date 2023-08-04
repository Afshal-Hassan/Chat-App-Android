package com.example.chatapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.example.chatapp.R
import com.example.chatapp.databinding.FragmentUserBinding
import com.example.chatapp.factory.UserViewModelFactory
import com.example.chatapp.repos.UserRepo
import com.example.chatapp.viewmodels.UserViewModel


class User : Fragment() {

    private lateinit var binding: FragmentUserBinding


    companion object {
        private const val NAME = "arg_name"

        fun newInstance(name: String): User {
            val fragment = User()
            val args = Bundle()
            args.putString(NAME, name)
            fragment.arguments = args
            return fragment
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val name = arguments?.getString(NAME) ?: ""
        binding.name = name
        binding.executePendingBindings()
    }


    private fun prepareView(inflater: LayoutInflater, container: ViewGroup?): View {
        binding = FragmentUserBinding.inflate(inflater, container, false)
        return binding.root
    }


    fun prepareUserViewModel() {
        val userRepo: UserRepo by lazy { UserRepo() }
        val userViewModel: UserViewModel by activityViewModels { UserViewModelFactory(userRepo) }
//        binding.userViewModel = userViewModel
    }


}
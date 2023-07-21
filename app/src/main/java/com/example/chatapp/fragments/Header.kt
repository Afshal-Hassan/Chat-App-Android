package com.example.chatapp.fragments

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.chatapp.R


class Header : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_header, container, false)
        setChatHeaderButtonByDefault(view)
        onSelectHeaderButton(view)
        return view
    }


    private fun onSelectHeaderButton(view: View) {
        val chatHeaderButton = view.findViewById<TextView>(R.id.chatHeaderButton)
        val callHeaderButton = view.findViewById<TextView>(R.id.callHeaderButton)
        val statusHeaderButton = view.findViewById<TextView>(R.id.statusHeaderButton)


        chatHeaderButton.setOnClickListener {
            callHeaderButton.isSelected = false
            statusHeaderButton.isSelected = false
            chatHeaderButton.isSelected = true
        }


        callHeaderButton.setOnClickListener {
            chatHeaderButton.isSelected = false
            statusHeaderButton.isSelected = false
            callHeaderButton.isSelected = true
        }


        statusHeaderButton.setOnClickListener {
            chatHeaderButton.isSelected = false
            callHeaderButton.isSelected = false
            statusHeaderButton.isSelected = true
        }
    }


    private fun setChatHeaderButtonByDefault(view: View) {
        val chatHeaderButton = view.findViewById<TextView>(R.id.chatHeaderButton)
        chatHeaderButton.isSelected = true
    }


}
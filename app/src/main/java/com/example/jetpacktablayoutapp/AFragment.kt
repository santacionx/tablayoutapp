package com.example.jetpacktablayoutapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class AFragment : Fragment() {

    private var userName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            userName = it.getString("USER_NAME")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_a, container, false)

        // Use userName in your fragment
        // For example, set it to a TextView
        val userNameTextView: TextView = view.findViewById(R.id.userNameTextView)
        userNameTextView.text = "Hello, $userName"

        return view
    }


}

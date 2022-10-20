package com.example.flashcart

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.flashcart.databinding.FragmentWelcomeBinding


class WelcomeFragment : Fragment() {
    private lateinit var binding:FragmentWelcomeBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View{
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_welcome, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.nextImg.setOnClickListener {
            findNavController().navigate(R.id.action_welcomeFragment_to_connectCartToPhoneFragment)
        }
    }
}
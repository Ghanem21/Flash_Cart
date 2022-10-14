package com.example.flashcart

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.flashcart.databinding.FragmentSummaryBinding
import com.example.flashcart.databinding.FragmentWelcomeBinding

class SummaryFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding =  DataBindingUtil.inflate<FragmentSummaryBinding>(inflater,R.layout.fragment_summary, container, false)
        return binding.root
    }
}
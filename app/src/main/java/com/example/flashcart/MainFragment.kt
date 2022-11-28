package com.example.flashcart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.flashcart.databinding.FragmentMainBinding


class MainFragment : Fragment() {
    private lateinit var binding:FragmentMainBinding
    private lateinit var navController:NavController
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_main, container, false)
        val navHostFragment =
            childFragmentManager.findFragmentById(R.id.second_nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            navController.navigate(item.itemId)
            return@setOnItemSelectedListener true
        }
        return binding.root
    }
}
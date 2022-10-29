package com.example.flashcart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.flashcart.databinding.CheckoutFragmentBinding

class CheckoutFragment : Fragment() {
    private lateinit var binding: CheckoutFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.checkout_fragment,container,false)
        binding.apply {
            fragment = this@CheckoutFragment
        }
        return binding.root
    }
    fun logout(){
        findNavController().navigate(R.id.action_checkoutFragment_to_welcomeFragment)
    }
    fun viewReceipt(){
        findNavController().navigate(R.id.action_checkoutFragment_to_summaryFragment)
    }
}
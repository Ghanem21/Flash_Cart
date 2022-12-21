package com.example.flashcart

import android.app.Dialog
import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.flashcart.databinding.FragmentMainBinding
import com.example.flashcart.enteredProduct.EnteredProductAdapter
import com.example.flashcart.recommended.ProductsRecommended
import com.google.android.material.dialog.MaterialAlertDialogBuilder


class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private lateinit var navController: NavController
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        val navHostFragment =
            childFragmentManager.findFragmentById(R.id.second_nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            navController.navigate(item.itemId)
            return@setOnItemSelectedListener true
        }

        binding.checkoutButton.setOnClickListener {
            val dialog = MaterialAlertDialogBuilder(requireContext(),R.style.CheckoutDialogTheme)
                .setView(layoutInflater.inflate(R.layout.dialog_checkout, null))
                .setNegativeButton(getString(R.string.cancel)) { dialog, _ ->
                    dialog.dismiss()
                }
                .setPositiveButton(getString(R.string.checkout)) { _, _ ->
                    findNavController().navigate(R.id.action_mainFragment_to_checkoutFragment)
                }
                .show()

            dialog.getButton(Dialog.BUTTON_NEGATIVE).setTextSize(TypedValue.COMPLEX_UNIT_SP, 21.0f)
            dialog.getButton(Dialog.BUTTON_POSITIVE).setTextSize(TypedValue.COMPLEX_UNIT_SP, 21.0f)

        }

        binding.addItemButton.setOnClickListener {
            val dialog = MaterialAlertDialogBuilder(requireContext(),R.style.CheckoutDialogTheme)
                .setView(R.layout.add_item_dialog)
                .setNegativeButton(getString(R.string.cancel)) { dialog, _ ->
                    dialog.dismiss()
                }
                .setPositiveButton(getString(R.string.add_item)) { _, _ ->

                }.show()

            dialog.getButton(Dialog.BUTTON_NEGATIVE).setTextSize(TypedValue.COMPLEX_UNIT_SP, 21.0f)
            dialog.getButton(Dialog.BUTTON_POSITIVE).setTextSize(TypedValue.COMPLEX_UNIT_SP, 21.0f)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val productAdapter = EnteredProductAdapter()
        ProductsRecommended.productsList?.let {
            productAdapter.submitList(ProductsRecommended.productsList!!)
        }
        binding.productsRecyclerView.adapter = productAdapter
    }
}
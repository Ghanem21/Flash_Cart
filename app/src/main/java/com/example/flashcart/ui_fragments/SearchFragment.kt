package com.example.flashcart.ui_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.flashcart.R
import com.example.flashcart.ui_fragments.adapters_and_data.ProductsAdapter
import com.example.flashcart.ui_fragments.adapters_and_data.ProductsObjects

class SearchFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_products_details, container, false)
        setupRecyclerView(view)
        return view
    }

    private fun setupRecyclerView(view: View?) {
        val context = requireContext()
        val productAdapter = ProductsAdapter(ProductsObjects.productsList!!)

        val recyclerView = view?.findViewById<RecyclerView>(R.id.products_details_recycler_view)
        recyclerView?.adapter = productAdapter
        recyclerView?.setHasFixedSize(true)

        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = RecyclerView.VERTICAL
        recyclerView?.layoutManager = layoutManager
    }

}
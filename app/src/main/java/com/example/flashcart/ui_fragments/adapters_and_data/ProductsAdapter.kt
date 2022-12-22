package com.example.flashcart.ui_fragments.adapters_and_data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.flashcart.databinding.ProductsDetailsItemListBinding

class ProductsAdapter (var productsList : ArrayList<ProductsData>) : RecyclerView.Adapter<ProductsAdapter.ProductsViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        return ProductsViewHolder(ProductsDetailsItemListBinding.inflate(LayoutInflater.from(parent.context), parent , false))
    }

    override fun onBindViewHolder(productsViewHolder: ProductsViewHolder, position: Int) {
        val product = productsList[position]
        productsViewHolder.onBind(product, position)
    }

    override fun getItemCount(): Int = productsList.size

    inner class ProductsViewHolder(val binding: ProductsDetailsItemListBinding) : RecyclerView.ViewHolder(binding.root) , View.OnClickListener {

        private var currentPosition : Int = -1
        private var currentProduct : ProductsData? = null


        fun onBind(product: ProductsData, position: Int){
            binding.product = product

            this.currentProduct = product
            this.currentPosition = position

        }

        override fun onClick(v: View?) {

        }

    }

}
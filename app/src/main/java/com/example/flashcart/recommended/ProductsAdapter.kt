package com.example.flashcart.recommended

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.flashcart.R

class ProductsAdapter (var productsList : ArrayList<RecommendedProducts>) : RecyclerView.Adapter<ProductsAdapter.ProductsViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.reccomandation_item_list, parent , false)
        return ProductsViewHolder(itemView)
    }

    override fun onBindViewHolder(productsViewHolder: ProductsViewHolder, position: Int) {
        val product = productsList[position]
        productsViewHolder.setData(product, position)
    }

    override fun getItemCount(): Int = productsList.size

    inner class ProductsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) , View.OnClickListener {

        private var currentPosition : Int = -1
        private var currentProduct : RecommendedProducts? = null

        private val productImg = itemView.findViewById<ImageView>(R.id.product_img)
        private val productName = itemView.findViewById<TextView>(R.id.product_name)

        fun setData(product: RecommendedProducts , position: Int){
            productName.text = product.productName
            productImg.setImageResource(product.imageId)

            this.currentProduct = product
            this.currentPosition = position
        }

        override fun onClick(v: View?) {

        }

    }

}
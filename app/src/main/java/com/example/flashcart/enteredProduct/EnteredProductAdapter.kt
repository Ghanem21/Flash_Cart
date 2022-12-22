package com.example.flashcart.enteredProduct
/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.flashcart.databinding.EntryItemListBinding
import com.example.flashcart.databinding.EntryTotalItemsListBinding
import com.example.flashcart.ui_fragments.adapters_and_data.ProductsData

private const val ITEM_VIEW_TYPE_HEADER = 0
private const val ITEM_VIEW_TYPE_ITEM = 1

class EnteredProductAdapter() : ListAdapter<ProductsData,
        RecyclerView.ViewHolder>(EnteredProductDiffCallback()) {



    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ViewHolder -> {
                val product = getItem(position)
                holder.bind(product)
            }
            is HeaderViewHolder -> {
                val product = getItem(position)
                holder.bind(product)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ITEM_VIEW_TYPE_HEADER -> HeaderViewHolder.from(parent)
            ITEM_VIEW_TYPE_ITEM -> ViewHolder.from(parent)
            else -> throw ClassCastException("Unknown viewType $viewType")
        }
    }

    class HeaderViewHolder(val binding: EntryItemListBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ProductsData) {
            binding.product = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): HeaderViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = EntryItemListBinding.inflate(layoutInflater, parent, false)
                return HeaderViewHolder(binding)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
             0 -> ITEM_VIEW_TYPE_HEADER
            else -> ITEM_VIEW_TYPE_ITEM
        }
    }

    class ViewHolder private constructor(val binding: EntryTotalItemsListBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ProductsData) {
            binding.product = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = EntryTotalItemsListBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}

/**
 * Callback for calculating the diff between two non-null items in a list.
 *
 * Used by ListAdapter to calculate the minimum number of changes between and old list and a new
 * list that's been passed to `submitList`.
 */
class EnteredProductDiffCallback : DiffUtil.ItemCallback<ProductsData>() {
    override fun areItemsTheSame(oldItem: ProductsData, newItem: ProductsData): Boolean {
        return oldItem.productName == newItem.productName
    }

    override fun areContentsTheSame(oldItem: ProductsData, newItem: ProductsData): Boolean {
        return oldItem == newItem
    }
}

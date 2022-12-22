package com.example.flashcart.ui_fragments.adapters_and_data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.flashcart.databinding.MealSuggestionCardBinding

class MealsSuggestionAdapter (var mealsList: ArrayList<MealData>) : RecyclerView.Adapter<MealsSuggestionAdapter.MealsViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealsViewHolder{
        return MealsViewHolder(MealSuggestionCardBinding.inflate(LayoutInflater.from(parent.context), parent , false))
    }

    override fun onBindViewHolder(mealsViewHolder: MealsViewHolder, position: Int) {
        val meal = mealsList[position]
        mealsViewHolder.onBind(meal, position)
    }

    override fun getItemCount(): Int = mealsList.size

    inner class MealsViewHolder(val binding: MealSuggestionCardBinding) : RecyclerView.ViewHolder(binding.root) , View.OnClickListener {

        private var currentPosition : Int = -1
        private var currentmeal : MealData? = null


        fun onBind(meal: MealData, position: Int){
            binding.meal = meal

            this.currentmeal = meal
            this.currentPosition = position

        }

        override fun onClick(v: View?) {

        }

    }
}
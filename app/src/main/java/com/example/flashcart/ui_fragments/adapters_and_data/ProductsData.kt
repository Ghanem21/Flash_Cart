package com.example.flashcart.ui_fragments.adapters_and_data

import com.example.flashcart.R

data class ProductsData(var imageId: Int, var productName: String)
data class MealData(var mealName: String)

object ProductsObjects{
    private val images = arrayListOf(
        R.drawable.thumb_4_1, R.drawable.thumb_4_2, R.drawable.thumb_4_3,
        R.drawable.thumb_4_4, R.drawable.thumb_4_7, R.drawable.thumb_4_8,
        R.drawable.thumb_4_0, R.drawable.thumb_7_0, R.drawable.thumb_7_1,
        R.drawable.thumb_7_2, R.drawable.thumb_4_5, R.drawable.thumb_4_6,
        R.drawable.thumb_1_0, R.drawable.thumb_1_1, R.drawable.thumb_1_2,
        R.drawable.thumb_1_3, R.drawable.thumb_1_4, R.drawable.thumb_1_5,
        R.drawable.thumb_1_6, R.drawable.thumb_1_7, R.drawable.thumb_1_8,
        R.drawable.thumb_1_9, R.drawable.thumb_2_0, R.drawable.thumb_2_1,
        R.drawable.thumb_4_9, R.drawable.thumb_5_0, R.drawable.thumb_5_1,
        R.drawable.thumb_5_2, R.drawable.thumb_5_3, R.drawable.thumb_5_4,
        R.drawable.thumb_5_5, R.drawable.thumb_5_6, R.drawable.thumb_5_7,
        R.drawable.thumb_5_8, R.drawable.thumb_5_9, R.drawable.thumb_6_0,
        R.drawable.thumb_6_1, R.drawable.thumb_6_2, R.drawable.thumb_6_3,
        R.drawable.thumb_6_4, R.drawable.thumb_6_5, R.drawable.thumb_6_6,
        R.drawable.thumb_6_7, R.drawable.thumb_6_8, R.drawable.thumb_6_9,
        R.drawable.thumb_2_2, R.drawable.thumb_2_3, R.drawable.thumb_2_4,
        R.drawable.thumb_2_5, R.drawable.thumb_2_6, R.drawable.thumb_2_7,
        R.drawable.thumb_2_8, R.drawable.thumb_2_9, R.drawable.thumb_3_0,
        R.drawable.thumb_3_1, R.drawable.thumb_3_2, R.drawable.thumb_3_3,
        R.drawable.thumb_3_4, R.drawable.thumb_3_5, R.drawable.thumb_3_6,
        R.drawable.thumb_3_7, R.drawable.thumb_3_8, R.drawable.thumb_3_9,
        R.drawable.thumb_7_3, R.drawable.thumb_7_4
    )

    private val productNames = arrayListOf(
        "New Delhi", "Manchester", "Nottingham", "Portsmouth", "Agra",
        "Hyderabad", "Goa", "Srinagar", "Xian", "Shanghai",
        "Buffalo", "Boise", "Pittsburgh", "Scottsdale", "Boston",
        "Philly", "Darjeeling", "Jaipur", "DC", "Minneapolis",
        "New York City", "Denver", "Asheville", "Hull", "Liverpool",
        "Detroit", "Adelaide", "Tasmania", "Austin", "Kansas City", "Seattle",
        "Oakland", "Las Vegas", "New Orleans", "Bath", "Norwich",
        "Mumbai", "Cambridge", "London", "Bristol", "Brighton", "Durham",
        "San Diego", "Brooklyn", "Chicago", "Charleston", "Nashville",
        "York", "Stratford-upon-Avon", "Bournemouth", "Beijing",
        "Miami", "Portland", "Chengdu", "Hangzhou", "Suzhou", "Huangshan",
        "Hong Kong", "Cairns", "Perth", "Brisbane",
        "Kakadu", "Melbourne", "Great Barrier Reef", "Sydney"
    )

    // Returns the list of product objects to be displayed in RecommendedFragment RecyclerView
    var productsList: ArrayList<ProductsData>? = null
        get() {

            if (field != null)      // backing 'field' refers to 'productsList' property object
                return field

            field = ArrayList()
            for (i in images.indices) {

                val imageId = images[i]
                val productName = productNames[i]
                val product = ProductsData(imageId, productName)
                field!!.add(product)
            }

            return field
        }



    var mealsList: ArrayList<MealData>? = null
        get() {

            if (field != null)
                return field

            field = ArrayList()
            for (i in productNames.indices) {
                val mealName = productNames[i]
                val meal = MealData(mealName)
                field!!.add(meal)
            }

            return field
        }



}
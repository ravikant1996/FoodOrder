package com.example.foodorder.model

import android.os.Parcelable
import com.example.foodorder.R
import java.util.ArrayList

data class Category(
    val categoryId: Int,
    val name: String,
    val image: Int
)

object CategoryProvider {
    val data: List<Category>
        get() {
            val dataList = ArrayList<Category>()
            dataList.add(Category(1, "Burger", R.drawable.burger))
            dataList.add(Category(2, "Sandwich", R.drawable.sandwich))
            dataList.add(Category(3, "Cocktails", R.drawable.cocktail))
            dataList.add(Category(4, "Beer", R.drawable.beer))
            dataList.add(Category(5, "Shakes", R.drawable.shakes))
            dataList.add(Category(6, "Desserts", R.drawable.desserts))
            dataList.add(Category(7, "Chips", R.drawable.chips))
            return dataList
        }
}

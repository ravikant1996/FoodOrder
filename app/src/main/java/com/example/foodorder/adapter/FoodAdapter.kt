package com.example.project1kotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foodorder.R
import com.example.foodorder.colorList
import com.example.foodorder.model.Food
import com.example.foodorder.setTextColorRes
import com.example.foodorder.setTint
import com.google.android.material.card.MaterialCardView
import java.util.*
import kotlin.collections.ArrayList

class FoodAdapter(private var list: List<Food>, private val context: Context) :
    RecyclerView.Adapter<FoodAdapter.ViewHolder>(), Filterable {
    private var onItemClickListener: OnItemClickListener? = null
    private var selectedPosition = -1

    var foodFilterList = ArrayList<Food>()

    init {
        foodFilterList = list as ArrayList<Food>
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.food_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.name.text = foodFilterList[position].food_name
        Glide.with(context).load(foodFilterList[position].url).into(holder.imageView)

        holder.cardView.setOnClickListener {
            onItemClickListener?.onItemClick(foodFilterList[position])
            selectedPosition = holder.adapterPosition
            this.notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int = foodFilterList.size

    fun setOnItemClickListener(clickListener: OnItemClickListener) {
        this.onItemClickListener = clickListener
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val name: TextView = itemView.findViewById(R.id.name)
        val cardView: MaterialCardView = itemView.findViewById(R.id.cardView)
    }


    interface OnItemClickListener {
        fun onItemClick(item: Food)
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                foodFilterList = if (charSearch.isEmpty()) {
                    list as ArrayList<Food>
                } else {
                    val resultList = ArrayList<Food>()
                    for (row in list) {
                        if (row.food_name.lowercase(Locale.getDefault()).contains(
                                constraint.toString()
                                    .lowercase(Locale.getDefault())
                            )
                        ) {
                            resultList.add(row)
                        }
                    }
                    resultList
                }
                val filterResults = FilterResults()
                filterResults.values = foodFilterList
                return filterResults
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                foodFilterList = results?.values as ArrayList<Food>
                notifyDataSetChanged()
            }
        }
    }

    fun updateList() {
        foodFilterList.clear()
        foodFilterList = list as ArrayList<Food>
        notifyDataSetChanged()
    }


}
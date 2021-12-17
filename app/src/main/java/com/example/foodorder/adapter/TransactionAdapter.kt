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
import com.example.foodorder.model.Transaction
import com.example.foodorder.setTextColorRes
import com.example.foodorder.setTint
import com.google.android.material.card.MaterialCardView
import java.util.*
import kotlin.collections.ArrayList

class TransactionAdapter(private var list: List<Transaction>, private val context: Context) :
    RecyclerView.Adapter<TransactionAdapter.ViewHolder>() {
    private var selectedPosition = -1

    var foodFilterList = ArrayList<Transaction>()

    init {
        foodFilterList = list as ArrayList<Transaction>
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.transaction_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.prize.text = "$${foodFilterList[position].prize}"

    }


    override fun getItemCount(): Int = foodFilterList.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val prize: TextView = itemView.findViewById(R.id.prize)
        val quantity: TextView = itemView.findViewById(R.id.quantity)
        val date: TextView = itemView.findViewById(R.id.date)
        val id: TextView = itemView.findViewById(R.id.id)
    }
}
package com.example.foodorder.ui.viewitemmodel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodorder.databinding.FragmentViewItemBinding
import com.example.foodorder.model.Food
import com.example.project1kotlin.adapter.FoodAdapter

class ViewItemFragment : Fragment() {
    private lateinit var value: ArrayList<Food>
    private lateinit var binding: FragmentViewItemBinding
    lateinit var foodAdapter: FoodAdapter

    //    lateinit var foodList: ArrayList<Food>
    lateinit var food: Food

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentViewItemBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true); // It's important here

//        foodList =
//            arguments?.getParcelableArrayList<Food>("value") as ArrayList<Food>
        food = arguments?.getParcelable<Food>("value") as Food
        Toast.makeText(activity, food.toString(), Toast.LENGTH_SHORT).show()

        initRecycler(food)

        return binding.root
    }

    private fun initRecycler(food: Food) {
        val foodList = ArrayList<Food>()
        foodList.add(food)
        foodAdapter = FoodAdapter(foodList, requireActivity())
//        val x = (resources.displayMetrics.density * 4).toInt() //converting dp to pixels
//        binding.recyclerView.addItemDecoration(SpacingItemDecorator(x)) //setting space between items in RecyclerView
        binding.recyclerView.apply {
            setHasFixedSize(true)
            adapter = foodAdapter
            layoutManager =
                LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)

        }
    }

}
package com.example.foodorder.ui.quickservice

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodorder.databinding.FragmentQuickServiceBinding
import com.example.foodorder.model.Category
import com.example.foodorder.model.CategoryProvider
import com.example.project1kotlin.adapter.Adapter

import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.example.foodorder.R
import com.example.foodorder.adapter.GridAutofitLayoutManager
import com.example.foodorder.communicator.MyCommunicator
import com.example.foodorder.model.Food
import com.example.foodorder.model.FoodProvider
import com.example.project1kotlin.adapter.FoodAdapter
import com.example.project1kotlin.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class QuickServiceFragment : Fragment() {
    lateinit var binding: FragmentQuickServiceBinding
    lateinit var categoryAdapter: Adapter
    private lateinit var searchView: SearchView
    lateinit var foodAdapter: FoodAdapter
    private val viewModel: QuickServiceModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQuickServiceBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true); // It's important here
        initRecycler()

        val foodList = ArrayList<Food>(viewModel.getFoodList(1))
        initFoodRecycler(foodList)

        categoryAdapter.setOnItemClickListener(object : Adapter.OnItemClickListener {
            override fun onItemClick(item: Category) {
                val foodList = ArrayList<Food>(viewModel.getFoodList(item.categoryId))
                initFoodRecycler(foodList)

            }
        })

        foodAdapter.setOnItemClickListener(object : FoodAdapter.OnItemClickListener {
            override fun onItemClick(item: Food) {
//                val foodList: ArrayList<Food> = FoodProvider.data1 as ArrayList<Food>

                val bundle = Bundle()
//                bundle.putParcelableArrayList("value", foodList)
                bundle.putParcelable("value", item)
                Navigation.findNavController(view!!)
                    .navigate(R.id.action_nav_home_to_viewItemFragment2, bundle)

                Toast.makeText(requireActivity(), item.toString(), Toast.LENGTH_SHORT).show()
            }

        })

        return binding.root
    }

    private fun initRecycler() {
        categoryAdapter = Adapter(CategoryProvider.data, requireActivity())
//        val x = (resources.displayMetrics.density * 4).toInt() //converting dp to pixels
//        binding.recyclerView.addItemDecoration(SpacingItemDecorator(x)) //setting space between items in RecyclerView
        binding.recyclerView.apply {
            setHasFixedSize(true)
            adapter = categoryAdapter
            layoutManager =
                LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
        }
    }

    private fun initFoodRecycler(foodList: ArrayList<Food>) {
        foodAdapter = FoodAdapter(foodList, requireActivity())
//        val x = (resources.displayMetrics.density * 4).toInt() //converting dp to pixels
//        binding.recyclerView.addItemDecoration(SpacingItemDecorator(x)) //setting space between items in RecyclerView
        binding.recyclerViewFood.apply {
            setHasFixedSize(true)
            adapter = foodAdapter
        }
    }
//                LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_search, menu)
        val searchItem = menu.findItem(R.id.action_search)
        searchView = searchItem.actionView as SearchView

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText.isNullOrEmpty()) {
                    foodAdapter.updateList()
                }
                return false
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                Toast.makeText(requireActivity(), "$query", Toast.LENGTH_SHORT).show()
                if (query.isNullOrEmpty()) {
                    foodAdapter.updateList()
                } else {
                    foodAdapter.filter.filter(query)
                }
                return false
            }

        })

        searchView.setOnCloseListener {
            if (foodAdapter != null) {
                foodAdapter.updateList()
            }
            false
        }
        searchView.setIconifiedByDefault(true); // make sure to set this to true
        return super.onCreateOptionsMenu(menu, inflater)
    }
}

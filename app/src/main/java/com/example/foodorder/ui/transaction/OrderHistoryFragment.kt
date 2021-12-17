package com.example.foodorder.ui.transaction

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import com.example.foodorder.R
import com.example.foodorder.databinding.FragmentOrderHistoryBinding
import com.example.foodorder.databinding.FragmentQuickServiceBinding
import com.example.foodorder.model.Category
import com.example.project1kotlin.adapter.Adapter

class OrderHistoryFragment : Fragment() {

    lateinit var binding: FragmentOrderHistoryBinding
    private lateinit var searchView: SearchView
    private lateinit var imageButton: ImageButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentOrderHistoryBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true); // It's important here


        return binding.root
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_history, menu)
//        super.onCreateOptionsMenu(menu, inflater)
        val searchItem = menu.findItem(R.id.action_search)
        val filterItem = menu.findItem(R.id.action_filter)
        searchView = searchItem.actionView as SearchView
        imageButton = filterItem.actionView as ImageButton

        imageButton.setOnClickListener {
            Toast.makeText(requireActivity(), "Clicked", Toast.LENGTH_SHORT).show()
        }

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                Toast.makeText(requireActivity(), "$query", Toast.LENGTH_SHORT).show()
                return false
            }
        })
        searchView.setOnCloseListener { false }
    }
}
package com.itess701.lostreschinos.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.itess701.lostreschinos.MainActivity
import com.itess701.lostreschinos.R
import com.itess701.lostreschinos.adapters.ProductAdapter

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //recycler
        val rvProducts: RecyclerView = view.findViewById(R.id.recyclerViewFeaturedProducts)

        val adapter = ProductAdapter(requireContext(), MainActivity.products)

        val linearLayoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        rvProducts.layoutManager = linearLayoutManager
        rvProducts.adapter = adapter
    }
}
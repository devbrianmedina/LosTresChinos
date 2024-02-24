package com.itess701.lostreschinos.ui.categories

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.itess701.lostreschinos.MainActivity
import com.itess701.lostreschinos.R
import com.itess701.lostreschinos.adapters.ProductAdapter
import com.itess701.lostreschinos.models.Product

class CategoryDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_details)

        //recycler
        val rvProducts: RecyclerView = findViewById(R.id.rvProducts)

        val adapter = ProductAdapter(this, MainActivity.products)

        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        rvProducts.layoutManager = linearLayoutManager
        rvProducts.adapter = adapter

    }
}
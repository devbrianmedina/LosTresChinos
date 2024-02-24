package com.itess701.lostreschinos.ui.categories

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.itess701.lostreschinos.R

class CategoriesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_categories, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val llCategoria1:LinearLayout = view.findViewById(R.id.llCategoria1)
        llCategoria1.setOnClickListener {
            val intent = Intent(requireContext(), CategoryDetailsActivity::class.java)
            startActivity(intent)
        }
    }
}
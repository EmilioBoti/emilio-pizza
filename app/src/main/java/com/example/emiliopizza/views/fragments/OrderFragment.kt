package com.example.emiliopizza.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.emiliopizza.R
import com.example.emiliopizza.views.adapters.OrderAdapter
import com.example.emiliopizza.views.models.Order
import com.example.emiliopizza.views.models.User

class OrderFragment : Fragment() {
    lateinit var containerItemOrder: RecyclerView
    val list: ArrayList<Order> = arrayListOf(Order("Chesee", 5L, ""))

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_order, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        containerItemOrder = view.findViewById(R.id.containerItemOrder)

        val orderAdapter = activity?.applicationContext?.let { OrderAdapter(it, list) }
        containerItemOrder.apply {
            layoutManager = LinearLayoutManager(activity?.applicationContext, RecyclerView.VERTICAL, false)
            adapter = orderAdapter
        }

    }

}
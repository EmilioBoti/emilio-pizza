package com.example.emiliopizza.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.emiliopizza.R
import com.example.emiliopizza.views.adapters.OrderAdapter
import com.example.emiliopizza.views.interactors.OrderInteractor
import com.example.emiliopizza.views.interfaces.IOrder
import com.example.emiliopizza.views.models.Model
import com.example.emiliopizza.views.models.Order
import com.example.emiliopizza.views.models.User
import kotlinx.coroutines.launch

class OrderFragment : Fragment(), IOrder.PresenterView{
    lateinit var containerItemOrder: RecyclerView
    lateinit var list: MutableList<Order>
    lateinit var model: Model
    lateinit var orderInteractor: OrderInteractor

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_order, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        containerItemOrder = view.findViewById(R.id.containerItemOrder)
        model = Model()
        orderInteractor = OrderInteractor(this, model)
        lifecycleScope.launch {
            orderInteractor.getList()
        }
    }

    override fun getListOrder(list: MutableList<Order>) {
        val orderAdapter = activity?.applicationContext?.let { OrderAdapter(it, list) }
        containerItemOrder.apply {
            layoutManager = LinearLayoutManager(activity?.applicationContext, RecyclerView.VERTICAL, false)
            adapter = orderAdapter
        }
    }

}
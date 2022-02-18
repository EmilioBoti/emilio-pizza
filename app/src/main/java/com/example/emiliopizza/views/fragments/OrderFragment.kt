package com.example.emiliopizza.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.emiliopizza.R
import com.example.emiliopizza.views.adapters.OrderAdapter
import com.example.emiliopizza.views.interactors.OrderInteractor
import com.example.emiliopizza.views.interfaces.IOrder
import com.example.emiliopizza.views.interfaces.OnclickItem
import com.example.emiliopizza.views.models.Model
import com.example.emiliopizza.views.models.Order
import kotlinx.coroutines.launch

class OrderFragment : Fragment(), IOrder.PresenterView, OnclickItem , View.OnClickListener{
    lateinit var containerItemOrder: RecyclerView
    lateinit var list: MutableList<Order>
    lateinit var model: Model
    lateinit var orderInteractor: OrderInteractor
    var btnAddCart: Button? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_order, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.title = "List Orders"
        containerItemOrder = view.findViewById(R.id.containerItemOrder)
        model = Model()

        orderInteractor = OrderInteractor(this, model)
        lifecycleScope.launch {
            orderInteractor.getList()
        }

    }

    override fun getListOrder(list: MutableList<Order>) {
        val orderAdapter = activity?.applicationContext?.let { OrderAdapter(it, list, this) }
        containerItemOrder.apply {
            layoutManager = LinearLayoutManager(activity?.applicationContext, RecyclerView.VERTICAL, false)
            adapter = orderAdapter
        }
    }
    override fun clickItem(pos: Int, view: View) {
        val itemDesc = view.findViewById<LinearLayout>(R.id.item_desc)
        when(itemDesc.visibility){
            View.GONE ->{
                itemDesc.visibility = View.VISIBLE
                btnAddCart = view.findViewById(R.id.btnCart)
                btnAddCart?.setOnClickListener(this)

                Toast.makeText(activity?.applicationContext, "${pos} ${itemDesc.visibility}", Toast.LENGTH_SHORT).show()
            }
            View.VISIBLE ->{
                itemDesc.visibility = View.GONE
                Toast.makeText(activity?.applicationContext, "${pos} ${itemDesc.visibility}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onClick(p0: View?) {
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(R.id.viewContainer, CartFragment())
            ?.addToBackStack("backTo")
            ?.commit()
        Toast.makeText(activity?.applicationContext, "Added", Toast.LENGTH_SHORT).show()
    }

}
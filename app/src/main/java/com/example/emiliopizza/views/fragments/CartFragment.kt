package com.example.emiliopizza.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.emiliopizza.R
import com.example.emiliopizza.views.adapters.OrderTakenAdapter
import com.example.emiliopizza.views.interactors.CartPresenterImpl
import com.example.emiliopizza.views.interfaces.ICartOrder
import com.example.emiliopizza.views.models.Order
import kotlinx.coroutines.launch

class CartFragment : Fragment(),ICartOrder.PresenterView, View.OnClickListener {
    private lateinit var listOrderTaken: MutableList<Order>
    private lateinit var cartPresenterInput: CartPresenterImpl
    private lateinit var containerOrderTaken: RecyclerView
    private lateinit var orderTakenAdapter: OrderTakenAdapter
    private lateinit var btnPay: Button
    private lateinit var price: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_cart, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.title = "Cart List"

        containerOrderTaken = view.findViewById(R.id.containerorderTaken)
        price = view.findViewById(R.id.totalPrice)
        btnPay = view.findViewById(R.id.btnPay)
        btnPay.setOnClickListener(this)

        cartPresenterInput = CartPresenterImpl(this)
        listOrderTaken = mutableListOf()

        lifecycleScope.launch {
            listOrderTaken = cartPresenterInput.getList()
            setList()
        }
    }
    private fun setList(){
        val context = activity?.applicationContext
        orderTakenAdapter = OrderTakenAdapter(context!!, listOrderTaken)
        containerOrderTaken.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            adapter = orderTakenAdapter
        }
    }
    override fun getListOrderTaken(list: MutableList<Order>, totalPrice: Float) {
        price.text = "${totalPrice}€"
    }

    override fun hasPay(paid: Boolean) {
        lifecycleScope.launch {
            if (paid){
                Toast.makeText(activity?.applicationContext, "The pay has been successfully", Toast.LENGTH_SHORT).show()
            }
            else Toast.makeText(activity?.applicationContext, "Error", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onClick(p0: View?) {
        lifecycleScope.launch {
            cartPresenterInput.payOrder()
        }
    }
}
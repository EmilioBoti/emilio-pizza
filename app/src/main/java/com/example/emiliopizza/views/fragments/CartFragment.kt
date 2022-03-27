package com.example.emiliopizza.views.fragments

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.emiliopizza.R
import com.example.emiliopizza.views.adapters.OrderTakenAdapter
import com.example.emiliopizza.views.interactors.CartPresenterInput
import com.example.emiliopizza.views.interfaces.ICartOrder
import com.example.emiliopizza.views.interfaces.adapterClick.OnclickItem
import com.example.emiliopizza.views.models.Order
import kotlinx.coroutines.launch

class CartFragment : Fragment(),ICartOrder.PresenterView, View.OnClickListener, OnclickItem {
    private lateinit var listOrderTaken: MutableList<Order>
    private lateinit var cartPresenterInput: CartPresenterInput
    private lateinit var containerOrderTaken: RecyclerView
    private lateinit var orderTakenAdapter: OrderTakenAdapter
    private lateinit var btnPay: Button
    private lateinit var price: TextView
    private lateinit var countItem: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_cart, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.title = "Cart List"

        containerOrderTaken = view.findViewById(R.id.containerorderTaken)
        price = view.findViewById(R.id.totalPrice)
        countItem = view.findViewById(R.id.itemsCount)
        btnPay = view.findViewById(R.id.btnPay)
        btnPay.setOnClickListener(this)

        cartPresenterInput = CartPresenterInput(this)
        listOrderTaken = mutableListOf()

        lifecycleScope.launch {
            listOrderTaken = cartPresenterInput.getList()
            setList()
        }
    }

    private fun setList(){
        val context = activity?.applicationContext
        orderTakenAdapter = OrderTakenAdapter(context!!, listOrderTaken, this)
        containerOrderTaken.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            adapter = orderTakenAdapter
        }
    }
    override fun getListOrderTaken(list: MutableList<Order>, totalPrice: Float, size: Int) {
        price.text = "${totalPrice}€"
        countItem.text = size.toString()
    }

    override fun hasPay(paid: Boolean) {
        lifecycleScope.launch {
            if (paid){
                price.text = "0.0€"
                countItem.text = "0"
                orderTakenAdapter.notifyDataSetChanged()
                Toast.makeText(activity?.applicationContext, "The pay has been successfully", Toast.LENGTH_SHORT).show()
            }
            else Toast.makeText(activity?.applicationContext, "Error", Toast.LENGTH_SHORT).show()
        }
    }

    override fun removedItem(ordered: Order, pos: Int) {
        orderTakenAdapter.notifyItemRemoved(pos)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onClick(p0: View?) {
        lifecycleScope.launch {
            if(listOrderTaken.isNotEmpty()){
                cartPresenterInput.payOrder(listOrderTaken)
            }else{
                Toast.makeText(activity, "You do not have items to pay.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun clickItem(pos: Int, view: View, arrowDown: ImageView? ) {
        AlertDialog.Builder(activity)
            .setTitle("Delete ${listOrderTaken[pos].name}")
            .setMessage("Are you sure want to delete it?")
            .setPositiveButton("Accept", DialogInterface.OnClickListener{ dialogInterface, it ->
                lifecycleScope.launch {
                    cartPresenterInput.removeItem(pos)
                }
            })
            .setNegativeButton("Cancel", DialogInterface.OnClickListener { dialogInterface, i ->
            })
            .create()
            .show()
    }
    override fun clickAddCart(pos: Int) {}

}
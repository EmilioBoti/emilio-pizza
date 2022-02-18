package com.example.emiliopizza.views.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.emiliopizza.R
import com.example.emiliopizza.views.interfaces.OnclickItem
import com.example.emiliopizza.views.models.Order

class OrderAdapter(val context: Context,val list: MutableList<Order>, val listenerclick: OnclickItem) : RecyclerView.Adapter<OrderAdapter.OrderViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.order_item, null)
        return OrderViewHolder(view, listenerclick)
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        holder.binData(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
    class OrderViewHolder(itemView: View, val listenerclick: OnclickItem) : RecyclerView.ViewHolder(itemView){
        val name: TextView = itemView.findViewById(R.id.name)
        val image: ImageView = itemView.findViewById(R.id.img)

        init { }

        fun binData(order: Order) {
            //Picasso.get().load(order.urlImg).into(image)
            name.text = order.name
            itemView.setOnClickListener { view ->
                listenerclick.clickItem(absoluteAdapterPosition, view)
            }
        }
    }
}
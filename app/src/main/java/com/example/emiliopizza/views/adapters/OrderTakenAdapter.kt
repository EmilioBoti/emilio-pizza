package com.example.emiliopizza.views.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.emiliopizza.R
import com.example.emiliopizza.views.interfaces.adapterClick.OnclickItem
import com.example.emiliopizza.views.models.Order
import com.squareup.picasso.Picasso

class OrderTakenAdapter(val context: Context, val list: MutableList<Order>, val listener: OnclickItem): RecyclerView.Adapter<OrderTakenAdapter.TakenViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TakenViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.order_taken, null)
        return TakenViewHolder(view, listener)
    }

    override fun onBindViewHolder(holder: TakenViewHolder, position: Int) {
        holder.binData(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class TakenViewHolder(itemView: View,val listener: OnclickItem): RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.nameTaken)
        val price: TextView = itemView.findViewById(R.id.price)
        val img: ImageView = itemView.findViewById(R.id.img)
        val btnremove: ImageView = itemView.findViewById(R.id.removeItem)

        fun binData(order: Order) {
            name.text = order.name
            price.text = "${order.price} €"
            Picasso.get()
                .load(order.urlImg).into(img)

            btnremove.setOnClickListener {
                listener.clickItem(absoluteAdapterPosition, it, null)
            }
        }
    }
}
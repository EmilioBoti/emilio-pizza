package com.example.emiliopizza.views.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.emiliopizza.R
import com.example.emiliopizza.views.models.Order

class OrderTakenAdapter(val context: Context, val list: MutableList<Order>): RecyclerView.Adapter<OrderTakenAdapter.TakenViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TakenViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.order_taken, null)
        return TakenViewHolder(view)
    }

    override fun onBindViewHolder(holder: TakenViewHolder, position: Int) {
        holder.binData(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class TakenViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.nameTaken)

        fun binData(order: Order) {
            name.text = order.name
        }
    }
}
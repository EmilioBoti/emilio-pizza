package com.example.emiliopizza.views.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.emiliopizza.R
import com.example.emiliopizza.views.models.Ordered

class HistorialAdapter(val context: Context, val list: MutableList<Ordered>): RecyclerView.Adapter<HistorialAdapter.HistorialViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistorialViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.historial_item, null)
        return HistorialViewHolder(view)
    }

    override fun onBindViewHolder(holder: HistorialViewHolder, position: Int) {
        holder.binData(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
    class HistorialViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        private val name: TextView = itemView.findViewById(R.id.orderName)
        private val date: TextView = itemView.findViewById(R.id.orderDate)
        private val pricePaid: TextView = itemView.findViewById(R.id.pricePaid)

        fun binData(ordered: Ordered) {
            name.text = ordered.name
            date.text = "${ordered.date}: hour ${ordered.hour}:${ordered.minute}"
            pricePaid.text = "${ordered.totalPrice} €"
        }
    }
}
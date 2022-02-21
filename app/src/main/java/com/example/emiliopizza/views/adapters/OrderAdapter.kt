package com.example.emiliopizza.views.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.emiliopizza.R
import com.example.emiliopizza.views.interfaces.OnclickItem
import com.example.emiliopizza.views.models.Order
import com.squareup.picasso.Picasso

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
    class OrderViewHolder(itemView: View, private val listenerClick: OnclickItem) : RecyclerView.ViewHolder(itemView){
        val name: TextView = itemView.findViewById(R.id.name)
        val price: TextView = itemView.findViewById(R.id.price)
        val image: ImageView = itemView.findViewById(R.id.img)
        val descText: TextView = itemView.findViewById(R.id.descText)

        lateinit var addCart: Button

        init {
            addCart = itemView.findViewById(R.id.btnCart)
        }

        fun binData(order: Order) {
            Picasso.get().load(order.urlImg).into(image)
            name.text = order.name
            price.text = "${order.price} €"
            descText.text = order.desc

            itemView.setOnClickListener { view ->
                val itemDesc = view.findViewById<LinearLayout>(R.id.item_desc)
                listenerClick.clickItem(absoluteAdapterPosition, itemDesc)
            }
            addCart.setOnClickListener {
                listenerClick.clickAddCart(absoluteAdapterPosition)
            }

        }
    }
}
package com.example.emiliopizza.views.interfaces

import com.example.emiliopizza.views.models.Order
import com.example.emiliopizza.views.models.Ordered

interface ICartOrder {
    interface PresenterView{
        fun getListOrderTaken(list: MutableList<Order>, totalPrice: Float, size: Int)
        fun hasPay(paid: Boolean)
        fun removedItem(ordered: Order, pos: Int)
    }
    interface Presenter{
        suspend fun getList(): MutableList<Order>
        suspend fun payOrder()
        suspend fun removeItem(pos: Int)
    }
}
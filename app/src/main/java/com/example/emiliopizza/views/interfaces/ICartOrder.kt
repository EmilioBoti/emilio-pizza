package com.example.emiliopizza.views.interfaces

import com.example.emiliopizza.views.models.Order

interface ICartOrder {
    interface PresenterView{
        fun getListOrderTaken(list: MutableList<Order>, totalPrice: Float)
        fun hasPay(paid: Boolean)
    }
    interface Presenter{
        suspend fun getList(): MutableList<Order>
        suspend fun payOrder()
    }
}
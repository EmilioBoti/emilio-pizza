package com.example.emiliopizza.views.interfaces

import com.example.emiliopizza.views.models.Order

interface IOrder {
    interface PresenterView{
        fun getListOrder(list: MutableList<Order>)
        fun addItem(order: Order)
    }
    interface Presenter{
        suspend fun getList()
         suspend fun addItem(order: Order)
    }
}
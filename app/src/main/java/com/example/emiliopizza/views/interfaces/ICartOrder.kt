package com.example.emiliopizza.views.interfaces

import com.example.emiliopizza.views.models.Order

interface ICartOrder {
    interface PresenterView{
        fun getListOrderTaken(list: MutableList<Order>, totalPrice: Float)
    }
    interface Presenter{
        suspend fun getList(): MutableList<Order>
    }
}
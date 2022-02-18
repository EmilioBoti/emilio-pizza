package com.example.emiliopizza.views.interfaces

import com.example.emiliopizza.views.models.Order

interface IOrder {
    interface PresenterView{
        fun getListOrder(list: MutableList<Order>)
    }
    interface Presenter{
        suspend fun getList()
    }
    interface PresenterModel{

    }
}
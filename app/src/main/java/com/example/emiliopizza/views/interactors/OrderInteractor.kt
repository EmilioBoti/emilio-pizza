package com.example.emiliopizza.views.interactors

import com.example.emiliopizza.views.interfaces.IOrder
import com.example.emiliopizza.views.models.DBService
import com.example.emiliopizza.views.models.Model
import com.example.emiliopizza.views.models.Order

class OrderInteractor(val viewer: IOrder.PresenterView, val model: Model): IOrder.Presenter {

    override suspend fun getList() {
        val list = model.getOrderList()
        viewer.getListOrder(list)
    }
    override suspend fun addItem(order: Order) {
        DBService.addOrder(order)
        viewer.addItem(order)
    }
}
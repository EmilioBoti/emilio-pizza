package com.example.emiliopizza.views.interactors

import com.example.emiliopizza.views.interfaces.ICartOrder
import com.example.emiliopizza.views.models.DBService
import com.example.emiliopizza.views.models.Order
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CartPresenterInput(val viewer: ICartOrder.PresenterView): ICartOrder.Presenter {
    private lateinit var list: MutableList<Order>
    var totalPrice: Float = 0f

    override suspend fun getList(): MutableList<Order> {
         list = withContext(Dispatchers.IO){
            DBService.getListOrder()
        }
        calculatePrice()
        return list
    }
    private fun calculatePrice(){
        list.forEach { order -> totalPrice += order.price }
        viewer.getListOrderTaken(list, totalPrice)
    }
}
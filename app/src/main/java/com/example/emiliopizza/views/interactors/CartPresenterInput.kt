package com.example.emiliopizza.views.interactors

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.emiliopizza.views.interfaces.ICartOrder
import com.example.emiliopizza.views.models.DBService
import com.example.emiliopizza.views.models.Order
import com.example.emiliopizza.views.models.Ordered
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.time.LocalDate
import java.time.LocalDateTime
import kotlin.math.round

class CartPresenterInput(private val viewer: ICartOrder.PresenterView): ICartOrder.Presenter {
    private lateinit var list: MutableList<Order>
    private var totalPrice: Float = 0f

    override suspend fun getList(): MutableList<Order> {
         list = withContext(Dispatchers.IO){
            DBService.getListOrder()
        }
        calculatePrice()
        viewer.getListOrderTaken(list, totalPrice, list.size)
        return list
    }
    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun payOrder(listOrderTaken: MutableList<Order>) {
        val date = LocalDate.now()
        val dateLocal = LocalDateTime.now()
        calculatePrice()
        val ordered = Ordered("${listOrderTaken[0].name}...",date.toString() ,dateLocal.hour.toString(),dateLocal.minute.toString(), list, totalPrice)

        withContext(Dispatchers.IO){
            DBService.orderPaid(ordered)
            DBService.clearlist()
            viewer.hasPay(true)
        }
    }

    override suspend fun removeItem(pos: Int) {
        val removedOrder = withContext(Dispatchers.IO){
            DBService.removeOrder(pos)
        }
        calculatePrice()
        viewer.removedItem(removedOrder, pos)
        viewer.getListOrderTaken(list, totalPrice, list.size)
    }

    private fun calculatePrice(){
        totalPrice = 0f
        list.forEach { order -> totalPrice += round(order.price) }
    }
}
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

class CartPresenterInput(val viewer: ICartOrder.PresenterView): ICartOrder.Presenter {
    private lateinit var list: MutableList<Order>
    private var totalPrice: Float = 0f

    override suspend fun getList(): MutableList<Order> {
         list = withContext(Dispatchers.IO){
            DBService.getListOrder()
        }
        calculatePrice()
        return list
    }
    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun payOrder() {
        val date = LocalDate.now()
        val dateLocal = LocalDateTime.now()
        val ordered = Ordered("Any Name",date.toString() ,dateLocal.hour.toString(),dateLocal.minute.toString(), list, 0)

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
        viewer.removedItem(removedOrder, pos)
        calculatePrice()
    }

    private fun calculatePrice(){
        totalPrice = 0f
        list.forEach { order -> totalPrice += round(order.price) }
        viewer.getListOrderTaken(list, totalPrice, list.size)
    }
}
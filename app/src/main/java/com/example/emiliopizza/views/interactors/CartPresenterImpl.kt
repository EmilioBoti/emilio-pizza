package com.example.emiliopizza.views.interactors

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.emiliopizza.views.interfaces.ICartOrder
import com.example.emiliopizza.views.models.DBService
import com.example.emiliopizza.views.models.Order
import com.example.emiliopizza.views.models.Ordered
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.time.Clock
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

class CartPresenterImpl(val viewer: ICartOrder.PresenterView): ICartOrder.Presenter {
    private lateinit var list: MutableList<Order>
    var totalPrice: Float = 0f

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
        val ordered = Ordered("Any Name",date.toString() ,dateLocal.hour.toString(),dateLocal.minute.toString(), list)
        withContext(Dispatchers.IO){
            DBService.orderPaid(ordered)
            DBService.clearlist()
            viewer.hasPay(true)
        }
    }

    private fun calculatePrice(){
        list.forEach { order -> totalPrice += order.price }
        viewer.getListOrderTaken(list, totalPrice)
    }
}
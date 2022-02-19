package com.example.emiliopizza.views.interfaces

import com.example.emiliopizza.views.models.Order
import com.example.emiliopizza.views.models.UserLogin

interface ModelData {
    suspend fun getDatas():UserLogin
    suspend fun getOrderList(): MutableList<Order>
}
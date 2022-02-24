package com.example.emiliopizza.views.models

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object DBService {
    private val listOrderTaken: MutableList<Order> = mutableListOf()
    private val listHistorilOrder: MutableList<Ordered> = mutableListOf()

    init { }

     suspend fun addOrder(order: Order){
         withContext(Dispatchers.IO){
             listOrderTaken.add(order)
         }
    }
    suspend fun orderPaid(ordered: Ordered){
        withContext(Dispatchers.IO){
            listHistorilOrder.add(ordered)
        }
    }
    fun removeOrder(index: Int){
        listOrderTaken.removeAt(index)
    }

    fun getListOrder(): MutableList<Order>{
        return listOrderTaken
    }

    fun getListOrdered(): MutableList<Ordered>{
        return listHistorilOrder
    }

    fun clearlist(){
        listOrderTaken.clear()
    }
    fun getOrder(index:Int): Order{
        return listOrderTaken[index]
    }
    fun listSize():Int{
        return listOrderTaken.size
    }
}
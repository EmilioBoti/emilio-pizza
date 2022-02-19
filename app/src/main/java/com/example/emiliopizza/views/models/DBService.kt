package com.example.emiliopizza.views.models

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object DBService {
    private val listOrderTaken: MutableList<Order> = mutableListOf()

    init {
    }

     suspend fun addOrder(order: Order){
         withContext(Dispatchers.IO){
             listOrderTaken.add(order)
         }
    }
    fun removeOrder(index: Int){
        listOrderTaken.removeAt(index)
    }
    fun getListOrder(): MutableList<Order>{
        return listOrderTaken
    }
    fun getOrder(index:Int): Order{
        return listOrderTaken[index]
    }
    fun listSize():Int{
        return listOrderTaken.size
    }
}
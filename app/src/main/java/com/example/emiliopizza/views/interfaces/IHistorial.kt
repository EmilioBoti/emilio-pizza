package com.example.emiliopizza.views.interfaces

import com.example.emiliopizza.views.models.Ordered

interface IHistorial {
    interface PresenterView{
        fun getListItemOrdered(listOrdered: MutableList<Ordered>)
    }
    interface Presenter{
        suspend fun getListOrdered()
    }
}
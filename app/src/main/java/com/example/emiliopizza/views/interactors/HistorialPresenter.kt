package com.example.emiliopizza.views.interactors

import com.example.emiliopizza.views.interfaces.IHistorial
import com.example.emiliopizza.views.models.DBService
import com.example.emiliopizza.views.models.Ordered
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HistorialPresenter(private val viwer: IHistorial.PresenterView): IHistorial.Presenter {

    override suspend fun getListOrdered() {
        val list = withContext(Dispatchers.IO){
            DBService.getListOrdered()
        }
        viwer.getListItemOrdered(list)
    }
}
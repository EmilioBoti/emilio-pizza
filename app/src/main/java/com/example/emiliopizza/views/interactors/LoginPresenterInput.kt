package com.example.emiliopizza.views.interactors

import com.example.emiliopizza.views.interfaces.ILogingView
import com.example.emiliopizza.views.interfaces.PresenterView
import com.example.emiliopizza.views.models.Model

class LoginPresenterInput(val view: ILogingView, val model: Model): PresenterView {
    override suspend fun login(){
        val user = model.getDatas()
        view.loging(user)
    }
}
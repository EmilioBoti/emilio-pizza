package com.example.emiliopizza.views.interactors

import com.example.emiliopizza.views.interfaces.ILogingView
import com.example.emiliopizza.views.interfaces.PresenterView
import com.example.emiliopizza.views.models.Model

class LoginPresenterInput(val view: ILogingView, val model: Model): PresenterView {
    override suspend fun login(email: String, password: String) {
        val user = model.getDatas()

        if ((email.isNotEmpty() && password.isNotEmpty()) && email == user.email && password == user.password)
            view.loging(user)
        else view.errorLogin("Error")

    }
}
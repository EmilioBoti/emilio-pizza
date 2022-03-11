package com.example.emiliopizza.views.interactors

import android.content.Context
import com.example.emiliopizza.R
import com.example.emiliopizza.views.interfaces.ILogingView
import com.example.emiliopizza.views.interfaces.PresenterView
import com.example.emiliopizza.views.models.Model
import com.example.emiliopizza.views.models.UserLogin

class LoginPresenterInput(val view: ILogingView, val model: Model, val context: Context): PresenterView {
    override suspend fun login(email: String, password: String) {
        val user = model.getDatas()

        if ((email.isNotEmpty() && password.isNotEmpty()) && email == user.email && password == user.password){
            saveDataUser(user)
            view.loging(user)
        }
        else view.errorLogin("Error")
    }

    override suspend fun getDataUser() {
        val user = model.getDatas()
        val prefs =  context.getSharedPreferences(context.getString(R.string.prefs_dataUser), Context.MODE_PRIVATE)
        if (user.email == prefs.getString("email", "") && user.password == prefs.getString("password", "")){
            view.loging(user)
        }
    }

    private fun saveDataUser(user: UserLogin) {
        val prefs =  context.getSharedPreferences(context.getString(R.string.prefs_dataUser), Context.MODE_PRIVATE)
            .edit()
        prefs.putString("email", user.email)
        prefs.putString("password", user.password)
        prefs.apply()
    }
}
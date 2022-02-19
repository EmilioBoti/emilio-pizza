package com.example.emiliopizza.views.interactors

import android.content.Context
import android.content.SharedPreferences
import android.widget.EditText
import com.example.emiliopizza.R
import com.example.emiliopizza.views.interfaces.IProfile
import com.example.emiliopizza.views.models.User

class ProfilePresenterInput(val view : IProfile.PresenterView, val context: Context): IProfile.Presenter {

    override fun saveProfileData(user: User) {
        val prefs = context.getSharedPreferences(context.getString(R.string.prefs_file), Context.MODE_PRIVATE).edit()
        prefs.apply {
            this.putString("name", user.name)
            this.putString("email", user.email)
            this.putString("address", user.address)
            this.putString("date", user.date)
            this.putString("phone", user.phone)
            this.apply()
        }
        view.saveSuccessful(true)
    }

    override fun getDataProfile() {
        val prefs = context.getSharedPreferences(context.getString(R.string.prefs_file), Context.MODE_PRIVATE)

        val name = prefs?.getString("name", "none")
        val email = prefs?.getString("email", "none")
        val address = prefs?.getString("address", "none")
        val date = prefs?.getString("date", "none")
        val phone = prefs?.getString("phone", "none")

        view.getDataProfile(User(name!!, email!!, address!!,date!!, phone!!))
    }
}
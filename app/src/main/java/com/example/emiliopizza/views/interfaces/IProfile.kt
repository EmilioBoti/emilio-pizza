package com.example.emiliopizza.views.interfaces

import com.example.emiliopizza.views.models.User

interface IProfile {
    interface PresenterView{
        fun saveSuccessful(success: Boolean)
        fun getDataProfile(user: User)
    }
    interface Presenter {
        fun saveProfileData(user:User)
        fun getDataProfile()
    }
}
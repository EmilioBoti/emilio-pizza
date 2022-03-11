package com.example.emiliopizza.views.interfaces

import com.example.emiliopizza.views.models.UserLogin

interface PresenterView {
    suspend fun login(email: String, password: String)
    suspend fun getDataUser()
}
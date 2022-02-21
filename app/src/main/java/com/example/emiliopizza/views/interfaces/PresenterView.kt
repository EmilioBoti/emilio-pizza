package com.example.emiliopizza.views.interfaces

interface PresenterView {
    suspend fun login(email: String, password: String)
}
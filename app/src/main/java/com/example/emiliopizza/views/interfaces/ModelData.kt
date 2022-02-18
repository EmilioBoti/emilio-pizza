package com.example.emiliopizza.views.interfaces

import com.example.emiliopizza.views.models.User

interface ModelData {
    suspend fun getDatas():User
}
package com.example.emiliopizza.views.models

import com.example.emiliopizza.views.interfaces.ModelData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class Model() : ModelData {
    val email: String = "admin@gmail.com"
    val password: String = "1234"

    override suspend fun getDatas() :User {
        return withContext(Dispatchers.IO){
            User(email, password);
        }
    }
}
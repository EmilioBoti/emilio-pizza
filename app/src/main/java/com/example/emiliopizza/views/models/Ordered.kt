package com.example.emiliopizza.views.models

data class Ordered(
    val name: String,
    val date: String,
    val hour: String,
    val minute: String,
    val listItem: MutableList<Order>,
    val totalPrice: Int = 0
    )

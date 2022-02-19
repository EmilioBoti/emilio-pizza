package com.example.emiliopizza.views.interfaces

import android.view.View

interface OnclickItem {
    fun clickItem(pos: Int, view: View)
    fun clickAddCart(pos: Int)
}
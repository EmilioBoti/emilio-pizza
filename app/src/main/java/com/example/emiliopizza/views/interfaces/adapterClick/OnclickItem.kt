package com.example.emiliopizza.views.interfaces.adapterClick

import android.view.View

interface OnclickItem {
    fun clickItem(pos: Int, view: View)
    fun clickAddCart(pos: Int)
}
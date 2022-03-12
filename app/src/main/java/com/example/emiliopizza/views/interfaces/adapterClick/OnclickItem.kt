package com.example.emiliopizza.views.interfaces.adapterClick

import android.view.View
import android.widget.ImageView

interface OnclickItem {
    fun clickItem(pos: Int, view: View, arrowDown: ImageView?)
    fun clickAddCart(pos: Int)
}
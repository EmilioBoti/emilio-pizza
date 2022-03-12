package com.example.emiliopizza.views.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.example.emiliopizza.R
import com.example.emiliopizza.views.ProfileActivity
import com.google.android.material.tabs.TabItem
import com.google.android.material.tabs.TabLayout

class PanelFragment : Fragment(), View.OnClickListener {
    private lateinit var btnOrder: Button
    private lateinit var btnHistorial: Button
    private lateinit var btnProfile: Button
    private lateinit var tabOrder: TabItem
    private lateinit var tabHistorial: TabItem
    private lateinit var tabProfile: TabItem

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_panel, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.title = "Panel"

        /*
        btnOrder = view.findViewById(R.id.btnOrders)
        btnHistorial = view.findViewById(R.id.btnHistorial)
        btnProfile = view.findViewById(R.id.btnProfile)*/
        /*
        tabOrder = view.findViewById(R.id.tabOrders)
        tabHistorial = view.findViewById(R.id.tabHistorial)
        tabProfile = view.findViewById(R.id.tabProfile)
        */

        /*btnOrder.setOnClickListener(this)
        btnHistorial.setOnClickListener(this)
        btnProfile.setOnClickListener(this)*/
    }

    override fun onClick(view: View?) {
        /*when(view?.id){
            R.id.btnProfile -> {
                Intent(activity, ProfileActivity::class.java).apply {
                    startActivity(this)
                }
            }
            R.id.btnOrders -> {
                navigateGoBack(OrderFragment())
            }R.id.btnHistorial ->{
                navigateGoBack(HistorialFragment())
            }
        }*/
    }
    private fun navigateGoBack( fragment: Fragment){
        activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.viewContainer, fragment)
           ?.addToBackStack("back")
            ?.commit()
    }
}
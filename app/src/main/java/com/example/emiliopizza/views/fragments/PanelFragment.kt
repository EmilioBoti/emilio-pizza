package com.example.emiliopizza.views.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.emiliopizza.R
import com.example.emiliopizza.views.ProfileActivity

class PanelFragment : Fragment(), View.OnClickListener {
    private lateinit var btnOrder: Button
    private lateinit var btnHistorial: Button
    private lateinit var btnProfile: Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_panel, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.title = "Panel"

        btnOrder = view.findViewById(R.id.btnOrders)
        btnHistorial = view.findViewById(R.id.btnHistorial)
        btnProfile = view.findViewById(R.id.btnProfile)

        btnOrder.setOnClickListener(this)
        btnHistorial.setOnClickListener(this)
        btnProfile.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view?.id){
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
        }
    }
    private fun navigateGoBack( fragment: Fragment){
        activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.viewContainer, fragment)
           ?.addToBackStack("back")
            ?.commit()
    }
}
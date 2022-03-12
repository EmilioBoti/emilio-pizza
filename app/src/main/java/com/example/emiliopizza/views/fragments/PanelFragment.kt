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

class PanelFragment : Fragment() {
    private lateinit var tabLayout: TabLayout

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_panel, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.title = "Panel"

        navigate(OrderFragment())

        tabLayout = view.findViewById(R.id.tabsContainer)
        tabLayout.elevation = 4f

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{

            override fun onTabSelected(tab: TabLayout.Tab?) {

                when(tab?.position){
                    0 -> {
                        navigate(OrderFragment())
                    }
                    1 -> {
                        navigate(HistorialFragment())
                    }
                }
            }
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }
        })
    }

    private fun navigate( fragment: Fragment){
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.container, fragment)
            ?.commit()
    }
    private fun navigateGoBack( fragment: Fragment){
        activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.container, fragment)
           ?.addToBackStack("back")
            ?.commit()
    }
}
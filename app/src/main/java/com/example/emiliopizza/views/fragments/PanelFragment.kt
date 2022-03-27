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
    private var page: Int? = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_panel, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.title = "Panel"

        page = arguments?.getInt("page")

        page?.let {
            nav(page)
        }

        //navigate(OrderFragment())

        tabLayout = view.findViewById(R.id.tabsContainer)
        tabLayout.elevation = 4f

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{

            override fun onTabSelected(tab: TabLayout.Tab?) {
                page = tab?.position
                nav(page)
            }
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }
        })
    }
    private fun nav(page: Int?){
        when(page){
            0 -> {
                //val t = tabLayout.getTabAt(page)
                //tabLayout.selectTab(t)
                navigate(OrderFragment())
            }
            1 -> {
                //val t = tabLayout.getTabAt(page)
                //tabLayout.selectTab(t)
                navigate(HistorialFragment())
            }
        }
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
package com.example.emiliopizza.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.emiliopizza.R
import com.example.emiliopizza.views.fragments.CartFragment
import com.example.emiliopizza.views.fragments.HistorialFragment
import com.example.emiliopizza.views.fragments.OrderFragment
import com.example.emiliopizza.views.fragments.PanelFragment
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    private lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigate(OrderFragment())
    }

    override fun onStart() {
        super.onStart()

        tabLayout = findViewById(R.id.tabsContainer)
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{

            override fun onTabSelected(tab: TabLayout.Tab?) {
                Toast.makeText(applicationContext, "${tab?.position}", Toast.LENGTH_SHORT).show()
                when(tab?.position){
                    0 -> {
                        navigateGoBack(OrderFragment())
                    }
                    1 -> {
                        navigateGoBack(HistorialFragment())
                    }
                }
            }
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }
        })
    }

    private fun navigateGoBack( fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.viewContainer, fragment)
            .addToBackStack("back")
            .commit()
    }
    private fun navigate( fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.viewContainer, fragment)
            .commit()
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_item, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.profileIcon -> {
                Intent(this, ProfileActivity::class.java).apply {
                    startActivity(this)
                }
            }
            R.id.order -> {
                navigate(OrderFragment())
            }R.id.cartMenu->{
                navigateGoBack(CartFragment())
            }
            R.id.cart -> {
                navigateGoBack(CartFragment())
            }R.id.historial -> {
                navigate(HistorialFragment())
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
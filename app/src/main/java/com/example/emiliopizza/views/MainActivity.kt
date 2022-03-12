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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigate(PanelFragment())
    }

    override fun onStart() {
        super.onStart()
    }

    private fun navigateGoBack( fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.viewContainer, fragment)
            .addToBackStack("back")
            .commit()
    }
    private fun navigate( fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.viewContainer, fragment)
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
                navigate(PanelFragment())
            }R.id.cartMenu->{
                navigateGoBack(CartFragment())
            }
            R.id.cart -> {
                navigateGoBack(CartFragment())
            }R.id.historial -> {
                navigateGoBack(HistorialFragment())
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
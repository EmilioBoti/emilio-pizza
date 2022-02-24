package com.example.emiliopizza.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.emiliopizza.R
import com.example.emiliopizza.views.fragments.CartFragment
import com.example.emiliopizza.views.fragments.HistorialFragment
import com.example.emiliopizza.views.fragments.OrderFragment
import com.example.emiliopizza.views.fragments.PanelFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.viewContainer, PanelFragment())
            .commit()
    }
    private fun navigateGoBack( fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.viewContainer, fragment)
            .addToBackStack("back")
            .commit()
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_item, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.profile -> {
                Intent(this, ProfileActivity::class.java).apply {
                    startActivity(this)
                }
            }
            R.id.order -> {
                navigateGoBack(OrderFragment())
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
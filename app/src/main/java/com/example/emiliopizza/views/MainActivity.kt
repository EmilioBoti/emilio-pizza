package com.example.emiliopizza.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.emiliopizza.R
import com.example.emiliopizza.views.fragments.OrderFragment
import com.example.emiliopizza.views.fragments.PanelFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "Panel"
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
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.profile -> {

            }
            R.id.order -> {
                navigateGoBack(OrderFragment())
            }R.id.cart -> {

            }R.id.historial -> {

            }
        }
        return super.onOptionsItemSelected(item)
    }
}
package com.example.practica5

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.fragment.app.Fragment

class Practica5Activity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practica5)

        drawerLayout = findViewById(R.id.drawer_layout)
        navView = findViewById(R.id.nav_view)

        replaceFragment(Practica1Fragment())

        navView.setNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.nav_practica1 -> replaceFragment(Practica1Fragment())
                R.id.nav_practica2 -> replaceFragment(Practica2Fragment())
                R.id.nav_practica3 -> replaceFragment(Practica3Fragment())
                R.id.nav_practica4 -> replaceFragment(Practica4Fragment())
                R.id.nav_juego -> replaceFragment(JuegoRPSFragment())
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}

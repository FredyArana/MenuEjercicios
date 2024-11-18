package com.fredy.menuapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        drawerLayout = findViewById(R.id.drawer_layout)
        val bottomNavView: BottomNavigationView = findViewById(R.id.bottom_nav_view)
        val navigationView: NavigationView = findViewById(R.id.navigation_view)

        // Set up navigation for Bottom Navigation
        NavigationUI.setupWithNavController(bottomNavView, navController)

        // Set up navigation for Drawer Menu
        NavigationUI.setupWithNavController(navigationView, navController)
    }
}
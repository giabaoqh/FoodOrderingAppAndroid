package com.example.foodorderingapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.foodorderingapp.databinding.ActivityMainBinding
import com.example.foodorderingapp.databinding.NotificationItemBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var NavController : NavController = findNavController(R.id.fragmentContainerView12)
        var bottomnav : BottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomnav.setupWithNavController(NavController)
        binding.notificationButton.setOnClickListener {
            val bottomSheetDialog = Notifaction_Bottom_Fragment()
            bottomSheetDialog.show(supportFragmentManager,"Test")
        }
    }
}
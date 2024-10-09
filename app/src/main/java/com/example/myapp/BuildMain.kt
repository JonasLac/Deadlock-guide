package com.example.myapp

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapp.databinding.ActivityBuildMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class BuildMain : AppCompatActivity() {

    private lateinit var binding: ActivityBuildMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBuildMainBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        /*binding.buildadone.setOnClickListener {
            startActivity(Intent(this, BuildAdOne::class.java))
        }
        binding.buildadtwo.setOnClickListener {
            startActivity(Intent(this, ActivityAdTwo::class.java))
        }
        binding.buildadthree.setOnClickListener {
            startActivity(Intent(this, ActivityAdThree::class.java))
        }
        binding.buildadfor.setOnClickListener {
            startActivity(Intent(this, ActivityAdFor::class.java))
        }*/

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.navbuild)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navarm -> {
                    true
                }

                R.id.navvit -> {
                    startActivity(Intent(this, BuildMainVd::class.java))
                    true
                }

                R.id.navesp -> {
                    startActivity(Intent(this, BuildMainEsp::class.java))
                    true
                }

                else -> false
            }
        }
        bottomNavigationView.menu.setGroupCheckable(0, true, false)
        for (i in 0 until bottomNavigationView.menu.size()) {
            bottomNavigationView.menu.getItem(i).isChecked = false
        }
        bottomNavigationView.menu.setGroupCheckable(0, true, false)
        for (i in 2 until bottomNavigationView.menu.size()) {
            bottomNavigationView.menu.getItem(0).isChecked = true
            bottomNavigationView.menu.getItem(1).isChecked = false
            bottomNavigationView.menu.getItem(2).isChecked = false
        }

        fun hideSystemUI() {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {

                window.setDecorFitsSystemWindows(false)
                window.insetsController?.let {
                    it.hide(WindowInsets.Type.statusBars() or WindowInsets.Type.navigationBars())
                    it.systemBarsBehavior =
                        WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
                }
            } else {
                window.decorView.systemUiVisibility = (
                        View.SYSTEM_UI_FLAG_IMMERSIVE
                                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                                or View.SYSTEM_UI_FLAG_FULLSCREEN
                                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        )
            }

        }
        hideSystemUI()
    }
}
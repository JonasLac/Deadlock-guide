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
import com.example.myapp.databinding.ActivityBuildMainVdBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class BuildMainVd : AppCompatActivity() {

    private lateinit var binding: ActivityBuildMainVdBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBuildMainVdBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.iconlogoback.setOnClickListener {
            finish()
        }

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.navbuild)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navarm -> {
                    startActivity(Intent(this, BuildMain::class.java))
                    true
                }

                R.id.navvit -> {
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
            bottomNavigationView.menu.getItem(0).isChecked = false
            bottomNavigationView.menu.getItem(1).isChecked = true
            bottomNavigationView.menu.getItem(2).isChecked = false
        }

        /*binding.buildvdone.setOnClickListener {
            startActivity(Intent(this, ActivityVdOne::class.java))
        }
        binding.buildvdtwo.setOnClickListener {
            startActivity(Intent(this, ActivityVdTwo::class.java))
        }
        binding.buildvdthree.setOnClickListener {
            startActivity(Intent(this, ActivityVdThree::class.java))
        }
        binding.buildvdfor.setOnClickListener {
            startActivity(Intent(this, ActivityVdFor::class.java))
        }*/
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
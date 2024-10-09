package com.example.myapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapp.databinding.ActivityTestAdmobBinding
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds

class TestAdmob : AppCompatActivity() {
    private lateinit var binding: ActivityTestAdmobBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestAdmobBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        MobileAds.initialize(this )
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.adView.loadAd(AdRequest.Builder().build())
    }
}
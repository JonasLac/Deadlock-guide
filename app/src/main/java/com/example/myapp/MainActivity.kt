package com.example.myapp

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import com.example.myapp.databinding.ActivityMainBinding
import com.google.android.gms.ads.AdLoader
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.nativead.NativeAd
import com.google.android.gms.ads.nativead.NativeAdOptions
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.Locale


@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(binding.root)
        MobileAds.initialize(this@MainActivity) {}
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        val textViewList = listOf(
            binding.layoutabrams,
            binding.layoutadaga,
            binding.layoutbebop,
            binding.layoutbruma,
            binding.layoutchico,
            binding.layoutdinamo,
            binding.layoutespectra,
            binding.layoutgarracinza,
            binding.layoutguarda,
            binding.layouthera,
            binding.layoutinfernos,
            binding.layoutkelvin,
            binding.layoutladygeist,
            binding.layoutmala,
            binding.layoutmcguinnis,
            binding.layoutmoekrill,
            binding.layoutparadoxa,
            binding.layoutsete,
            binding.layoutvindicta,
            binding.layoutviscoso,
            binding.layoutyamato,
            binding.layoutmiragem
        )

        binding.searchView.setOnQueryTextListener(object :
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                val queryId = newText?.toLowerCase(Locale.ROOT)
                textViewList.forEach { textView ->
                    val textViewId =
                        resources.getResourceEntryName(textView.id).toLowerCase(Locale.ROOT)
                    textView.isVisible = textViewId.contains(queryId ?: "")
                }
                return true
            }
        })


        binding.layoutinfernos.setOnClickListener {
            startActivity(Intent(this, TestAdmob::class.java))
        }
        binding.layoutadaga.setOnClickListener {
            startActivity(Intent(this, AdagaProfile::class.java))
        }
        binding.layoutbebop.setOnClickListener {
            startActivity(Intent(this, BebopProfile::class.java))
        }
        binding.layoutbruma.setOnClickListener {
            startActivity(Intent(this, BrumaProlife::class.java))
        }
        binding.layoutespectra.setOnClickListener {
            startActivity(Intent(this, EspectraProfile::class.java))
        }
        binding.layoutgarracinza.setOnClickListener {
            startActivity(Intent(this, GarraProfile::class.java))
        }
        binding.layoutguarda.setOnClickListener {
            startActivity(Intent(this, GuardaProfile::class.java))
        }
        binding.layouthera.setOnClickListener {
            startActivity(Intent(this, HeraProfile::class.java))
        }
        binding.layoutkelvin.setOnClickListener {
            startActivity(Intent(this, KelvinProfile::class.java))
        }
        binding.layoutladygeist.setOnClickListener {
            startActivity(Intent(this, LadyProfile::class.java))
        }
        binding.layoutmala.setOnClickListener {
            startActivity(Intent(this, MalaProfile::class.java))
        }
        binding.layoutmcguinnis.setOnClickListener {
            startActivity(Intent(this, McProfile::class.java))
        }
        binding.layoutmoekrill.setOnClickListener {
            startActivity(Intent(this, MoKrillProfile::class.java))
        }
        binding.layoutsete.setOnClickListener {
            startActivity(Intent(this, SeteProfile::class.java))
        }
        binding.layoutviscoso.setOnClickListener {
            startActivity(Intent(this, ViscosoProfile::class.java))
        }
        binding.layoutparadoxa.setOnClickListener {
            startActivity(Intent(this, ParadoxaProfile::class.java))
        }
        binding.layoutdinamo.setOnClickListener {
            startActivity(Intent(this, DinamoProfile::class.java))
        }
        binding.layoutabrams.setOnClickListener {
            startActivity(Intent(this, AbramsProfile::class.java))
        }
        binding.layoutvindicta.setOnClickListener {
            startActivity(Intent(this, VindictaProfile::class.java))
        }
        binding.layoutchico.setOnClickListener {
            startActivity(Intent(this, ChicoProfile::class.java))
        }
        binding.layoutyamato.setOnClickListener {
            startActivity(Intent(this, YamatoProfile::class.java))
        }
        binding.layoutmiragem.setOnClickListener {
            startActivity(Intent(this, MiragemProfile::class.java))
        }

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.navbuild)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navarm -> {
                    startActivity(Intent(this, BuildMain::class.java))
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

        fun hideSystemUI() {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                // Android 11 (API 30) e acima
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

        // Configurar o AdLoader
        val adLoader = AdLoader.Builder(this, "ca-app-pub-2104181702379477/5914780111")
            .forNativeAd { nativeAd: NativeAd ->

                populateNativeAdView(nativeAd)
            }
            .withAdListener(object : com.google.android.gms.ads.AdListener() {
                override fun onAdFailedToLoad(adError: com.google.android.gms.ads.LoadAdError) {
                    println("Falha ao carregar o anúncio: ${adError.message}")
                }
            })
            .withNativeAdOptions(
                NativeAdOptions.Builder()
                .build())
            .build()
        adLoader.loadAd(AdRequest.Builder().build())
    }
    private fun populateNativeAdView(nativeAd: NativeAd) {
        val headlineView = findViewById<TextView>(R.id.admob)
        headlineView.text = nativeAd.headline
    }
}




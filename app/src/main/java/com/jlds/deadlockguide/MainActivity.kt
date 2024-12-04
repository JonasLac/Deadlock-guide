package com.jlds.deadlockguide

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import com.example.myapp.R
import com.example.myapp.databinding.ActivityMainBinding
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.Locale


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var interstitialAd: InterstitialAd? = null
    private lateinit var imageView: ImageView
    private val handler = Handler(Looper.getMainLooper())
    fun showCustomDialog(imageRes: Int, text: String) {
        // Infla o layout personalizado
        val itemDialog = layoutInflater.inflate(R.layout.dialogtest, null)

        // Configura o texto e a imagem no layout do diálogo
        val dialogImageView = itemDialog.findViewById<ImageView>(R.id.itemImg)

        dialogImageView.setImageResource(imageRes) // Define a imagem

        // Cria e exibe o AlertDialog
        val dialog = AlertDialog.Builder(this)
            .setView(itemDialog)
            .create()

        dialog.show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("MainActivity", "onCreate chamado")
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(binding.root)

        MobileAds.initialize(this)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
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
                val queryId = newText?.lowercase(Locale.ROOT)
                textViewList.forEach { textView ->
                    val textViewId =
                        resources.getResourceEntryName(textView.id).lowercase(Locale.ROOT)
                    textView.isVisible = textViewId.contains(queryId ?: "")
                }
                return true
            }
        })




            if (interstitialAd != null) {
                interstitialAd?.show(this)
                interstitialAd?.fullScreenContentCallback = object : FullScreenContentCallback() {
                    override fun onAdDismissedFullScreenContent() {
                        // Após o fechamento do anúncio, carregue outro
                        loadInterstitialAd()
                    }

                    override fun onAdFailedToShowFullScreenContent(adError: com.google.android.gms.ads.AdError) {
                        // Carregue outro anúncio se a exibição falhar
                        loadInterstitialAd()
                    }
                }
            } else {
                // Caso o anúncio não esteja carregado, exiba uma mensagem ou carregue novamente
                loadInterstitialAd()
            }
        }


    // Método para carregar o anúncio intersticial
    private fun loadInterstitialAd() {
        val adRequest = AdRequest.Builder().build()

        InterstitialAd.load(
            this,
            "ca-app-pub-2104181702379477/5920588311", // Substitua pelo seu ID de anúncio
            adRequest,
            object : InterstitialAdLoadCallback() {
                override fun onAdLoaded(ad: InterstitialAd) {
                    interstitialAd = ad
                }

                override fun onAdFailedToLoad(error: LoadAdError) {
                    interstitialAd = null
                }
            }
        )


        binding.layoutinfernos.setOnClickListener {
            startActivity(Intent(this, infernosProfile::class.java))
        }
        binding.layoutadaga.setOnClickListener {
            if (interstitialAd != null) {
                interstitialAd?.show(this)
                interstitialAd?.fullScreenContentCallback = object : FullScreenContentCallback() {
                    override fun onAdDismissedFullScreenContent() {
                        loadInterstitialAd()
                    }
                    override fun onAdFailedToShowFullScreenContent(adError: com.google.android.gms.ads.AdError) {
                        loadInterstitialAd()
                    }
                }
            } else {
                loadInterstitialAd()
            }
            startActivity(Intent(this, AdagaProfile::class.java))
        }
        binding.layoutbebop.setOnClickListener {
            startActivity(Intent(this, BebopProfile::class.java))
        }
        binding.layoutbruma.setOnClickListener {
            if (interstitialAd != null) {
                interstitialAd?.show(this)
                interstitialAd?.fullScreenContentCallback = object : FullScreenContentCallback() {
                    override fun onAdDismissedFullScreenContent() {
                        loadInterstitialAd()
                    }
                    override fun onAdFailedToShowFullScreenContent(adError: com.google.android.gms.ads.AdError) {
                        loadInterstitialAd()
                    }
                }
            } else {
                loadInterstitialAd()
            }
            startActivity(Intent(this, BrumaProlife::class.java))
        }
        binding.layoutespectra.setOnClickListener {
            if (interstitialAd != null) {
                interstitialAd?.show(this)
                interstitialAd?.fullScreenContentCallback = object : FullScreenContentCallback() {
                    override fun onAdDismissedFullScreenContent() {
                        loadInterstitialAd()
                    }
                    override fun onAdFailedToShowFullScreenContent(adError: com.google.android.gms.ads.AdError) {
                        loadInterstitialAd()
                    }
                }
            } else {
                loadInterstitialAd()
            }
            startActivity(Intent(this, EspectraProfile::class.java))
        }
        binding.layoutgarracinza.setOnClickListener {
            startActivity(Intent(this, GarraProfile::class.java))
        }
        binding.layoutguarda.setOnClickListener {
            startActivity(Intent(this, GuardaProfile::class.java))
        }
        binding.layouthera.setOnClickListener {
            if (interstitialAd != null) {
                interstitialAd?.show(this)
                interstitialAd?.fullScreenContentCallback = object : FullScreenContentCallback() {
                    override fun onAdDismissedFullScreenContent() {
                        loadInterstitialAd()
                    }
                    override fun onAdFailedToShowFullScreenContent(adError: com.google.android.gms.ads.AdError) {
                        loadInterstitialAd()
                    }
                }
            } else {
                loadInterstitialAd()
            }
            startActivity(Intent(this, HeraProfile::class.java))
        }
        binding.layoutkelvin.setOnClickListener {
            startActivity(Intent(this, KelvinProfile::class.java))
        }
        binding.layoutladygeist.setOnClickListener {
            if (interstitialAd != null) {
                interstitialAd?.show(this)
                interstitialAd?.fullScreenContentCallback = object : FullScreenContentCallback() {
                    override fun onAdDismissedFullScreenContent() {
                        loadInterstitialAd()
                    }
                    override fun onAdFailedToShowFullScreenContent(adError: com.google.android.gms.ads.AdError) {
                        loadInterstitialAd()
                    }
                }
            } else {
                loadInterstitialAd()
            }
            startActivity(Intent(this, LadyProfile::class.java))
        }
        binding.layoutmala.setOnClickListener {
            startActivity(Intent(this, MalaProfile::class.java))
        }
        binding.layoutmcguinnis.setOnClickListener {
            startActivity(Intent(this, McProfile::class.java))
        }
        binding.layoutmoekrill.setOnClickListener {
            if (interstitialAd != null) {
                interstitialAd?.show(this)
                interstitialAd?.fullScreenContentCallback = object : FullScreenContentCallback() {
                    override fun onAdDismissedFullScreenContent() {
                        loadInterstitialAd()
                    }
                    override fun onAdFailedToShowFullScreenContent(adError: com.google.android.gms.ads.AdError) {
                        loadInterstitialAd()
                    }
                }
            } else {
                loadInterstitialAd()
            }
            startActivity(Intent(this, MoKrillProfile::class.java))
        }
        binding.layoutsete.setOnClickListener {
            startActivity(Intent(this, SeteProfile::class.java))
        }
        binding.layoutviscoso.setOnClickListener {
            startActivity(Intent(this, ViscosoProfile::class.java))
        }
        binding.layoutparadoxa.setOnClickListener {
            if (interstitialAd != null) {
                interstitialAd?.show(this)
                interstitialAd?.fullScreenContentCallback = object : FullScreenContentCallback() {
                    override fun onAdDismissedFullScreenContent() {
                        loadInterstitialAd()
                    }
                    override fun onAdFailedToShowFullScreenContent(adError: com.google.android.gms.ads.AdError) {
                        loadInterstitialAd()
                    }
                }
            } else {
                loadInterstitialAd()
            }
            startActivity(Intent(this, ParadoxaProfile::class.java))
        }
        binding.layoutdinamo.setOnClickListener {
            startActivity(Intent(this, DinamoProfile::class.java))
        }
        binding.layoutabrams.setOnClickListener {
            startActivity(Intent(this, AbramsProfile::class.java))
        }
        binding.layoutvindicta.setOnClickListener {
            if (interstitialAd != null) {
                interstitialAd?.show(this)
                interstitialAd?.fullScreenContentCallback = object : FullScreenContentCallback() {
                    override fun onAdDismissedFullScreenContent() {
                        loadInterstitialAd()
                    }
                    override fun onAdFailedToShowFullScreenContent(adError: com.google.android.gms.ads.AdError) {
                        loadInterstitialAd()
                    }
                }
            } else {
                loadInterstitialAd()
            }
            startActivity(Intent(this, VindictaProfile::class.java))
        }
        binding.layoutchico.setOnClickListener {
            startActivity(Intent(this, ChicoProfile::class.java))
        }
        binding.layoutyamato.setOnClickListener {
            startActivity(Intent(this, YamatoProfile::class.java))
        }
        binding.layoutmiragem.setOnClickListener {
            if (interstitialAd != null) {
                interstitialAd?.show(this)
                interstitialAd?.fullScreenContentCallback = object : FullScreenContentCallback() {
                    override fun onAdDismissedFullScreenContent() {
                        loadInterstitialAd()
                    }
                    override fun onAdFailedToShowFullScreenContent(adError: com.google.android.gms.ads.AdError) {
                        loadInterstitialAd()
                    }
                }
            } else {
                loadInterstitialAd()
            }
            startActivity(Intent(this, MiragemProfile::class.java))
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

        binding.adView.loadAd(AdRequest.Builder().build())
        binding.adViewone.loadAd(AdRequest.Builder().build())
        binding.adViewtwo.loadAd(AdRequest.Builder().build())
        binding.adViewthree.loadAd(AdRequest.Builder().build())
        binding.adViewfor.loadAd(AdRequest.Builder().build())
        binding.adViewfor.loadAd(AdRequest.Builder().build())
        var lastClickTime = 0L

        binding.layoutinfernos.setOnClickListener {
            if (System.currentTimeMillis() - lastClickTime > 1000) {
                lastClickTime = System.currentTimeMillis()
                startActivity(Intent(this, infernosProfile::class.java))
            }
        }
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.navbuild)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            if (System.currentTimeMillis() - lastClickTime > 1000) {
                lastClickTime = System.currentTimeMillis()
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
            } else {
                false
            }
        }
        bottomNavigationView.menu.setGroupCheckable(0, true, false)
        for (i in 0 until bottomNavigationView.menu.size()) {
            bottomNavigationView.menu.getItem(i).isChecked = false
        }

        val dialogsurto = layoutInflater.inflate(R.layout.dialogtest, null)

        val dialog = AlertDialog.Builder(this)
            .setView(dialogsurto) // Define o layout personalizado
            .create()

        dialog.show()



    }
}




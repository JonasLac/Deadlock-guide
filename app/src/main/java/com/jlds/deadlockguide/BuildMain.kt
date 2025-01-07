package com.jlds.deadlockguide

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapp.R
import com.example.myapp.databinding.ActivityBuildMainBinding
import com.google.android.gms.ads.AdRequest
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
        binding.adView.loadAd(AdRequest.Builder().build())
        binding.adViewtwo.loadAd(AdRequest.Builder().build())
        binding.adViewthee.loadAd(AdRequest.Builder().build())

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

        binding.iconlogoback.setOnClickListener {
            finish()
        }

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.navbuild)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navarm -> {
                    true
                }

                R.id.navvit -> {
                    startActivity(Intent(this, BuildMainVd::class.java))
                    finish()
                    true
                }

                R.id.navesp -> {
                    startActivity(Intent(this, BuildMainEsp::class.java))
                    finish()
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


        fun dialogSmall(
            imageRes: Int,
            text: String,
            valorText: String,
            detailsOneText: String,
            detailsTwoText: String,
            detailsThreeText: String,
            componentText: String,
            ativa: Boolean,
            textPass: String,
            imgcomp: Int,
            infoAtiva: Boolean
        ) {
            val dialogCostumizado = layoutInflater.inflate(R.layout.dialogad, null)
            val imgItem = dialogCostumizado.findViewById<ImageView>(R.id.itemImg)
            val dialogTextView = dialogCostumizado.findViewById<TextView>(R.id.itemNome)
            val valor = dialogCostumizado.findViewById<TextView>(R.id.valorItem)
            val detailsOne = dialogCostumizado.findViewById<TextView>(R.id.detalhesOne)
            val detailsTwo = dialogCostumizado.findViewById<TextView>(R.id.detalhesTwo)
            val detailsThree = dialogCostumizado.findViewById<TextView>(R.id.detalhesThree)
            val component = dialogCostumizado.findViewById<TextView>(R.id.componte)
            val imgComp = dialogCostumizado.findViewById<ImageView>(R.id.componenteimg)
            val ativaLayout = dialogCostumizado.findViewById<LinearLayout>(R.id.ativo)
            val layoutPass = dialogCostumizado.findViewById<LinearLayout>(R.id.layoutPassiva)
            val textPass = dialogCostumizado.findViewById<TextView>(R.id.textPassiva)
            val infoLayout = dialogCostumizado.findViewById<LinearLayout>(R.id.layoutInfos)


            imgItem.setImageResource(imageRes)
            imgComp.setImageResource(imageRes)
            dialogTextView.text = text
            valor.text = valorText
            detailsOne.text = detailsOneText
            detailsTwo.text = detailsTwoText
            detailsThree.text = detailsThreeText
            component.text = componentText


            if (ativa) {
                ativaLayout.visibility = View.GONE
                layoutPass.visibility = View.GONE
            } else {
                ativaLayout.visibility = View.VISIBLE
            }
            if (infoAtiva) {
                infoLayout.visibility = View.GONE
            } else {
                infoLayout.visibility = View.VISIBLE
            }

            val mostraDialog = AlertDialog.Builder(this)
                .setView(dialogCostumizado)
                .create()

            mostraDialog.show()
        }

        /*
        TEMPLATE
        binding.catadorDeBalas.setOnClickListener {
            dialogSmall(
                imageRes = R.drawable.apcatadordebalas,
                text = "",
                valorText = "",
                detailsOneText = "",
                detailsTwoText = "",
                detailsThreeText = "",
                componentText = "",
                ativa = false,
                textPass = "',
                imgcomp = R.drawable.adcartuchotitanico,
                infoAtiva = true
            )
        }
        */

        binding.cartuchobasico.setOnClickListener {
            dialogSmall(
                imageRes = R.drawable.adcartuchobasico,
                text = "Cartucho Basico",
                valorText = "500",
                detailsOneText = "+26% Munição",
                detailsTwoText = "+12% Dano de Arma",
                detailsThreeText = "detalhes3",
                componentText = "Revista Titanic",
                ativa = false,
                textPass = "Na",
                imgcomp = R.drawable.adcartuchotitanico,
                infoAtiva = true
            )
        }
        binding.caraacara.setOnClickListener {
            dialogSmall(
                imageRes = R.drawable.adcaraacara,
                text = "",
                valorText = "",
                detailsOneText = "+4% Resistência à bala",
                detailsTwoText = "+22% Dano de Arma Condicional",
                detailsThreeText = "",
                componentText = "Ponto Em Branco",
                ativa = false,
                textPass = "Na",
                imgcomp = R.drawable.adcartuchotitanico,
                infoAtiva = true
            )
        }


    }
}
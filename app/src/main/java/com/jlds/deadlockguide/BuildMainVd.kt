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
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapp.R
import com.example.myapp.databinding.ActivityBuildMainVdBinding
import com.google.android.gms.ads.AdRequest
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.jlds.deadlockguide.base.BaseActivity

class BuildMainVd : BaseActivity() {

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
        binding.adView.loadAd(AdRequest.Builder().build())
        binding.adViewtwo.loadAd(AdRequest.Builder().build())
        binding.adViewthee.loadAd(AdRequest.Builder().build())
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.navbuild)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navarm -> {
                    startActivity(Intent(this, BuildMain::class.java))
                    finish()
                    true
                }

                R.id.navvit -> {
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

        fun dialogSmall(
            imageRes: Int,
            text: String,
            valorText: String,
            detailsOneText: String,
            detailsTwoText: String,
            detailsThreeText: String,
            componentText: String,
            compAtiva: Boolean,
            ativa: Boolean,
            time: String,
            textPass: String,
            imgRes: Int,
            infoAtiva: Boolean
        ) {
            val dialogCostumizado = layoutInflater.inflate(R.layout.dialogvd, null)
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
            val timepass = dialogCostumizado.findViewById<TextView>(R.id.timepass)
            val compLayout = dialogCostumizado.findViewById<LinearLayout>(R.id.compLayout)
            val textPassi = dialogCostumizado.findViewById<TextView>(R.id.textPassiva)
            val infoLayout = dialogCostumizado.findViewById<LinearLayout>(R.id.layoutInfos)


            imgItem.setImageResource(imageRes)
            imgComp.setImageResource(imgRes)
            dialogTextView.text = text
            valor.text = valorText
            detailsOne.text = detailsOneText
            detailsTwo.text = detailsTwoText
            detailsThree.text = detailsThreeText
            component.text = componentText
            timepass.text = time
            textPassi.text = textPass


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
            if (compAtiva) {
                compLayout.visibility = View.GONE
            } else {
                compLayout.visibility = View.VISIBLE
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
                textPass = "",
                imgcomp = R.drawable.adcartuchotitanico,
                infoAtiva = true
            )
        }
        */

        binding.botasdecorrida.setOnClickListener {
            dialogSmall(
                imageRes = R.drawable.vdbotascorrida,
                text = "Botas de Corrida",
                valorText = "500 almas",
                detailsOneText = "+2m/s Velocidade de Sprint",
                detailsTwoText = "+1 Regen Saúde",
                detailsThreeText = "+4% Dano de Arma",
                componentText = "Velocidade Duradoura",
                compAtiva = false,
                ativa = true,
                time = "",
                textPass = "",
                imgRes = R.drawable.compvelocidaderesiliente,
                infoAtiva = true
            )
        }
        binding.espiritoresiliente.setOnClickListener {
            dialogSmall(
                imageRes = R.drawable.vdespiritoresilente,
                text = "Espirito resiliente",
                valorText = "500 Almas",
                detailsOneText = "+75 Bónus Saúde",
                detailsTwoText = "+10% Espírito Lifesteal",
                detailsThreeText = "+4 Poder Espiritual",
                componentText = "Feitiço desacelerador",
                compAtiva = false,
                ativa = true,
                time = "",
                textPass = "",
                imgRes = R.drawable.compfeiticodesacelerador,
                infoAtiva = true
            )
        }
        binding.punhosvampiricos.setOnClickListener {
            dialogSmall(
                imageRes = R.drawable.vdpunhosvampiricos,
                text = "Punnhos vampiricos",
                valorText = "500 Almas",
                detailsOneText = "+12% Dano Corpo a Corpo",
                detailsTwoText = "+3% Resistência à bala",
                detailsThreeText = "+75 Bónus Saúde",
                compAtiva = false,
                componentText = "LifeStrike",
                ativa = false,
                time = "",
                textPass = " Seus ataques corpo a corpo curam você por 80% do Dano Corpo a Corpo causado mais 90. Esta cura é 30% eficaz vs não-heróis.",
                imgRes = R.drawable.complifestrick,
                infoAtiva = true
            )
        }
        binding.vidaadicional.setOnClickListener {
            dialogSmall(
                imageRes = R.drawable.vdvidaadicional,
                text = "Vida adicional",
                valorText = "500 almas",
                detailsOneText = "+160 Bónus Saúde",
                detailsTwoText = "+7% Dano de Arma",
                detailsThreeText = "Na",
                compAtiva = false,
                componentText = "Resiliencia",
                ativa = true,
                time = "",
                textPass = "Na",
                imgRes = R.drawable.compresiliencia,
                infoAtiva = true
            )
        }
        binding.vigoradicional.setOnClickListener {
            dialogSmall(
                imageRes = R.drawable.vdvigoradicional,
                text = "Vigor adicional",
                valorText = "500 almas",
                detailsOneText = "+1 Resistência",
                detailsTwoText = "+16% Recuperação de Vigor",
                detailsThreeText = "+5% Taxa de Incêndio",
                compAtiva = false,
                componentText = "Velocidade resiliente",
                ativa = true,
                time = "",
                textPass = " Na",
                imgRes = R.drawable.compvigorsuperior,
                infoAtiva = true
            )
        }
        binding.ritodecura.setOnClickListener {
            dialogSmall(
                imageRes = R.drawable.vdritodecura,
                text = "rito de cura",
                valorText = "500 Almas",
                detailsOneText = "+30 Bónus Saúde",
                detailsTwoText = "+3 Poder Espiritual",
                detailsThreeText = "30m Cast Range",
                compAtiva = false,
                componentText = "Cura estelar",
                ativa = false,
                time = "",
                textPass = " Conceder range e Velocidade de Sprint ao alvo. É dissipado se você receber dano de jogadores ou objetivos inimigos. Pode ser auto-lançado.",
                imgRes = R.drawable.compcuraestelar,
                infoAtiva = true
            )
        }
    }
}
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
import com.example.myapp.databinding.ActivityBuildMainBinding
import com.google.android.gms.ads.AdRequest
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.jlds.deadlockguide.base.BaseActivity

class BuildMain : BaseActivity() {

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
            compAtiva: Boolean,
            componentText: String,
            ativa: Boolean,
            time: String,
            textPass: String,
            imgRes: Int,
            infoAtiva: Boolean
        ) {
            val dialogCostumizado = layoutInflater.inflate(R.layout.dialogad, null)
            val imgItem = dialogCostumizado.findViewById<ImageView>(R.id.itemImg)
            val dialogTextView = dialogCostumizado.findViewById<TextView>(R.id.itemNome)
            val valor = dialogCostumizado.findViewById<TextView>(R.id.valorItem)
            val detailsOne = dialogCostumizado.findViewById<TextView>(R.id.detalhesOne)
            val detailsTwo = dialogCostumizado.findViewById<TextView>(R.id.detalhesTwo)
            val detailsThree = dialogCostumizado.findViewById<TextView>(R.id.detalhesThree)
            val ativapass = dialogCostumizado.findViewById<TextView>(R.id.timepass)
            val component = dialogCostumizado.findViewById<TextView>(R.id.componte)
            val imgComp = dialogCostumizado.findViewById<ImageView>(R.id.componenteimg)
            val ativaLayout = dialogCostumizado.findViewById<LinearLayout>(R.id.ativo)
            val compLayout = dialogCostumizado.findViewById<LinearLayout>(R.id.compLayout)
            val layoutPass = dialogCostumizado.findViewById<LinearLayout>(R.id.layoutPassiva)
            val textPass = dialogCostumizado.findViewById<TextView>(R.id.textPassiva)
            val infoLayout = dialogCostumizado.findViewById<LinearLayout>(R.id.layoutInfos)


            imgItem.setImageResource(imageRes)
            imgComp.setImageResource(imgRes)
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
                time = "",
                textPass = "",
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
                detailsThreeText = "Na",
                componentText = "Revista Titanic",
                compAtiva = false,
                ativa = true,
                time = "",
                textPass = "Deal additional Weapon Damage when in close range to your target",
                imgRes = R.drawable.admincartuchotitanico,
                infoAtiva = true
            )
        }
        binding.caraacara.setOnClickListener {
            dialogSmall(
                imageRes = R.drawable.adcaraacara,
                text = "Cara a Cara",
                valorText = "500 almas",
                detailsOneText = "+4% Resistência à bala",
                detailsTwoText = "+22% Dano de Arma Condicional",
                detailsThreeText = "Na",
                componentText = "Ponto Em Branco",
                compAtiva = false,
                ativa = false,
                time = "00",
                textPass = "Na",
                imgRes = R.drawable.compqueimaroupas,
                infoAtiva = true
            )
        }
        binding.tiroreforcadonacabeca.setOnClickListener {
            dialogSmall(
                imageRes = R.drawable.adtiroreforcadonacabeca,
                text = "Tiro reforçado na caceça",
                valorText = "500 almas",
                detailsOneText = "+5% taxa de incêndio",
                detailsTwoText = "+40% Saúde do Escudo da Bala",
                detailsThreeText = "+40 Dano de Bónus de Headshot",
                componentText = "Caça cabeças",
                compAtiva = false,
                ativa = false,
                time = "8.1",
                textPass = "Dano de Arma de bônus com tiros na cabeça",
                imgRes = R.drawable.compcacacabecas,
                infoAtiva = true
            )
        }
        binding.cartuchodealtavelocidade.setOnClickListener {
            dialogSmall(
                imageRes = R.drawable.adcartuchodealtavelocidade,
                text = "Cartucho de alta velocidaded",
                valorText = "500 almas",
                detailsOneText = "+20% Velocidade da Bala",
                detailsTwoText = "+13% Dano de Arma",
                detailsThreeText = "65 Bullet Shield Saúde",
                componentText = "Emblema maculado",
                compAtiva = false,
                ativa = true,
                time = "23",
                textPass = "na",
                imgRes = R.drawable.compemblemaimaculado,
                infoAtiva = true
            )
        }
        binding.baladepontaoca.setOnClickListener {
            dialogSmall(
                imageRes = R.drawable.adbaladepontaoca,
                text = "Bala de ponta oca",
                valorText = "500 Almas",
                detailsOneText = "+95 Spirit Shield Saúde",
                detailsTwoText = "+4 Poder Espiritual",
                detailsThreeText = "+20% Dano de Arma",
                componentText = "Na",
                compAtiva = true,
                ativa = false,
                time = "90",
                textPass = "Quando você estiver acima de 65% de vida, cause Dano de Arma adicional.",
                imgRes = R.drawable.adcartuchotitanico,
                infoAtiva = true
            )
        }
        binding.municaomatamonstros.setOnClickListener {
            dialogSmall(
                imageRes = R.drawable.admunicaomatamonstros,
                text = "Munição mata monstros",
                valorText = "500 Almas",
                detailsOneText = "+30% Dano de Arma vs NPCs",
                detailsTwoText = "Resistência à bala vs NPCs",
                detailsThreeText = "+30 Bónus Saúde",
                componentText = "na",
                compAtiva = true,
                ativa = true,
                time = "na",
                textPass = "na",
                imgRes = R.drawable.adcartuchotitanico,
                infoAtiva = true
            )
        }
        binding.balasrapidas.setOnClickListener {
            dialogSmall(
                imageRes = R.drawable.adbalasrapidas,
                text = "Balas rapidas",
                valorText = "500 Almas",
                detailsOneText = "+10% Taxa de Incêndio",
                detailsTwoText = "+1m/s Velocidade de Sprint",
                detailsThreeText = "na",
                componentText = "na",
                compAtiva = true,
                ativa = false,
                time = "",
                textPass = "When you are above 65% health, deal additional Weapon Damage.",
                imgRes = R.drawable.adcartuchotitanico,
                infoAtiva = true
            )
        }
        binding.disparorestaurador.setOnClickListener {
            dialogSmall(
                imageRes = R.drawable.addisparorestaurador,
                text = "Disparo restaurador",
                valorText = "500 Almas",
                detailsOneText = "+90 Bullet Shield Saúde",
                detailsTwoText = "+3% Dano de Arma",
                detailsThreeText = "40 Cura dos Heróis",
                componentText = "na",
                compAtiva = true,
                ativa = true,
                time = "6s",
                textPass = "Sua próxima bala irá curá-lo com base em qual alvo você atingiu.",
                imgRes = R.drawable.adcartuchotitanico,
                infoAtiva = true
            )
        }
    }
}
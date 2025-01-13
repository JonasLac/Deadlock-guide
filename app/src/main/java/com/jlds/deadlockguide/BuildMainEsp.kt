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
import com.example.myapp.databinding.ActivityBuildMainEspBinding
import com.google.android.gms.ads.AdRequest
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.jlds.deadlockguide.base.BaseActivity

class BuildMainEsp : BaseActivity() {

    private lateinit var binding: ActivityBuildMainEspBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBuildMainEspBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.adView.loadAd(AdRequest.Builder().build())
        binding.adViewtwo.loadAd(AdRequest.Builder().build())
        binding.adViewthree.loadAd(AdRequest.Builder().build())

        binding.iconlogoback.setOnClickListener {
            finish()
        }
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.navbuild)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navarm -> {
                    startActivity(Intent(this, BuildMain::class.java))
                    finish()
                    true
                }

                R.id.navvit -> {
                    startActivity(Intent(this, BuildMainVd::class.java))
                    finish()
                    true
                }

                R.id.navesp -> {
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
            bottomNavigationView.menu.getItem(1).isChecked = false
            bottomNavigationView.menu.getItem(2).isChecked = true
        }

        /*binding.buildapone.setOnClickListener {
            startActivity(Intent(this, ActivityApOne::class.java))
        }
        binding.buildaptwo.setOnClickListener {
            startActivity(Intent(this, ActivityApTwo::class.java))
        }
        binding.buildapthree.setOnClickListener {
            startActivity(Intent(this, ActivityApThree::class.java))
        }
        binding.buildapfor.setOnClickListener {
            startActivity(Intent(this, ActivityApFor::class.java))
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

        fun mostraDialog(imageRes: Int, text: String) {
            val dialogCostumizado = layoutInflater.inflate(R.layout.dialogtest,null)
            val imgItem = dialogCostumizado.findViewById<ImageView>(R.id.itemImg)
            val dialogTextView = dialogCostumizado.findViewById<TextView>(R.id.itemNome)
            imgItem.setImageResource(imageRes)
            dialogTextView.text = text
            val mostraDialog = AlertDialog.Builder(this)
                .setView(dialogCostumizado)
                .create()

            mostraDialog.show()
        }

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
            val dialogCostumizado = layoutInflater.inflate(R.layout.dialogpeq, null)
            val imgItem = dialogCostumizado.findViewById<ImageView>(R.id.itemImg)
            val dialogTextView = dialogCostumizado.findViewById<TextView>(R.id.itemNome)
            val valor = dialogCostumizado.findViewById<TextView>(R.id.valorItem)
            val detailsOne = dialogCostumizado.findViewById<TextView>(R.id.detalhesOne)
            val detailsTwo = dialogCostumizado.findViewById<TextView>(R.id.detalhesTwo)
            val detailsThree = dialogCostumizado.findViewById<TextView>(R.id.detalhesThree)
            val component = dialogCostumizado.findViewById<TextView>(R.id.componte)
            val imgComp = dialogCostumizado.findViewById<ImageView>(R.id.componenteimg)
            val ativaLayout = dialogCostumizado.findViewById<LinearLayout>(R.id.ativo)
            val compLayout = dialogCostumizado.findViewById<LinearLayout>(R.id.compLayout)
            val layoutPass = dialogCostumizado.findViewById<LinearLayout>(R.id.layoutPassiva)
            val timepass = dialogCostumizado.findViewById<TextView>(R.id.timepass)
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


        /* TEMPLATE DA FUNÇÃO
        binding.catadorDeBalas.setOnClickListener {
            dialogSmall(
                imageRes = R.drawable.apcatadordebalas,
                text = "",
                valorText = "",
                detailsOneText = "",
                detailsTwoText = "",
                detailsThreeText = "",
                componentText = ""
            )
        }
        */


        binding.cargaAdicional.setOnClickListener {

            dialogSmall(
                imageRes = R.drawable.apcargaadicional,
                text = "Carga adicional",
                valorText = "500 Almas",
                detailsOneText = "+1 Cargas de Capacidade de Bónus",
                detailsTwoText = "+10% Redução de Recarga para Habilidades Cobradas",
                detailsThreeText = "+6% Dano de Arma",
                componentText = "Recarga Rapida",
                compAtiva = false,
                ativa = true,
                time = "00",
                textPass = "Na",
                imgRes = R.drawable.comprecargarapida,
                infoAtiva = true
            )
        }
        binding.catadorDeBalas.setOnClickListener {
            dialogSmall(
                imageRes = R.drawable.apcatadordebalas,
                text = "Catador de Balas",
                valorText = "500 Almas",
                detailsOneText = "+10% Munição",
                detailsTwoText = "+40 Bónus Saúde",
                detailsThreeText = "+2 Sprint e Max Sacks",
                componentText = "catador",
                compAtiva = true,
                ativa = true,
                time = "00",
                textPass = "Na",
                imgRes = R.drawable.admincartuchotitanico,
                infoAtiva = true

            )
        }
        binding.espiritoAdicional.setOnClickListener {
            dialogSmall(
                imageRes = R.drawable.apespiritoadicional,
                text = "Espirito Adicional",
                valorText = "500 Almas",
                detailsOneText = "+10 Poder Espiritual",
                detailsTwoText = "+1 Regen Saúde",
                detailsThreeText = "+35 Bónus Saúde",
                componentText = "Espirito Aprimorado",
                compAtiva = false,
                ativa = true,
                time = "00",
                textPass = "Na",
                imgRes = R.drawable.compespiritoaprimorado,
                infoAtiva = true

            )
        }
        binding.explosaoMistica.setOnClickListener {
            dialogSmall(
                imageRes = R.drawable.apexplosaomistica,
                text = "Explosão Mistica",
                valorText = "500 Almas",
                detailsOneText = "+40 Spirit Shield Saúde",
                detailsTwoText = "+6% Dano de Arma",
                detailsThreeText = "35 Dano de Bônus",
                componentText = "Explosão aprimorada",
                compAtiva = false,
                ativa = true,
                time = "00",
                textPass = "Na",
                imgRes = R.drawable.compexplosaoaprimorada,
                infoAtiva = true

            )
        }
        binding.dominioMistico.setOnClickListener {
            dialogSmall(
                imageRes = R.drawable.apdominiomistico,
                text = "Dominio Mistico",
                valorText = "500 Almas",
                detailsOneText = "Aumenta o alcance e o raio de efeito de suas habilidades e itens.",
                detailsTwoText = "+15% Faixa de Capacidade",
                detailsThreeText = "+7% Resistência ao Espírito",
                componentText = "Dominio Aprimorado",
                compAtiva = false,
                ativa = true,
                time = "00",
                textPass = "Na",
                imgRes = R.drawable.compdominioaprimorado,
                infoAtiva = true

            )
        }
        binding.golpeEspiritual.setOnClickListener {
            dialogSmall(
                imageRes = R.drawable.apgolpeespiritual,
                text = "Golpe Espiritual",
                valorText = "500",
                detailsOneText = "+12% Dano Corpo a Corpo",
                detailsTwoText = "+80 Spirit Shield Saúde",
                detailsThreeText = "50 Dano de Espírito",
                componentText = "Na",
                compAtiva = true,
                ativa = true,
                time = "",
                textPass = "",
                imgRes = R.drawable.admincartuchotitanico,
                infoAtiva = true

            )
        }
        binding.infusor.setOnClickListener {
            dialogSmall(
                imageRes = R.drawable.apinfusao,
                text = "Catador de Balas",
                valorText = "500",
                detailsOneText = "+70 Escudo Espiritual",
                detailsTwoText = "+16 Poder Espiritual",
                detailsThreeText = "+20% Espírito Lifesteal",
                componentText = "Cura Estelar",
                compAtiva = true,
                ativa = false,
                time = "32s",
                textPass = "Ganhe Poder Espiritual e Espírito Lifesteal.",
                imgRes = R.drawable.admincartuchotitanico,
                infoAtiva = true
            )
        }



    }
}
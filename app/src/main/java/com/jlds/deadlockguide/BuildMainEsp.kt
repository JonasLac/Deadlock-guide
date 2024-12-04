package com.jlds.deadlockguide

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapp.R
import com.example.myapp.databinding.ActivityBuildMainEspBinding
import com.google.android.gms.ads.AdRequest
import com.google.android.material.bottomnavigation.BottomNavigationView

class BuildMainEsp : AppCompatActivity() {

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
                    true
                }

                R.id.navvit -> {
                    startActivity(Intent(this, BuildMainVd::class.java))
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
            componentText: String
        ) {
            val dialogCostumizado = layoutInflater.inflate(R.layout.dialogpeq, null)
            val imgItem = dialogCostumizado.findViewById<ImageView>(R.id.itemImg)
            val dialogTextView = dialogCostumizado.findViewById<TextView>(R.id.itemNome)
            val valor = dialogCostumizado.findViewById<TextView>(R.id.valorItem)
            val detailsOne = dialogCostumizado.findViewById<TextView>(R.id.detalhesOne)
            val detailsTwo = dialogCostumizado.findViewById<TextView>(R.id.detalhesTwo)
            val detailsThree = dialogCostumizado.findViewById<TextView>(R.id.detalhesThree)
            val component = dialogCostumizado.findViewById<TextView>(R.id.componte)

            imgItem.setImageResource(imageRes)
            dialogTextView.text = text
            valor.text = valorText
            detailsOne.text = detailsOneText
            detailsTwo.text = detailsTwoText
            detailsThree.text = detailsThreeText
            component.text = componentText

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


        binding.catadorDeBalas.setOnClickListener {
            dialogSmall(
                imageRes = R.drawable.apcatadordebalas,
                text = "Catador de Balas",
                valorText = "500",
                detailsOneText = "detalhes1",
                detailsTwoText = "detalhes2",
                detailsThreeText = "detalhes3",
                componentText = "catador"
            )
        }
        binding.cargaAdicional.setOnClickListener {
            dialogSmall(
                imageRes = R.drawable.apcargaadicional,
                text = "Catador de Balas",
                valorText = "500",
                detailsOneText = "detalhes1",
                detailsTwoText = "detalhes2",
                detailsThreeText = "detalhes3",
                componentText = "catador"
            )
        }
        binding.cargaAdicional.setOnClickListener {
            dialogSmall(
                imageRes = R.drawable.apcargaadicional,
                text = "Catador de Balas",
                valorText = "500",
                detailsOneText = "detalhes1",
                detailsTwoText = "detalhes2",
                detailsThreeText = "detalhes3",
                componentText = "catador"
            )
        }
        binding.espiritoAdicional.setOnClickListener {
            dialogSmall(
                imageRes = R.drawable.apespiritoadicional,
                text = "Catador de Balas",
                valorText = "500",
                detailsOneText = "detalhes1",
                detailsTwoText = "detalhes2",
                detailsThreeText = "detalhes3",
                componentText = "catador"
            )
        }
        binding.explosaoMistica.setOnClickListener {
            dialogSmall(
                imageRes = R.drawable.apexplosaomistica,
                text = "Catador de Balas",
                valorText = "500",
                detailsOneText = "detalhes1",
                detailsTwoText = "detalhes2",
                detailsThreeText = "detalhes3",
                componentText = "catador"
            )
        }
        binding.dominioMistico.setOnClickListener {
            dialogSmall(
                imageRes = R.drawable.apdominiomistico,
                text = "Catador de Balas",
                valorText = "500",
                detailsOneText = "detalhes1",
                detailsTwoText = "detalhes2",
                detailsThreeText = "detalhes3",
                componentText = "catador"
            )
        }
        binding.golpeEspiritual.setOnClickListener {
            dialogSmall(
                imageRes = R.drawable.apgolpeespiritual,
                text = "Catador de Balas",
                valorText = "500",
                detailsOneText = "detalhes1",
                detailsTwoText = "detalhes2",
                detailsThreeText = "detalhes3",
                componentText = "catador"
            )
        }
        binding.infusor.setOnClickListener {
            dialogSmall(
                imageRes = R.drawable.apinfusao,
                text = "Catador de Balas",
                valorText = "500",
                detailsOneText = "detalhes1",
                detailsTwoText = "detalhes2",
                detailsThreeText = "detalhes3",
                componentText = "catador"
            )
        }



    }
}
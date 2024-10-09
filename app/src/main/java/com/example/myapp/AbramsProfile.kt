package com.example.myapp

import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapp.databinding.ActivityAbramsProfileBinding
import com.google.android.gms.ads.AdRequest

class AbramsProfile : AppCompatActivity() {

    private lateinit var binding: ActivityAbramsProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAbramsProfileBinding.inflate(layoutInflater)
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

        binding.skillq.setOnClickListener {
            binding.layoutskills.visibility = View.VISIBLE
            binding.skillselect.text = "Siphon Life"
            binding.skilldescription.text =
                "Escorra a saúde dos inimigos à sua frente enquanto eles estão no raio."
            binding.skillrange.text = "10m"
            binding.skillduration.text = "Duração: 4s"
            binding.skilltime.text = "42s recarga"
            binding.skilldetailone.text = "35 Dano por Segundo"
            binding.skilldetailtwo.text = "100% Cura vs Heróis"
            binding.skilldetailthree.text = "50% Cura vs Não Heróis"
            binding.skillleveldetail.text = "-20s Recarga"
            binding.skillleveldetailtwo.text = "+2s Duração "
            binding.skillleveldetailthree.text = "+40 Dano por Segundo"
        }
        binding.skille.setOnClickListener {
            binding.layoutskills.visibility = View.VISIBLE
            binding.skillselect.text = "Shoulder Charge "
            binding.skilldescription.text =
                "Corre para a frente colidindo com inimigos e arrastándo. Bater em uma parede Atordoa inimigos capturados por Abrams. Velocidade aumentada após colidir com Heróis inimigos."
            binding.skillrange.text = "Na"
            binding.skillduration.text = "1.2s Duração "
            binding.skilltime.text = "37s Recarga "
            binding.skilldetailone.text = "Na"
            binding.skilldetailtwo.text = "40 Danos"
            binding.skilldetailthree.text = "0.85s Duração do Atordoamento"
            binding.skillleveldetail.text = "- 20s Recarga "
            binding.skillleveldetailtwo.text = "+0,5s Duração "
            binding.skillleveldetailthree.text =
                "+5.5 Dano de Arma por 8s depois de colidir com um inimigo"
        }
        binding.skillc.setOnClickListener {
            binding.layoutskills.visibility = View.VISIBLE
            binding.skillselect.text = "Infernal Resilience"
            binding.skilldescription.text =
                "Regenerar uma parte do dano recebido ao longo do tempo."
            binding.skillrange.text = "15% de Dano Regenerado"
            binding.skillduration.text = "tempo de Regeneração 18S"
            binding.skilltime.text = "+1 Regen Saúde"
            binding.skilldetailone.text = "Na"
            binding.skilldetailtwo.text = "Na"
            binding.skilldetailthree.text = "Na"
            binding.skillleveldetail.text = "+1.5 Regeneração de Saúde"
            binding.skillleveldetailtwo.text = "+150 Saúde"
            binding.skillleveldetailthree.text = "+8% Dano Regenerado"
        }
        binding.skillx.setOnClickListener {
            binding.layoutskills.visibility = View.VISIBLE
            binding.skillselect.text = "Seismic Impact"
            binding.skilldescription.text =
                "Salte alto no ar e escolha um local no chão para esmagar. Quando você bate no chão, todos os inimigos no raio estão danificados e atordoados. Pressione [LMC] para travar mais cedo."
            binding.skillrange.text = "1s Duração do Atordoamento"
            binding.skillduration.text = "impacto de 9M Raio"
            binding.skilltime.text = "159 Recarga "
            binding.skilldetailone.text = "Na"
            binding.skilldetailtwo.text = "150 Danos"
            binding.skilldetailthree.text = ""
            binding.skillleveldetail.text = "recarga dos anos 40\n" +
                    "\n"
            binding.skillleveldetailtwo.text = "Ganhe 100 Max HP e 15% de Taxa de Fogo po"
            binding.skillleveldetailthree.text =
                "No elenco, torne-se Imune ao Atordoamento, Silêncio, Sono"
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

    }
}
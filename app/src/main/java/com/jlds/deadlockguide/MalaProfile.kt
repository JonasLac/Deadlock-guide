package com.jlds.deadlockguide

import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapp.R
import com.example.myapp.databinding.ActivityMalaProfileBinding
import com.google.android.gms.ads.AdRequest

class MalaProfile : AppCompatActivity() {
    private lateinit var binding: ActivityMalaProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMalaProfileBinding.inflate(layoutInflater)
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
        binding.skillq.setOnClickListener {
            binding.layoutskills.visibility = View.VISIBLE
            binding.skillselect.text = "Barrage "
            binding.skilldescription.text =
                "Canaliza para começar a lançar projéteis que causar dano e aplicar movimento lento em torno do seu ponto de impacto. Cada projétil pousado em um herói lhe concede um buff de empilhamento que amplifica todo o seu dano.\n" +
                        "\n" +
                        "Se você lançá-lo no ar, você vai flutuar e mantenha qualquer impulso horizontal com o qual você começou"
            binding.skillrange.text = "2s Hora de Canalização"
            binding.skillduration.text = "6.5m Raio "
            binding.skilltime.text = "32s Recarga "
            binding.skilldetailone.text = "4 Quantidade de Projéteis"
            binding.skilldetailtwo.text = "35 Danos por Projétil"
            binding.skilldetailthree.text = "30% Movimento Lento"
            binding.skillleveldetail.text = "+15 Dano por Projétil"
            binding.skillleveldetailtwo.text = "15 Recarga"
            binding.skillleveldetailthree.text = "+4% Amp Por Pilha"
        }
        binding.skillq.setOnClickListener {
            binding.layoutskills.visibility = View.VISIBLE
            binding.skillselect.text = "Flying Cloak"
            binding.skilldescription.text =
                "Lançar um manto senciente que viaja para a frente e danos inimigos. Você pode pressionar [2] para teletransporte para a sua localização"
            binding.skillrange.text = "5m Raio "
            binding.skillduration.text = "3.2s Vida"
            binding.skilltime.text = "32s Recarga "
            binding.skilldetailone.text = ""
            binding.skilldetailtwo.text = "90 Danos"
            binding.skilldetailthree.text = ""
            binding.skillleveldetail.text = "15 Recarga "
            binding.skillleveldetailtwo.text = "+80 Danos"
            binding.skillleveldetailthree.text =
                "+7 Dano de Arma por 10s após teletransporte com Manto Voador."
        }
        binding.skillq.setOnClickListener {
            binding.layoutskills.visibility = View.VISIBLE
            binding.skillselect.text = "Enchanter's Satchel"
            binding.skilldescription.text =
                "Fugir na sua mala. Quando a duração terminar, causar dano para inimigos próximos. A duração pode ser terminada cedo, realizando qualquer ação."
            binding.skillrange.text = "12m Raio"
            binding.skillduration.text = ""
            binding.skilltime.text = "17s Recarga"
            binding.skilldetailone.text = "2s Duração da fuga"
            binding.skilldetailtwo.text = ""
            binding.skilldetailthree.text = "100 Danos"
            binding.skillleveldetail.text = "-5s Recarga "
            binding.skillleveldetailtwo.text = "+80 Danos"
            binding.skillleveldetailthree.text = "Aplica 40% de Taxa de Incêndio Lenta para 4s"
        }
        binding.skillq.setOnClickListener {
            binding.layoutskills.visibility = View.VISIBLE
            binding.skillselect.text = "Affliction"
            binding.skilldescription.text =
                "Aplicar danos ao longo do tempo para todos os inimigos próximos. O dano da aflição não é letal e não aplica procs de itens."
            binding.skillrange.text = "14m Raio "
            binding.skillduration.text = ""
            binding.skilltime.text = "127 Recarga "
            binding.skilldetailone.text = "23 DPS"
            binding.skilldetailtwo.text = ""
            binding.skilldetailthree.text = "duração do Debuff de 18s"
            binding.skillleveldetail.text = "30 Recarga "
            binding.skillleveldetailtwo.text = "Suprimir a cura dos alvos por - 60%"
            binding.skillleveldetailthree.text = "+27 DPS"
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
    }
}
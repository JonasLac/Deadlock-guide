package com.jlds.deadlockguide

import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapp.R
import com.example.myapp.databinding.ActivityParadoxaProfile2Binding
import com.google.android.gms.ads.AdRequest
import com.jlds.deadlockguide.base.BaseActivity

class ParadoxaProfile : BaseActivity() {

    private lateinit var binding: ActivityParadoxaProfile2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityParadoxaProfile2Binding.inflate(layoutInflater)

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
            binding.skillselect.text = "Pulse Grenade"
            binding.skilldescription.text =
                "Jogue uma granada que começa a pulsar quando ela pousa. Cada pulso se aplica dano, movimento lento e amplificação de dano de empilhamento paradoxo contra a vítima."
            binding.skillrange.text = "7m Raio "
            binding.skillduration.text = "4 Pulsos"
            binding.skilltime.text = "28s Recarga "
            binding.skilldetailone.text = "intervalo de pulso de 0.8S"
            binding.skilldetailtwo.text = "45 Danos de Pulso"
            binding.skilldetailthree.text = "5% Amp de Dano por Pilha"
            binding.skillleveldetail.text = "+1 Pulsos"
            binding.skillleveldetailtwo.text = "CD -8s"
            binding.skillleveldetailthree.text = "+45 Dano de Pulso, +2% Amp de Dano"
        }
        binding.skille.setOnClickListener {
            binding.layoutskills.visibility = View.VISIBLE
            binding.skillselect.text = "Time Wall "
            binding.skilldescription.text =
                "Crie uma parede de distorção do tempo que pára o tempo para todos os inimigos projéteis e balas que o toca. Inimigos que tocam a parede levarão danos como uma porcentagem de sua saúde máxima e ser brevemente retardado."
            binding.skillrange.text = "7s Duração "
            binding.skillduration.text = "8s Recarga Entre Cargas"
            binding.skilltime.text = "37s Recarga "
            binding.skilldetailone.text = "largura da parede de 7M"
            binding.skilldetailtwo.text = "3.5m Altura da parede"
            binding.skilldetailthree.text = "1 Cobranças"
            binding.skillleveldetail.text = "+2m Largura, +1m Altura"
            binding.skillleveldetailtwo.text = "+1 Cobranças"
            binding.skillleveldetailthree.text =
                "Inimigos que tocam o Time Wall serão silenciados por 3s"
        }
        binding.skillc.setOnClickListener {
            binding.layoutskills.visibility = View.VISIBLE
            binding.skillselect.text = "Kinetic Carbine"
            binding.skilldescription.text =
                "Comece a carregar sua arma e ganhe maior velocidade de movimento quando estiver totalmente carregada. Seu próximo tiro vai liberar a energia, lidando dano espiritual e aplicando um tempo parar para o inimigo atingido. O dano causado é uma amplificação do dano da sua arma atual."
            binding.skillrange.text = "+85% Amplificador de Dano Máximo"
            binding.skillduration.text = "+25% Amplificador de Dano Mínimo"
            binding.skilltime.text = "30s Recarga"
            binding.skilldetailone.text = "0.25s Min Parada Duração "
            binding.skilldetailtwo.text = "25% Velocidade de Bônus"
            binding.skilldetailthree.text = "0.5s Parada Máxima Duração"
            binding.skillleveldetail.text = "+0.5s Paragem Máxima Duração "
            binding.skillleveldetailtwo.text = " CD 10s e +2s Speed Boost Duração "
            binding.skillleveldetailthree.text = "+50% Amplificador de Dano Máximo"
        }
        binding.skillx.setOnClickListener {
            binding.layoutskills.visibility = View.VISIBLE
            binding.skillselect.text = "Paradoxical Swap"
            binding.skilldescription.text =
                "Disparar um projétil que troca sua posição com o herói inimigo alvo. Enquanto o efeito ocorre, você ganha estilo de vida espiritual e o herói inimigo leva dano ao longo do tempo."
            binding.skillrange.text = "30m Gama "
            binding.skillduration.text = ""
            binding.skilltime.text = "48s Recarga "
            binding.skilldetailone.text = "125 Dano de Troca"
            binding.skilldetailtwo.text = ""
            binding.skilldetailthree.text = "100% Feitiço Lifesteal"
            binding.skillleveldetail.text = "+15m Cast Range"
            binding.skillleveldetailtwo.text = "+100 Dano de Troca"
            binding.skillleveldetailthree.text = "15 Recarga "
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
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
import com.example.myapp.databinding.ActivityChicoProfileBinding
import com.google.android.gms.ads.AdRequest
import com.jlds.deadlockguide.base.BaseActivity

class ChicoProfile : BaseActivity() {

    private lateinit var binding: ActivityChicoProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChicoProfileBinding.inflate(layoutInflater)
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
            binding.skillselect.text = "Ground Strike"
            binding.skilldescription.text =
                "Pise o chão abaixo de você danificar inimigos na sua frente. Se você executar Ground Strike enquanto estiver no ar, você rapidamente mergulha em direção ao chão. O dano cresce mais lentamente após 25m"
            binding.skillrange.text = "11m Raio"
            binding.skillduration.text = "Na"
            binding.skilltime.text = "19s Recarga"
            binding.skilldetailone.text = "90 Danos de Stomp"
            binding.skilldetailtwo.text = "Na"
            binding.skilldetailthree.text = "6 Dano Por Medidor"
            binding.skillleveldetail.text = "- 10s Recarga"
            binding.skillleveldetailtwo.text =
                "Os inimigos atingidos são lançados no ar e desacelerados em 50% por 3s"
            binding.skillleveldetailthree.text = "Dano por Medidor +110% e melhor dimensionamento"
        }
        binding.skille.setOnClickListener {
            binding.layoutskills.visibility = View.VISIBLE
            binding.skillselect.text = "Grapple "
            binding.skilldescription.text =
                "Puxe-se pelo ar em direção a um alvo. Usando Grapple também restaura uma carga de resistência e tudo saltos de ar e traços"
            binding.skillrange.text = "1 Carga"
            binding.skillduration.text = "2s Recarga Entre Cargas"
            binding.skilltime.text = "42s Recarga"
            binding.skilldetailone.text = "30m Gama"
            binding.skilldetailtwo.text = "20m/s Velocidade de Salto"
            binding.skilldetailthree.text = "Na"
            binding.skillleveldetail.text = "CD dos anos 20"
            binding.skillleveldetailtwo.text = "+20m Cast Range e ganho +6 Dano de Arma por 10s"
            binding.skillleveldetailthree.text = "+20% Taxa de Incêndio para Bónus de Armas Buff"
        }
        binding.skillc.setOnClickListener {
            binding.layoutskills.visibility = View.VISIBLE
            binding.skillselect.text = "Flog"
            binding.skilldescription.text =
                "Ataca os inimigos com o teu chicote roubar a vida deles"
            binding.skillrange.text = "25m Gama"
            binding.skillduration.text = "80% Cura vs heróis"
            binding.skilltime.text = "26s Recarga"
            binding.skilldetailone.text = "65 Danos"
            binding.skilldetailtwo.text = "30% Cura vs não-heróis"
            binding.skilldetailthree.text = "Ângulo de Ataque 30°"
            binding.skillleveldetail.text = "Aplique 35% de Movimento Lento por 3s"
            binding.skillleveldetailtwo.text = "CD 15s"
            binding.skillleveldetailthree.text = "+105 Dano e aplica 35% de Taxa de Incêndio Lenta"
        }
        binding.skillx.setOnClickListener {
            binding.layoutskills.visibility = View.VISIBLE
            binding.skillselect.text = "Death Slam"
            binding.skilldescription.text =
                "Concentre-se nos inimigos para conectar chicotes a eles. Após a canalização, os inimigos conectados são levantado e atordoado então bateu no chão. Suas vítimas e quaisquer inimigos na zona de pouso serão danificado e retardado."
            binding.skillrange.text = "2s Hora de Canalização"
            binding.skillduration.text = "18m Raio"
            binding.skilltime.text = "138s Recarga"
            binding.skilldetailone.text = "115 Danos"
            binding.skilldetailtwo.text = "4s Lento Duração"
            binding.skilldetailthree.text = "3s Tempo de Carga"
            binding.skillleveldetail.text = "+8m Distância Máxima de Lançamento"
            binding.skillleveldetailtwo.text = "+100 Danos"
            binding.skillleveldetailthree.text = "-60s Recarga"
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
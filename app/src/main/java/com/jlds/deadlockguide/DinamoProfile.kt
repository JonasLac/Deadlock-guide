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
import com.example.myapp.databinding.ActivityDinamoProfileBinding
import com.google.android.gms.ads.AdRequest

class DinamoProfile : AppCompatActivity() {

    private lateinit var binding: ActivityDinamoProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDinamoProfileBinding.inflate(layoutInflater)

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
            binding.skillselect.text = "Kinetic Pulse"
            binding.skilldescription.text =
                "Libere um pulso de energia que derruba os inimigos no ar"
            binding.skillrange.text = "1 Cobranças"
            binding.skillduration.text = "5s Recarga Entre Cargas"
            binding.skilltime.text = "26s Recarga"
            binding.skilldetailone.text = "100 Danos"
            binding.skilldetailtwo.text = "faixa de Stomp de 15M"
            binding.skilldetailthree.text = "largura da Habilidade 5M"
            binding.skillleveldetail.text =
                "Os inimigos atingidos são a taxa de disparo e o movimento desacelerado em 35% por 4s."
            binding.skillleveldetailtwo.text =
                "Dínamo causa 30% a mais de Dano de Arma para acertar inimigos por 8s"
            binding.skillleveldetailthree.text = "+125 Danos"
        }
        binding.skille.setOnClickListener {
            binding.layoutskills.visibility = View.VISIBLE
            binding.skillselect.text = "Quantum Entanglement"
            binding.skilldescription.text =
                "Dínamo brevemente desaparece no vazio e então reaparece a uma curta distância. Ao reaparecer, a tua arma é recarregado e tem um bônus de taxa de fogo para o próximo clipe. Pode ser lançado com [M3] para também trazer aliados próximos e dar-lhes metade bônus de taxa de fogo."
            binding.skillrange.text = "9m Gama"
            binding.skillduration.text = "9m Ally Distância"
            binding.skilltime.text = "12.5s Recarga"
            binding.skilldetailone.text = "1.4s Tempo de Vazio"
            binding.skilldetailtwo.text = "25% Bônus de Taxa de Fogo"
            binding.skilldetailthree.text = "Na"
            binding.skillleveldetail.text = "+4m Elenco Gama"
            binding.skillleveldetailtwo.text = "+25% Bónus de Taxa de Incêndio"
            binding.skillleveldetailthree.text = "Ao reaparecer, +120% de munição base"
        }
        binding.skillc.setOnClickListener {
            binding.layoutskills.visibility = View.VISIBLE
            binding.skillselect.text = "Rejuvenating Aurora"
            binding.skilldescription.text =
                "Enquanto canaliza, restaurar a saúde ao longo do tempo para você e quaisquer aliados próximos."
            binding.skillrange.text = "32/s Saúde Restaurada"
            binding.skillduration.text = "Na"
            binding.skilltime.text = "48s Recarga "
            binding.skilldetailone.text = "canal 5S Duração "
            binding.skilldetailtwo.text = "Na"
            binding.skilldetailthree.text = "8m Cura Amigável Raio"
            binding.skillleveldetail.text =
                "Ganhe +4m/s de bónus de velocidade móvel para 8s se o Aurora estiver totalmente canalizado. Ganhe instantaneamente com a atualização 5AP."
            binding.skillleveldetailtwo.text = "15 Recarga"
            binding.skillleveldetailthree.text =
                "Movimentação total e uso de habilidade e, adicionalmente, cura +3,8% do Max Health por segundo"
        }
        binding.skillx.setOnClickListener {
            binding.layoutskills.visibility = View.VISIBLE
            binding.skillselect.text = "Singularity"
            binding.skilldescription.text =
                "Crie uma singularidade em suas mãos que puxa inimigos próximos e os danifica. Uma vez terminado, os inimigos são derrubados no ar."
            binding.skillrange.text = "canal 2.75S Duração"
            binding.skillduration.text = "Na"
            binding.skilltime.text = "191 Recarga "
            binding.skilldetailone.text = "60 DPS"
            binding.skilldetailtwo.text = "Na"
            binding.skilldetailthree.text = "raio de Singularidade de 7M"
            binding.skillleveldetail.text = "+2m Singularidade Raio "
            binding.skillleveldetailtwo.text = "+0,75 Canal Duração "
            binding.skillleveldetailthree.text =
                "Singularidade leva 3,8% da vida máxima dos inimigos a cada segundo"
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
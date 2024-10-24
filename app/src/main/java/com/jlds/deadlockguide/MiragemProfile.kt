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
import com.example.myapp.databinding.ActivityMiragemProfileBinding
import com.google.android.gms.ads.AdRequest

class MiragemProfile : AppCompatActivity() {
    private lateinit var binding: ActivityMiragemProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMiragemProfileBinding.inflate(layoutInflater)
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
            binding.skillselect.text = "Tornado "
            binding.skilldescription.text =
                "Transforme-se em um tornado que viaja para a frente danificar inimigos e levantando-os no ar. Depois de sair do tornado, você ganha evasão de balas."
            binding.skillrange.text = "0.75s Duração "
            binding.skillduration.text = "32s Recarga "
            binding.skilltime.text = "3.5m Raio "
            binding.skilldetailone.text = "70 Danos"
            binding.skilldetailtwo.text = "1.1 Elevador Duração "
            binding.skilldetailthree.text = "25% Chance de Evasão de Bala"
            binding.skillleveldetail.text = "+0.4s Duração do Elevador"
            binding.skillleveldetailtwo.text = "14 Recarga "
            binding.skillleveldetailthree.text = "+20% Chance de Evasão de Bala"
        }
        binding.skille.setOnClickListener {
            binding.layoutskills.visibility = View.VISIBLE
            binding.skillselect.text = "Fire Scarabs"
            binding.skilldescription.text =
                "Comece a lançar escaravelhos de fogo. Cada escaravelho pode ser lançado separadamente, roubar saúde máxima dos inimigos e aplicando bala resiste à redução. Não é possível aplicar vários escaravelhos ao mesmo inimigo. O ganho de saúde de bater heróis é 3x mais eficaz contra não-heróis."
            binding.skillrange.text = "4 Cobranças "
            binding.skillduration.text = "0s Recarga Entre Cargas"
            binding.skilltime.text = "90 Max Roubo de Saúde"
            binding.skilldetailone.text = "10% Resistência à Bala"
            binding.skilldetailtwo.text = "32s Recarga "
            binding.skilldetailthree.text = "25% Cura vs Não Heróis"
            binding.skillleveldetail.text = "recarga de 15s"
            binding.skillleveldetailtwo.text = "15% Resistência à Bala"
            binding.skillleveldetailthree.text = "+70 Max Roubo de Saúde"
        }
        binding.skillc.setOnClickListener {
            binding.layoutskills.visibility = View.VISIBLE
            binding.skillselect.text = "Djinn's Mark"
            binding.skilldescription.text =
                "Passivo: Seus tiros aplique um multiplicador crescente no alvo. Quando o multiplicador em um alvo expira ou você atinge o máximo, ele é consumido e o alvo sofre Dano do Espírito e é brevemente revelado no mapa. O dano final é o dano base vezes o multiplicador."
            binding.skillrange.text = "multiplicador Máximo 8X"
            binding.skillduration.text = "multiplicador Máximo 8X"
            binding.skilltime.text = "duração do Multiplicador 4.5S"
            binding.skilldetailone.text = "2s Revelar Duração"
            binding.skilldetailtwo.text =
                "Ativo: Consumir multiplicador da Marca de Djinn para causar dano agora."
            binding.skilldetailthree.text = ""
            binding.skillleveldetail.text =
                "Aplique 80% Lento por 0,5s sempre que o multiplicador for 2x ou superior"
            binding.skillleveldetailtwo.text = "+4s Duração do Multiplicador e +10 Dano Base"
            binding.skillleveldetailthree.text =
                "- 0.5s Recarga Entre Multiplicador e +4 Multiplicador Máximo"
        }
        binding.skillx.setOnClickListener {
            binding.layoutskills.visibility = View.VISIBLE
            binding.skillselect.text = "Traveler"
            binding.skilldescription.text =
                "Canalizado. Alvo um aliado ou herói inimigo visível no minimapa, então teletransporte onde estavam quando o canal começou. Depois de se teletransportar, você ganha velocidade do movimento bem como taxa de disparo até a sua próxima recarga."
            binding.skillrange.text = "130 Recarga "
            binding.skillduration.text = "canal 2.5S Duração "
            binding.skilltime.text = "+2m/s Velocidade de Movimento"
            binding.skilldetailone.text = "+20% Taxa de Incêndio"
            binding.skilldetailtwo.text = "4s Velocidade de Movimento Duração "
            binding.skilldetailthree.text = ""
            binding.skillleveldetail.text = "- 20s Recarga"
            binding.skillleveldetailtwo.text = "+2 m/s Velocidade de Movimento"
            binding.skillleveldetailthree.text = "+20% Taxa de Incêndio"
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
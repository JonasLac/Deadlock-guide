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
import com.example.myapp.databinding.ActivityInfernosProfileBinding

class infernosProfile : AppCompatActivity() {

    private lateinit var binding: ActivityInfernosProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityInfernosProfileBinding.inflate(layoutInflater)

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
            binding.skillselect.text = "Catalyst"
            binding.skilldescription.text = "Spw napalm que retarda o movimento inimigo e amplifica o dano O Infernus faz-lhes isso."
            binding.skillrange.text = "1 Cobranças "
            binding.skillduration.text = "6s Recarga Entre Cargas "
            binding.skilltime.text = "25s Recarga "
            binding.skilldetailone.text = "20m Gama "
            binding.skilldetailtwo.text = "50 Danos"
            binding.skilldetailthree.text = "40% Movimento Lento"
            binding.skillleveldetail.text = "+1 Encargos"
            binding.skillleveldetailtwo.text = "Infernus ganha 15% de Lifesteal contra vítimas"
            binding.skillleveldetailthree.text = "+15% Amplificação de Danos e -40% Cura/Regeneração"
        }
        binding.skille.setOnClickListener {
            binding.layoutskills.visibility = View.VISIBLE
            binding.skillselect.text = "Flame Dash"
            binding.skilldescription.text = "Avançar em alta velocidade e deixar uma trilha de chamas que queima inimigos. Segure [LMC] para correr mais rápido."
            binding.skillrange.text = "20m/s Max Dash Velocidade"
            binding.skillduration.text = "40 DPS"
            binding.skilltime.text = "40s Recarga "
            binding.skilldetailone.text = "tempo Dash 3S"
            binding.skilldetailtwo.text = "velocidade de traço de 12M/S"
            binding.skilldetailthree.text = "trilha 4S Duração"
            binding.skillleveldetail.text = "+30% Taxa de Incêndio Lenta para 6s"
            binding.skillleveldetailtwo.text = "+45 DPS"
            binding.skillleveldetailthree.text = "CD dos anos 20"
        }
        binding.skillc.setOnClickListener {
            binding.layoutskills.visibility = View.VISIBLE
            binding.skillselect.text = "Afterburn"
            binding.skilldescription.text = "Suas balas se acumulam aplique um efeito de queima nos inimigos. As balas e habilidades do Inferno vão refrescar a duração."
            binding.skillrange.text = "15 DPS"
            binding.skillduration.text = "3s Queimam Duração "
            binding.skilltime.text = ""
            binding.skilldetailone.text = "10% Acúmulo por bala"
            binding.skilldetailtwo.text = "16% Acúmulo de tiro na cabeça"
            binding.skilldetailthree.text = "15s Tempo de Decadência de Acúmulo"
            binding.skillleveldetail.text = "Vítimas lidam - 30% Dano Espiritual."
            binding.skillleveldetailtwo.text = "+1s Queimam Duração "
            binding.skillleveldetailthree.text = "+30 DPS"
        }
        binding.skillx.setOnClickListener {
            binding.layoutskills.visibility = View.VISIBLE
            binding.skillselect.text = "Concussive Combustion"
            binding.skilldescription.text = "Transforme-se em uma bomba viva que explode após um curto atraso atordoando todos os inimigos em seu raio."
            binding.skillrange.text = "12m Gama"
            binding.skillduration.text = "160 Danos"
            binding.skilltime.text = "127 Recarga"
            binding.skilldetailone.text = "atordoamento de 1.25s Duração"
            binding.skilldetailtwo.text = "atraso de Explosão 3S"
            binding.skilldetailthree.text = ""
            binding.skillleveldetail.text = "40 Recarga "
            binding.skillleveldetailtwo.text = "+0,5 Atordoamento Duraçãoe +4m Raio"
            binding.skillleveldetailthree.text = "+115 Dano e 100% lifesteal de heróis inimigos atingidos"
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
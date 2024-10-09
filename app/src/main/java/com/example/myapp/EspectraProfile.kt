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
import com.example.myapp.databinding.ActivityEspectraProfileBinding

class EspectraProfile : AppCompatActivity() {
    private lateinit var binding: ActivityEspectraProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEspectraProfileBinding.inflate(layoutInflater)
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
            binding.skillselect.text = "Card Trick"
            binding.skilldescription.text = "Cause dano de arma para invocar cartas. Ative para jogar uma carta que voa em direção ao inimigo ou apontar sob sua mira."
            binding.skillrange.text = "5m Raio "
            binding.skillduration.text = ""
            binding.skilltime.text = "0.75s Recarga "
            binding.skilldetailone.text = "80 Danos"
            binding.skilldetailtwo.text = ""
            binding.skilldetailthree.text = "1 Cobranças "
            binding.skillleveldetail.text = "+1 Cobranças"
            binding.skillleveldetailtwo.text = "+50 Danos"
            binding.skillleveldetailthree.text = "+50% Taxa de Invocação de Cartão"
        }
        binding.skille.setOnClickListener {
            binding.layoutskills.visibility = View.VISIBLE
            binding.skillselect.text = "Project Mind"
            binding.skilldescription.text = "Teletransporte para o local alvo."
            binding.skillrange.text = "25m Gama "
            binding.skillduration.text = "Na"
            binding.skilltime.text = "48s Recarga "
            binding.skilldetailone.text = ""
            binding.skilldetailtwo.text = ""
            binding.skilldetailthree.text = ""
            binding.skillleveldetail.text = "+15m Cast Range"
            binding.skillleveldetailtwo.text = "Fornece um 300 Escudo de bala para 8s no teletransporte. A quantidade de Escudo escala com o Poder Espiritual."
            binding.skillleveldetailthree.text = "30 Recarga "
        }
        binding.skillc.setOnClickListener {
            binding.layoutskills.visibility = View.VISIBLE
            binding.skillselect.text = "Full Auto"
            binding.skilldescription.text = "Aumenta temporariamente o seu taxa de incêndio. Aliados próximos recebem metade do bônus de taxa de fogo."
            binding.skillrange.text = "25m Raio "
            binding.skillduration.text = "Na"
            binding.skilltime.text = "48s Recarga"
            binding.skilldetailone.text = "5s Duração"
            binding.skilldetailtwo.text = "Na"
            binding.skilldetailthree.text = "+20% Taxa de Incêndio"
            binding.skillleveldetail.text = "15 Recarga "
            binding.skillleveldetailtwo.text = "+5 Dano Espiritual Por Bala"
            binding.skillleveldetailthree.text = "+35% Bala Lifesteal"
        }
        binding.skillx.setOnClickListener {
            binding.layoutskills.visibility = View.VISIBLE
            binding.skillselect.text = "Telekinesis"
            binding.skilldescription.text = "Levante um herói inimigo para o ar, e deslumbrante eles por um curto período de tempo. Quando o elevador termina, o alvo recebe dano de telecinese."
            binding.skillrange.text = "20m Gama "
            binding.skillduration.text = "Na"
            binding.skilltime.text = "1.25 Duração"
            binding.skilldetailone.text = "95s Recarga "
            binding.skilldetailtwo.text = "Na"
            binding.skilldetailthree.text = "200 Danos"
            binding.skillleveldetail.text = "30 Recarga "
            binding.skillleveldetailtwo.text = "+0,5s Duração "
            binding.skillleveldetailthree.text = "Telekinesis terá como alvo inimigos em uma área ao redor de Wraith"
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
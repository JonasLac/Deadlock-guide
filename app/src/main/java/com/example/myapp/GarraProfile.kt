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
import com.example.myapp.databinding.ActivityGarraProfileBinding

class GarraProfile : AppCompatActivity() {
    private lateinit var binding: ActivityGarraProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGarraProfileBinding.inflate(layoutInflater)
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
            binding.skillselect.text = "Charged Shot"
            binding.skilldescription.text =
                "Carregue um tiro poderoso que atravessa os inimigos. Segure [1] ou [LMC] para segurar o tiro"
            binding.skillrange.text = "1 Cobranças"
            binding.skillduration.text = "4s Recarga Entre Cargas"
            binding.skilltime.text = "17s Recarga"
            binding.skilldetailone.text = "Na"
            binding.skilldetailtwo.text = "100 Danos"
            binding.skilldetailthree.text = "Na"
            binding.skillleveldetail.text = "+1 Cobranças "
            binding.skillleveldetailtwo.text = "+65 Danos"
            binding.skillleveldetailthree.text = "Melhoria na escala de danos e - 3s Charge Delay"
        }
        binding.skille.setOnClickListener {
            binding.layoutskills.visibility = View.VISIBLE
            binding.skillselect.text = "Rain of Arrows"
            binding.skilldescription.text =
                "Lança-o no alto do ar, permitindo-lhe deslizar lentamente. Enquanto no ar, você ganha Dano de Arma e multishot na tua arma. Pressione [SPACE] para cancelar o deslizamento"
            binding.skillrange.text = "7s Duração "
            binding.skillduration.text = "Na"
            binding.skilltime.text = "35s Recarga "
            binding.skilldetailone.text = "5 Armas Multishot"
            binding.skilldetailtwo.text = "Na"
            binding.skilldetailthree.text = "+4 Dano de Arma"
            binding.skillleveldetail.text = "15 Recarga "
            binding.skillleveldetailtwo.text =
                "Enquanto no ar, +5 Dano de Arma e dano de arma aplica 40% de movimento lento para 1,5s"
            binding.skillleveldetailthree.text =
                "Enquanto Airborne, +50% Bullet Lifesteal e +50% Spirit Lifesteal"
        }
        binding.skillc.setOnClickListener {
            binding.layoutskills.visibility = View.VISIBLE
            binding.skillselect.text = "Immobilizing Trap"
            binding.skilldescription.text =
                "Jogue fora uma armadilha isso começa a se armar. Uma vez armada, a armadilha será acionada quando um inimigo entrar em seu raio imobilização eles."
            binding.skillrange.text = "6m Raio "
            binding.skillduration.text = "20s Vida"
            binding.skilltime.text = "37s Recarga "
            binding.skilldetailone.text =
                "1.25s Imobilizar Duração, seguido por 50% Movimento Lento"
            binding.skilldetailtwo.text = "30 Danos"
            binding.skilldetailthree.text = "tempo 2s"
            binding.skillleveldetail.text = "- 20s Recarga"
            binding.skillleveldetailtwo.text = "+2s Imobilizar Duração "
            binding.skillleveldetailthree.text =
                "Grey Talon +30% mais Dano de Bala aos inimigos atingidos por Armadilha Imobilizadora durante 10s"
        }
        binding.skillx.setOnClickListener {
            binding.layoutskills.visibility = View.VISIBLE
            binding.skillselect.text = "Guided Owl"
            binding.skilldescription.text =
                "Após o tempo de lançamento de 1,5s, o lance uma coruja espiritual que você controla e que explode no impacto, e prejudicial e impressionante inimigos. Segure [LMC] para acelerar a coruja. Pressione [SPACE] para liberar o controle. Ganho poder Espiritual Permanente para cada inimigo morto com Coruja Guiada"
            binding.skillrange.text = "14s Duração"
            binding.skillduration.text = "250 Danos"
            binding.skilltime.text = "127 Recarga"
            binding.skilldetailone.text = "raio de Explosão de 13M"
            binding.skilldetailtwo.text = "0.75s Duração do Atordoamento"
            binding.skilldetailthree.text = "5 Poder do Espírito Por Matar"
            binding.skillleveldetail.text = "+100 Danos"
            binding.skillleveldetailtwo.text = "- 50s Recarga"
            binding.skillleveldetailthree.text =
                "Depois de atingido, mata os inimigos que estão abaixo de 22% de Vida"
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
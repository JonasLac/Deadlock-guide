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
import com.example.myapp.databinding.ActivityGuardaProfileBinding

class GuardaProfile : AppCompatActivity() {
    private lateinit var binding: ActivityGuardaProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGuardaProfileBinding.inflate(layoutInflater)
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
            binding.skillselect.text = "Alchemical Flask"
            binding.skilldescription.text =
                "Jogue um frasco que danos, retarda, e reduz o dano arma e resistência de inimigos que atinge."
            binding.skillrange.text = "7m Raio"
            binding.skillduration.text = "CD 14s"
            binding.skilltime.text = "Na"
            binding.skilldetailone.text = "55 Danos"
            binding.skilldetailtwo.text = "20% Velocidade de Movimento Lenta"
            binding.skilldetailthree.text = "Na"
            binding.skillleveldetail.text = "+40 Danos"
            binding.skillleveldetailtwo.text = "+1 Redução de Resistência"
            binding.skillleveldetailthree.text =
                "-7s Recarga e aplica 35% de Taxa de Incêndio Lenta"
        }
        binding.skille.setOnClickListener {
            binding.layoutskills.visibility = View.VISIBLE
            binding.skillselect.text = "Willpower"
            binding.skilldescription.text =
                "Ganhar um escudo espiritual e velocidade de movimento bônus."
            binding.skillrange.text = "7s Duração "
            binding.skillduration.text = ""
            binding.skilltime.text = "42s Recarga "
            binding.skilldetailone.text = "150 Escudo Espiritual"
            binding.skilldetailtwo.text = ""
            binding.skilldetailthree.text = "15% Bônus de velocidade de movimento"
            binding.skillleveldetail.text = "+20% Bônus de velocidade de movimento"
            binding.skillleveldetailtwo.text = "- 20s Recarga"
            binding.skillleveldetailthree.text =
                "+200 Spirit Shield Saúde e agora escala com Spirit Power"
        }
        binding.skillc.setOnClickListener {
            binding.layoutskills.visibility = View.VISIBLE
            binding.skillselect.text = "Binding Word"
            binding.skilldescription.text =
                "Maldição um herói inimigo. Se eles não se afastarem de sua posição inicial dentro do tempo de fuga, eles serão danificado e imobilizado."
            binding.skillrange.text = "20m Gama "
            binding.skillduration.text = "37s Recarga "
            binding.skilltime.text = "2.5s Tempo de Fuga"
            binding.skilldetailone.text = "120 Danos"
            binding.skilldetailtwo.text = "1.75s Imobilizar a Duração"
            binding.skilldetailthree.text = "faixa de fuga de 16M"
            binding.skillleveldetail.text = "+1s Imobilizar Duração"
            binding.skillleveldetailtwo.text = "- 20s Recarga"
            binding.skillleveldetailthree.text =
                "Ofertas de diretor +20% mais Dano de Bala para heróis presos por 6s"
        }
        binding.skillx.setOnClickListener {
            binding.layoutskills.visibility = View.VISIBLE
            binding.skillselect.text = "Last Stand"
            binding.skilldescription.text =
                "Após o carregamento para 2.2s, libera pulsos que danificam inimigos e curam você com base nos danos causados. Ao canalizar Last Stand, você aumentou muito a resistência à bala."
            binding.skillrange.text = "12m Raio"
            binding.skillduration.text = "6s Duração"
            binding.skilltime.text = "138s Recarga"
            binding.skilldetailone.text = "100 DPS"
            binding.skilldetailtwo.text = "intervalo de pulso de 0,5S"
            binding.skilldetailthree.text = "100% Vida de Herói"
            binding.skillleveldetail.text = "+3m Raio "
            binding.skillleveldetailtwo.text = "+70 DPS"
            binding.skillleveldetailthree.text = "60 Recarga"
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
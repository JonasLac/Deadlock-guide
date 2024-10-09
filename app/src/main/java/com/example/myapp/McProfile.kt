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
import com.example.myapp.databinding.ActivityMcProfileBinding

class McProfile : AppCompatActivity() {
    private lateinit var binding: ActivityMcProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMcProfileBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(R.layout.activity_mc_profile)
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
            binding.skillselect.text = "Mini Turret"
            binding.skilldescription.text =
                "Implante uma Mini Torre que dispara automaticamente nos inimigos. A torre expira após uma vida útil limitada. As torres ganham 30% da saúde máxima de McGinnis’ e têm 60% de Resistência ao Espírito. Eles causam danos reduzidos a soldados e objetivos."
            binding.skillrange.text = "1 Cobranças "
            binding.skillduration.text = "15m Gama"
            binding.skilltime.text = "30s Recarga"
            binding.skilldetailone.text = "60 DPS torre"
            binding.skilldetailtwo.text = "alcance de Ataque de 25M"
            binding.skilldetailthree.text = "30s Vida"
            binding.skillleveldetail.text =
                "+1 Carga de Habilidade e torres aplicam +25% Movimento Lento"
            binding.skillleveldetailtwo.text =
                "+10m Faixa de Ataque e 10% taxa de disparo de torreta"
            binding.skillleveldetailthree.text = "+45 Torre DPS"
        }
        binding.skillq.setOnClickListener {
            binding.layoutskills.visibility = View.VISIBLE
            binding.skillselect.text = "Medicinal Specter"
            binding.skilldescription.text = "Implemente um espírito que cura unidades próximas."
            binding.skillrange.text = "15m Gama "
            binding.skillduration.text = "6s Duração "
            binding.skilltime.text = "48s Recarga "
            binding.skilldetailone.text = "raio de Cura de 5M"
            binding.skilldetailtwo.text = "+25/seg Regen Saúde"
            binding.skilldetailthree.text = ""
            binding.skillleveldetail.text =
                "+35% Taxa de Incêndio em unidades curadas pelo Espectro Medicinal"
            binding.skillleveldetailtwo.text = "18 Recarga "
            binding.skillleveldetailthree.text = "+5% Regeneração máxima de Saúde por segundo"
        }
        binding.skillq.setOnClickListener {
            binding.layoutskills.visibility = View.VISIBLE
            binding.skillselect.text = "Spectral Wall"
            binding.skilldescription.text =
                "Cria uma parede que divide o terreno ao meio. Na criação, o muro causa dano e aplica-se lento para inimigos próximos. Após a fundição, pressione [LMC] ou [3] para entrar em erupção na parede mais cedo."
            binding.skillrange.text = "50m Gama"
            binding.skillduration.text = "5s Duração "
            binding.skilltime.text = "37s Recarga "
            binding.skilldetailone.text = "64 Danos"
            binding.skilldetailtwo.text = "25% Movimento Lento"
            binding.skilldetailthree.text = "2.5s Lento Duração "
            binding.skillleveldetail.text =
                "Remove 1 resistência e amplifica o dano de McGinnis em 25% em inimigos atingidos por 7s"
            binding.skillleveldetailtwo.text = "15 Recarga "
            binding.skillleveldetailthree.text =
                "Adiciona um Atordoamento de 1s aos inimigos atingidos pela Parede Espectral"
        }
        binding.skillq.setOnClickListener {
            binding.layoutskills.visibility = View.VISIBLE
            binding.skillselect.text = "Heavy Barrage"
            binding.skilldescription.text =
                "Libera uma saraivada de foguetes que chegam a um local alvo."
            binding.skillrange.text = "50m Faixa alcance Mínimo de 6M"
            binding.skillduration.text = "30 Danos por Foguete"
            binding.skilltime.text = "106s Recarga "
            binding.skilldetailone.text = "6 Foguetes por segundo"
            binding.skilldetailtwo.text = "explosão de 4,5 M Raio "
            binding.skilldetailthree.text = "13s Hora de Canalização"
            binding.skillleveldetail.text = "Aplica 35% de Movimento Lento"
            binding.skillleveldetailtwo.text = "- 50s Recarga "
            binding.skillleveldetailthree.text = "+30 Danos por Foguete"
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
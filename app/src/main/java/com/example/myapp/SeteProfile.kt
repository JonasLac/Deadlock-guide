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
import com.example.myapp.databinding.ActivitySeteProfileBinding

class SeteProfile : AppCompatActivity() {
    private lateinit var binding: ActivitySeteProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySeteProfileBinding.inflate(layoutInflater)
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
            binding.skillselect.text = "Lightning Ball"
            binding.skilldescription.text = "Atire em uma bola de relâmpago que viaja em linha reta. Faz dano a todos os alvos em seu raio. Desacelera ao danificar inimigos e pára se atingir o mundo."
            binding.skillrange.text = "1 Cobranças "
            binding.skillduration.text = "8s Recarga Entre Cargas"
            binding.skilltime.text = "23s Recarga"
            binding.skilldetailone.text = "80 DPS"
            binding.skilldetailtwo.text = "4m Raio "
            binding.skilldetailthree.text = "vida 5S"
            binding.skillleveldetail.text = "+1 Cobranças "
            binding.skillleveldetailtwo.text = "+40% Lento Movimento"
            binding.skillleveldetailthree.text = "+70 DPS, +1m Raio "
        }
        binding.skille.setOnClickListener {
            binding.layoutskills.visibility = View.VISIBLE
            binding.skillselect.text = "Static Charge "
            binding.skilldescription.text = "Aplique uma carga a um herói inimigo alvo. Após uma curta duração, a carga estática atordoamentos e danos inimigos dentro do raio."
            binding.skillrange.text = "16m Gama "
            binding.skillduration.text = "6m Raio "
            binding.skilltime.text = "42s Recarga "
            binding.skilldetailone.text = "0.9s Atordoamento Duração "
            binding.skilldetailtwo.text = "atraso de 3,5S"
            binding.skilldetailthree.text = "40 Danos"
            binding.skillleveldetail.text = "- 20s Recarga "
            binding.skillleveldetailtwo.text = "+8m Raio "
            binding.skillleveldetailthree.text = "+0.9s Stun Duração"
        }
        binding.skillc.setOnClickListener {
            binding.layoutskills.visibility = View.VISIBLE
            binding.skillselect.text = "Power Surge"
            binding.skilldescription.text = "Ligue sua arma com um efeito de choque, fazendo suas balas causam dano de choque no seu alvo. Este dano choque salta para os inimigos perto do seu alvo. Ocorre uma vez por disparo de explosão."
            binding.skillrange.text = "10s Duração "
            binding.skillduration.text = "salto de 10m Raio"
            binding.skilltime.text = "48s Recarga "
            binding.skilldetailone.text = "10 Dano de Choque"
            binding.skilldetailtwo.text = "3 Saltos Máximos"
            binding.skilldetailthree.text = ""
            binding.skillleveldetail.text = "Dano de Choque se aplica - 15% Resistência ao Espírito para 8s"
            binding.skillleveldetailtwo.text = "16 Recarga "
            binding.skillleveldetailthree.text = "+12 Dano de Choque, aumento do Spirit e +3 Max Jumps"
        }
        binding.skillx.setOnClickListener {
            binding.layoutskills.visibility = View.VISIBLE
            binding.skillselect.text = "Storm Cloud"
            binding.skilldescription.text = "Canalize uma nuvem de tempestade em expansão ao seu redor que danifica todos os inimigos dentro do seu raio. Inimigos não recebem dano quando estão fora da linha de visão. Você aumentou o Bullet Resist durante o canal."
            binding.skillrange.text = "7s Hora de Canalização"
            binding.skillduration.text = "25m Raio"
            binding.skilltime.text = "148s Recarga"
            binding.skilldetailone.text = "110 DPS"
            binding.skilldetailtwo.text = "12m Inicial Raio"
            binding.skilldetailthree.text = "+20% Resistência à bala"
            binding.skillleveldetail.text = "+35% Resistência à bala enquanto canaliza a Storm Cloud"
            binding.skillleveldetailtwo.text = "+7s Channel Time e +10m Radius"
            binding.skillleveldetailthree.text = "+75 DPS"
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
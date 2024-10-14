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
import com.example.myapp.databinding.ActivityViscosoProfileBinding
import com.google.android.gms.ads.AdRequest

class ViscosoProfile : AppCompatActivity() {
    private lateinit var binding: ActivityViscosoProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViscosoProfileBinding.inflate(layoutInflater)
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

        binding.skillc.setOnClickListener {
            binding.layoutskills.visibility = View.VISIBLE
            binding.skillselect.text = "Puddle Punch "
            binding.skilldescription.text =
                "Materializar um punho no mundo que socos unidades na área e enviá-los voando. Inimigos serão dano causado, tenha sua distância de traço reduzida por um breve momento, e tenha sua movimento desacelerado. Isso é considerado como um Luz Melee ataque"
            binding.skillrange.text = "60m Gama "
            binding.skillduration.text = "4m Raio "
            binding.skilltime.text = "30s Recarga "
            binding.skilldetailone.text = "1 Cobranças "
            binding.skilldetailtwo.text = "1.5s Recarga Entre Cargas"
            binding.skilldetailthree.text = "4s Lento Duração "
            binding.skillleveldetail.text = "+1 Cobranças"
            binding.skillleveldetailtwo.text = "+35 de dano e +20% de movimento lento"
            binding.skillleveldetailthree.text = "-12s Recarga "
        }
        binding.skillx.setOnClickListener {
            binding.layoutskills.visibility = View.VISIBLE
            binding.skillselect.text = "Goo Ball"
            binding.skilldescription.text =
                "Morph em uma grande bola de gosma que causa dano e atordoar inimigos no impacto. A bola concede grandes quantidades de Bala e Espírito resistir, salta de paredes e pode salto duplo."
            binding.skillrange.text = "10s Duração "
            binding.skillduration.text = "140 Danos"
            binding.skilltime.text = "95s Recarga "
            binding.skilldetailone.text = "1s Atordoamento Duração"
            binding.skilldetailtwo.text = "70% Resistência ao Espírito"
            binding.skilldetailthree.text = "60% Resistência à bala"
            binding.skillleveldetail.text = "+5s Duração "
            binding.skillleveldetailtwo.text = "+120 Danos"
            binding.skillleveldetailthree.text =
                "Pode lançar habilidades e usar itens enquanto rola"
        }
        binding.skillq.setOnClickListener {
            binding.layoutskills.visibility = View.VISIBLE
            binding.skillselect.text = "Splatter "
            binding.skilldescription.text =
                "Jogue uma bola de gosma que causa dano e deixa poças de gosma atrás que se aplicam movimento lento para inimigos no raio"
            binding.skillrange.text = "5m Raio "
            binding.skillduration.text = "100 Danos"
            binding.skilltime.text = "21 Recarga "
            binding.skilldetailone.text = "35% Movimento Lento"
            binding.skilldetailtwo.text = "poça dos Anos 10 Duração "
            binding.skilldetailthree.text = ""
            binding.skillleveldetail.text = "6s Recarga"
            binding.skillleveldetailtwo.text = "+70 Danos e +1m Raio"
            binding.skillleveldetailthree.text = "Salta 2 vezes"
        }
        binding.skille.setOnClickListener {
            binding.layoutskills.visibility = View.VISIBLE
            binding.skillselect.text = "The Cube "
            binding.skilldescription.text =
                "Envolva o alvo em um cubo de gosma restauradora que protege contra danos e aumenta a regeneração da saúde.\n" +
                        "O alvo é não é possível tomar novas ações enquanto cubado. Pode ser usado em si mesmo. Imprensa [ESPAÇO] para fugir cedo."
            binding.skillrange.text = "30m Gama "
            binding.skillduration.text = ""
            binding.skilltime.text = "48s Recarga "
            binding.skilldetailone.text = "+40 Regen Saúde"
            binding.skilldetailtwo.text = ""
            binding.skilldetailthree.text = "4s Duração "
            binding.skillleveldetail.text =
                "Aumenta a Velocidade de Movimento e Recuperação de Resistência"
            binding.skillleveldetailtwo.text = "Remove todos os Debuffs e -21s Recarga "
            binding.skillleveldetailthree.text = "+60 Regen Saúde"
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
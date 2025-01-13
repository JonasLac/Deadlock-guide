package com.jlds.deadlockguide

import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapp.R
import com.example.myapp.databinding.ActivityMoKrillProfileBinding
import com.google.android.gms.ads.AdRequest
import com.jlds.deadlockguide.base.BaseActivity

class MoKrillProfile : BaseActivity() {
    private lateinit var binding: ActivityMoKrillProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMoKrillProfileBinding.inflate(layoutInflater)
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
            binding.skillselect.text = "Scorn "
            binding.skilldescription.text =
                "Causa dano para inimigos próximos e cure-se com base nos danos causados. A cura é mais forte contra os heróis inimigos."
            binding.skillrange.text = "10m Raio "
            binding.skillduration.text = "60 Danos"
            binding.skilltime.text = "12.5s Recarga "
            binding.skilldetailone.text = "2x Dano de Herói para Curar"
            binding.skilldetailtwo.text = "0.7x Dano à Cura"
            binding.skilldetailthree.text = ""
            binding.skillleveldetail.text = "4s Recarga "
            binding.skillleveldetailtwo.text = "+25 Danos"
            binding.skillleveldetailthree.text =
                "Adiciona um debuff aos inimigos que permite que Mo & Krill cause +15% de dano a eles. Empilha e dura 16s."
        }
        binding.skille.setOnClickListener {
            binding.layoutskills.visibility = View.VISIBLE
            binding.skillselect.text = "Burrow "
            binding.skilldescription.text =
                "Toca subterrânea movendo-se mais rápido, e ganhando armadura de espírito e bala. Dano de heróis inimigos irá reduzir o bônus de velocidade. Quando você saltar para fora, derrubar os inimigos no ar e realizar um ataque de giro que danos e retarda. A recarga começa quando Burrow termina."
            binding.skillrange.text = "5s Tempo de Burrow"
            binding.skillduration.text = "5m Raio "
            binding.skilltime.text = "37s Recarga "
            binding.skilldetailone.text = "+4 m/s Velocidade de Movimento"
            binding.skilldetailtwo.text = "80 DPS"
            binding.skilldetailthree.text = "+80% Resistência à Bala"
            binding.skillleveldetail.text = "Tempo de toca +3s"
            binding.skillleveldetailtwo.text = "+140 Spin DPS e +2 Raio "
            binding.skillleveldetailthree.text = "-20 CD e +2m/s Velocidade de Movimento"
        }
        binding.skillc.setOnClickListener {
            binding.layoutskills.visibility = View.VISIBLE
            binding.skillselect.text = "Sand Blast"
            binding.skilldescription.text =
                "Pulverize areia que desarmar inimigos na frente de você e ofertas dano"
            binding.skillrange.text = "35m Gama "
            binding.skillduration.text = "3.5s Duração"
            binding.skilltime.text = "42s Recarga "
            binding.skilldetailone.text = ""
            binding.skilldetailtwo.text = "40 Danos"
            binding.skilldetailthree.text = ""
            binding.skillleveldetail.text = "+1s Duração "
            binding.skillleveldetailtwo.text = "recarga dos Anos 20"
            binding.skillleveldetailthree.text = "+Alvos lentos por -50%"
        }
        binding.skillx.setOnClickListener {
            binding.layoutskills.visibility = View.VISIBLE
            binding.skillselect.text = "Combo "
            binding.skilldescription.text =
                "Mantem o alvo no lugar atordoando e causando dano durante o canal."
            binding.skillrange.text = "2.5s Duração "
            binding.skillduration.text = "5m Gama"
            binding.skilltime.text = "95s Recarga "
            binding.skilldetailone.text = "60 DPS"
            binding.skilldetailtwo.text = "30 Bônus de Saúde Máxima Por Matar"
            binding.skilldetailthree.text = ""
            binding.skillleveldetail.text = "30 Recarga"
            binding.skillleveldetailtwo.text = "Combinar Duração+0,75s"
            binding.skillleveldetailthree.text = "+40 DPS e 100% Vida"
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
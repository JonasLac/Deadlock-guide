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
import com.example.myapp.databinding.ActivityVindictaProfileBinding
import com.google.android.gms.ads.AdRequest

class VindictaProfile : AppCompatActivity() {

    private lateinit var binding: ActivityVindictaProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityVindictaProfileBinding.inflate(layoutInflater)
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
            binding.skillselect.text = "Stake "
            binding.skilldescription.text =
                "Jogue uma estaca que amarra inimigos para o local onde a estaca pousa. O movimento inimigo é restrito ao comprimento da corda."
            binding.skillrange.text = "2s Tether Duração"
            binding.skillduration.text = "60 Danos"
            binding.skilltime.text = "42s Recarga"
            binding.skilldetailone.text = "captura de 8M Raio "
            binding.skilldetailtwo.text = "comprimento do cabo de 8M"
            binding.skilldetailthree.text = "30% Movimento Lento"
            binding.skillleveldetail.text = "+0,5 Tether Duração "
            binding.skillleveldetailtwo.text = "- 20s Recarga "
            binding.skillleveldetailthree.text = "Inimigos amarrados também estão desarmados"
        }
        binding.skille.setOnClickListener {
            binding.layoutskills.visibility = View.VISIBLE
            binding.skillselect.text = "Flight "
            binding.skilldescription.text =
                "Salte para o ar e voar. Enquanto em voo, sua arma lida dano espiritual bônus."
            binding.skillrange.text = "0.2s Tempo de Elenco"
            binding.skillduration.text = "8s Duração"
            binding.skilltime.text = "42s Recarga "
            binding.skilldetailone.text = ""
            binding.skilldetailtwo.text = "10 Dano Espiritual por Bala"
            binding.skilldetailthree.text = ""
            binding.skillleveldetail.text = "+50% de munição base durante o voo"
            binding.skillleveldetailtwo.text = "15 Recarga "
            binding.skillleveldetailthree.text = "+12 Dano Espiritual Por Bala"
        }
        binding.skillc.setOnClickListener {
            binding.layoutskills.visibility = View.VISIBLE
            binding.skillselect.text = "Crow Familiar "
            binding.skilldescription.text =
                "O seu corvo negócios familiares danos de impacto e aplica a sangrar isso causa dano com base no a saúde atual do alvo."
            binding.skillrange.text = "40 Danos"
            binding.skillduration.text = "3%/s Dano de Sangramento"
            binding.skilltime.text = "26s Recarga"
            binding.skilldetailone.text = "6% Redução da Resistência à Bala"
            binding.skilldetailtwo.text = ""
            binding.skilldetailthree.text = "duração do Debuff de 6S"
            binding.skillleveldetail.text =
                "Corvo Ricochetes até 2 vezes em direção a outros inimigos dentro de 15m"
            binding.skillleveldetailtwo.text = "17 Recarga "
            binding.skillleveldetailthree.text = "+3% Sangrar e suprimir a cicatrização por -40%"
        }
        binding.skillx.setOnClickListener {
            binding.layoutskills.visibility = View.VISIBLE
            binding.skillselect.text = "Assassinate"
            binding.skilldescription.text =
                "Use seu rifle com escopo para disparar um tiro poderoso em longas distâncias. Cause apenas dano parcial até que seja totalmente carregado após 1s de escopo. Faz dano bônus aos inimigos com menos de 50% de saúde restante. Aterragem"
            binding.skillrange.text = "2 Cobranças "
            binding.skillduration.text = "1.6s entre cargas"
            binding.skilltime.text = "53s Recarga "
            binding.skilldetailone.text = "140 Danos"
            binding.skilldetailtwo.text = "145 Dano de Bônus"
            binding.skilldetailthree.text = "250 Almas Bônus por Assassinato"
            binding.skillleveldetail.text = "-20s Recarga "
            binding.skillleveldetailtwo.text = "+140 Dano de Bónus"
            binding.skillleveldetailthree.text = "+600 Almas Bónus Por Assassinato"
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
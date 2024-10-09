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
import com.example.myapp.databinding.ActivityHeraProfileBinding

class HeraProfile : AppCompatActivity() {
    private lateinit var binding: ActivityHeraProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHeraProfileBinding.inflate(layoutInflater)
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
            binding.skillselect.text = "Kudzu Bomb"
            binding.skilldescription.text = "Convocar um pedaço de videiras sufocantes que danos e retarda inimigos em seu raio"
            binding.skillrange.text = "1 Cobranças"
            binding.skillduration.text = "8s Recarga Entre Cargas"
            binding.skilltime.text = "32s Recarga"
            binding.skilldetailone.text = "6m Raio"
            binding.skilldetailtwo.text = "60 DPS"
            binding.skilldetailthree.text = "4s Duração"
            binding.skillleveldetail.text = "+1 Cobranças"
            binding.skillleveldetailtwo.text = "+2s Duração"
            binding.skillleveldetailthree.text = "+50 DPS, +2m Raio"
        }

        binding.skille.setOnClickListener {
            binding.layoutskills.visibility = View.VISIBLE
            binding.skillselect.text = "Watcher's Covenant"
            binding.skilldescription.text = "Ganhe bônus e conecte-se automaticamente com um aliado próximo para compartilhá-los. A cura é replicada entre todos os conectados. A conexão requer linha de visão. Pressione [2] para Bloquear um alvo."
            binding.skillrange.text = "16m Gama "
            binding.skillduration.text = "12s Duração"
            binding.skilltime.text = "37s Recarga "
            binding.skilldetailone.text = "+10% Taxa de Incêndio"
            binding.skilldetailtwo.text = "+15% Bala Lifesteal"
            binding.skilldetailthree.text = "30% de Cura Replicada"
            binding.skillleveldetail.text = "+10% Taxa de Incêndio"
            binding.skillleveldetailtwo.text = "bónus de movimento +2m/s"
            binding.skillleveldetailthree.text = "+1 Contagem de Tether"
        }
        binding.skillc.setOnClickListener {
            binding.layoutskills.visibility = View.VISIBLE
            binding.skillselect.text = "Stone Form"
            binding.skilldescription.text = "Transforme-se em pedra impermeável e esmagar no chão, impressionante e prejudicial inimigos próximos. Cura você por uma porcentagem de sua saúde máxima. Você tem algum controle de ar antes de cair."
            binding.skillrange.text = "6m Raio "
            binding.skillduration.text = "2s Duração"
            binding.skilltime.text = "42s Recarga"
            binding.skilldetailone.text = "80 Danos"
            binding.skilldetailtwo.text = "atordoamento de 0.75s Duração"
            binding.skilldetailthree.text = "10% de Cura Máxima de Saúde"
            binding.skillleveldetail.text = "- 20s Recarga "
            binding.skillleveldetailtwo.text = "+80 Danos e atordoamentos por 0.5s."
            binding.skillleveldetailthree.text = "+20% Cura Máxima da Saúde"
        }
        binding.skillx.setOnClickListener {
            binding.layoutskills.visibility = View.VISIBLE
            binding.skillselect.text = "Air Drop"
            binding.skilldescription.text = "Voe com um Aliado ou uma bomba. Largue seu aliado ou bomba para causar um grande explosão isso causa movimento lento. Ivy e ally ganham um escudo de bala quando o voo termina. Enquanto levantado, seu aliado ganha resistência a bala, mas não pode atacar e causa 50% de dano. O Air Drop tem um tempo de lançamento mais rápido ao segmentar um aliado."
            binding.skillrange.text = "8m Gama "
            binding.skillduration.text = "17s Duração "
            binding.skilltime.text = "85s Recarga "
            binding.skilldetailone.text = "150 Danos de Explosão"
            binding.skilldetailtwo.text = "200 Escudo de Bala"
            binding.skilldetailthree.text = "4.5s Lento Duração "
            binding.skillleveldetail.text = "20% Resistência à bala em inimigos atingidos por 12s."
            binding.skillleveldetailtwo.text = "+300 Bullet Shield e +5m Explode Radius"
            binding.skillleveldetailthree.text = "Aplica Silêncio em inimigos atingidos por +4s"
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
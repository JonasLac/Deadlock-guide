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
import com.example.myapp.databinding.ActivityYamatoProfileBinding
import com.google.android.gms.ads.AdRequest

class YamatoProfile : AppCompatActivity() {
    private lateinit var binding: ActivityYamatoProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityYamatoProfileBinding.inflate(layoutInflater)
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
            binding.skillselect.text = "Power Slash"
            binding.skilldescription.text =
                "Canal para aumentar o dano ao longo de 1,5 segundos, em seguida, solte um ataque de espada totalmente carregado. Pressione [1] ou [clique com o botão esquerdo] para acionar o ataque mais cedo, causando dano parcial."
            binding.skillrange.text = "recarga de 8.5s"
            binding.skillduration.text = "160 Dano de Carga Total"
            binding.skilltime.text = "comprimento da barra de 25M"
            binding.skilldetailone.text = ""
            binding.skilldetailtwo.text = ""
            binding.skilldetailthree.text = ""
            binding.skillleveldetail.text = "Ganhe +60 Bullet Resist enquanto canaliza"
            binding.skillleveldetailtwo.text = "Aplicar +40% de movimento lento para 3s"
            binding.skillleveldetailthree.text = "+200 Dano de Carga Total"
        }
        binding.skille.setOnClickListener {
            binding.layoutskills.visibility = View.VISIBLE
            binding.skillselect.text = "Flying Strike"
            binding.skilldescription.text =
                "Jogue um gancho para enrole-se em direção a um inimigo, danificando e retardando o alvo quando você chegar."
            binding.skillrange.text = "20m Faixa"
            binding.skillduration.text = ""
            binding.skilltime.text = "recarga de 21s"
            binding.skilldetailone.text = "70 Danos"
            binding.skilldetailtwo.text = ""
            binding.skilldetailthree.text = "30% Movimento Lento"
            binding.skillleveldetail.text = "+25% Lento Movimento"
            binding.skillleveldetailtwo.text = "+20m Cast Range"
            binding.skillleveldetailthree.text = "+6 Dano de arma por 10s depois de atingir o alvo"
        }
        binding.skillc.setOnClickListener {
            binding.layoutskills.visibility = View.VISIBLE
            binding.skillselect.text = "Crimson Slash"
            binding.skilldescription.text =
                "Corte inimigos na sua frente, danificando-os e diminuindo sua taxa de incêndio. Se algum herói inimigo for atingido, você heal."
            binding.skillrange.text = "alcance de 13m"
            binding.skillduration.text = "20% Taxa de Fogo Lenta"
            binding.skilltime.text = "CD 11.5s"
            binding.skilldetailone.text = "60 Danos"
            binding.skilldetailtwo.text = "70 Cura no herói atingido"
            binding.skilldetailthree.text = "duração do Debuff 4S"
            binding.skillleveldetail.text = "+30% Taxa de Incêndio Lenta"
            binding.skillleveldetailtwo.text = "+10% de Max Health Cura no herói atingido"
            binding.skillleveldetailthree.text = "recarga de 6S"
        }
        binding.skillx.setOnClickListener {
            binding.layoutskills.visibility = View.VISIBLE
            binding.skillselect.text = "Shadow Transformation"
            binding.skilldescription.text =
                "Torne-se infundido com a alma da sombra de Yamato. Depois de uma inicial invencível transformação, sua as habilidades são atualizadas e são 60% mais rápidas e você ganha o dano resiste e imunidade a efeitos negativos de status. Você não pode morrer neste modo."
            binding.skillrange.text = "2s Tempo de Elenco"
            binding.skillduration.text = "recarga de 106s"
            binding.skilltime.text = "4s Duração"
            binding.skilldetailone.text = "+60% Velocidade de Habilidade"
            binding.skilldetailtwo.text = "+40% Resistência ao Espírito"
            binding.skilldetailthree.text = "+40% Resistência à bala"
            binding.skillleveldetail.text = "recarga dos Anos 30"
            binding.skillleveldetailtwo.text = "+4 m/s Velocidade de Movimento"
            binding.skillleveldetailthree.text = "2s Duração"
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
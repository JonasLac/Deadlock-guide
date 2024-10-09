package com.example.myapp

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapp.databinding.ActivityLadyProfileBinding

class LadyProfile : AppCompatActivity() {
    private lateinit var binding: ActivityLadyProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLadyProfileBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.skillq.setOnClickListener {
            binding.layoutskills.visibility = View.VISIBLE
            binding.skillselect.text = "Essence Bomb"
            binding.skilldescription.text = "Sacrifique um pouco da sua saúde para lançar uma bomba que causa dano depois de um breve tempo de braço. O tipo de dano próprio é o Espírito e pode ser mitigado."
            binding.skillrange.text = "7m Raio "
            binding.skillduration.text = "100 Danos"
            binding.skilltime.text = "10.5s Recarga"
            binding.skilldetailone.text = "duração de Arming 0.5S"
            binding.skilldetailtwo.text = "30 Auto Dano"
            binding.skilldetailthree.text = ""
            binding.skillleveldetail.text = "+2m Raio "
            binding.skillleveldetailtwo.text = "+60 Danos"
            binding.skillleveldetailthree.text = "As bombas deixam uma bagunça tóxica no chão, causando 26% do dano original por segundo, por 6s."
        }
        binding.skille.setOnClickListener {
            binding.layoutskills.visibility = View.VISIBLE
            binding.skillselect.text = "Life Drain "
            binding.skilldescription.text = "Causa um laço que drena a saúde do inimigo ao longo do tempo e cura-te. O alvo deve estar na linha de visão e dentro do alcance máximo para drenar. Você pode atirar e usar outras habilidades durante o dreno, mas sua velocidade de movimento é reduzida pela metade."
            binding.skillrange.text = "20m Gama "
            binding.skillduration.text = "20m Gama "
            binding.skilltime.text = "30s Recarga "
            binding.skilldetailone.text = "faixa de 30M Max Tether"
            binding.skilldetailtwo.text = "35 Dano por Segundo"
            binding.skilldetailthree.text = ""
            binding.skillleveldetail.text = "+20 Dano Por Segundo"
            binding.skillleveldetailtwo.text = "+2s Duração"
            binding.skillleveldetailthree.text = "O Inimigo é Silenciado enquanto está sendo Drenado pela Vida (requer linha de visão)"
        }
        binding.skillc.setOnClickListener {
            binding.layoutskills.visibility = View.VISIBLE
            binding.skillselect.text = "Malice "
            binding.skilldescription.text = "Sacrifique um pouco da sua saúde para lançar fragmentos de sangue que aplicam uma pilha de malícia. Cada pilha retarda a vítima e aumenta o dano eles tiram de você. O efeito lento diminui com o tempo."
            binding.skillrange.text = "3 Fragmentos de Sangue"
            binding.skillduration.text = "5 Pilhas Máximas"
            binding.skilltime.text = "6s Recarga"
            binding.skilldetailone.text = "16s Debuff Duração"
            binding.skilldetailtwo.text = "32 Saúde para Danos"
            binding.skilldetailthree.text = "6s Lento Duração"
            binding.skillleveldetail.text = "-3s Recarga"
            binding.skillleveldetailtwo.text = "+40 Saúde a Danos"
            binding.skillleveldetailthree.text = "+6 Fragmentos de Sangue"
        }
        binding.skillx.setOnClickListener {
            binding.layoutskills.visibility = View.VISIBLE
            binding.skillselect.text = "Soul Exchange"
            binding.skilldescription.text = "Troca os níveis de saúde com um alvo inimigo. Há uma porcentagem mínima de saúde que os inimigos podem ser reduzidos e uma quantidade mínima de saúde recebida com base na saúde atual das vítimas."
            binding.skillrange.text = "7m Gama"
            binding.skillduration.text = "0.2s Tempo de Elenco"
            binding.skilltime.text = "170"
            binding.skilldetailone.text = "30% Inimigo Min Saúde"
            binding.skilldetailtwo.text = "30% Min Saúde Recebida"
            binding.skilldetailthree.text = ""
            binding.skillleveldetail.text = "40 Recarga "
            binding.skillleveldetailtwo.text = "10% Inimigo Min Saúde"
            binding.skillleveldetailthree.text = "No elenco, +40% Taxa de Fogo e +40% Resistência Espiritual para 8s."
        }
    }
}
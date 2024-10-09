package com.example.myapp

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapp.databinding.ActivityBrumaProfileBinding

class BrumaProlife : AppCompatActivity() {
    private lateinit var binding: ActivityBrumaProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBrumaProfileBinding.inflate(layoutInflater)
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
            binding.skillselect.text = "Sleep Dagger"
            binding.skilldescription.text =
                "Jogue uma adaga que danos e dorme o alvo. Os alvos adormecidos acordam logo após serem danificados. Jogar uma adaga não quebra sua invisibilidade. A Adaga do Sono não interrompe as habilidades de canalização dos inimigos"
            binding.skillrange.text = "Efeito do Estado do Sono"
            binding.skillduration.text = "70 Danos"
            binding.skilltime.text = "26s Recarga"
            binding.skilldetailone.text = "0.2s Min Tempo de Sono"
            binding.skilldetailtwo.text = "0.1s Tempo de Acordar"
            binding.skilldetailthree.text = "3s Dormir Duração"
            binding.skillleveldetail.text = "Remove 1 resistência"
            binding.skillleveldetailtwo.text = "13 Recarga"
            binding.skillleveldetailthree.text =
                "Aplica-se - 12% Bullet Resist para 6s no despertar"
        }
        binding.skille.setOnClickListener {
            binding.layoutskills.visibility = View.VISIBLE
            binding.skillselect.text = "Smoke Bomb"
            binding.skilldescription.text =
                "Desvanecer-se da vista, tornando-se invisível e ganhando velocidade de sprint. Atacar remove a invisibilidade. Inimigos próximos podem ver através de sua invisibilidade"
            binding.skillrange.text = "8s Duração"
            binding.skillduration.text = "Efeito de Status Invisível"
            binding.skilltime.text = "37s Recarga "
            binding.skilldetailone.text = "ponto de 18m Raio "
            binding.skilldetailtwo.text = "tempo de Desvanecimento 1.5S"
            binding.skilldetailthree.text = "+2m/s Velocidade de Sprint"
            binding.skillleveldetail.text = "15 Recarga "
            binding.skillleveldetailtwo.text = "+6m/s Invis Velocidade de Sprint"
            binding.skillleveldetailthree.text =
                "Depois de invis, ganhe +30% Bullet Lifesteal por 8s"
        }
        binding.skillc.setOnClickListener {
            binding.layoutskills.visibility = View.VISIBLE
            binding.skillselect.text = "Fixation "
            binding.skilldescription.text =
                "Atirando um alvo aumenta o dano da bala naquele alvo. Ganhar um pilha por bala atingida, duas se a batida for um tiro na cabeça"
            binding.skillrange.text = "6s Duração "
            binding.skillduration.text = "+0.2 por pilha Dano de Arma"
            binding.skilltime.text = "30 Pilhas Máximas"
            binding.skilldetailone.text = "Na"
            binding.skilldetailtwo.text = "Na"
            binding.skilldetailthree.text = "Na"
            binding.skillleveldetail.text =
                "60 Dano de espírito e 15% lento para 2s para atingir cada 20 pilhas"
            binding.skillleveldetailtwo.text = "+40 Max Stacks e +5s Duração "
            binding.skillleveldetailthree.text = "+0.2 por pilha Dano de Arma"
        }
        binding.skillx.setOnClickListener {
            binding.layoutskills.visibility = View.VISIBLE
            binding.skillselect.text = "Bullet Dance"
            binding.skilldescription.text =
                "Entre em uma enxurrada, disparando sua arma em inimigos próximos com precisão perfeita. Durante a agitação, Haze ganha um bônus de taxa de fogo e vai fugir de algumas das balas disparadas contra ela."
            binding.skillrange.text = "3s Tempo do Canal"
            binding.skillduration.text = "15m Gama"
            binding.skilltime.text = "138s Recarga"
            binding.skilldetailone.text = "+15% Taxa de Incêndio, +2 Dano de Arma"
            binding.skilldetailtwo.text = "1 Alvos Atingidos Por Tiro"
            binding.skilldetailthree.text = "25% Chance de Evasão"
            binding.skillleveldetail.text = "+7 Dano de Arma"
            binding.skillleveldetailtwo.text = "40 Recarga"
            binding.skillleveldetailthree.text = "+1 Alvos Acertados Por Tiro"
        }
    }
}
package com.jlds.deadlockguide

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapp.R
import com.example.myapp.databinding.ActivityAdagaProfileBinding
import com.google.android.gms.ads.AdRequest

class AdagaProfile : AppCompatActivity() {
    private lateinit var binding: ActivityAdagaProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdagaProfileBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.skillq.setOnClickListener {
            binding.layoutskills.visibility = View.VISIBLE
            binding.skillselect.text = "Serrated Knives"
            binding.skilldescription.text =
                "Jogue uma faca que danos e retarda um inimigo. Cada hit adicional adiciona um pilha e atualiza a duração do debuff, fazendo com que o dano aumente por pilha."
            binding.skillrange.text = "2 Cobranças"
            binding.skillduration.text = "2s Recarga Entre Cargas"
            binding.skilltime.text = "19s Recarga"
            binding.skilldetailone.text = "5s Debuff Duração"
            binding.skilldetailtwo.text = "35 Danos"
            binding.skilldetailthree.text = "5 Sangramento DPS Por Faca"
            binding.skillleveldetail.text = "+1 Encargos"
            binding.skillleveldetailtwo.text = "+2s Debuff Duração"
            binding.skillleveldetailthree.text = "+40 Danos e +5 Sangramento DPS"
        }
        binding.skille.setOnClickListener {
            binding.layoutskills.visibility = View.VISIBLE
            binding.skillselect.text = "Slice and Dice"
            binding.skilldescription.text =
                "Executar um avance, danificando inimigos ao longo do caminho. Desbloqueio Final: Enquanto a raiva está cheia um eco de Shiv refaz o caminho do traço após um curto atraso, danificando os inimigos novamente"
            binding.skillrange.text = "105 Danos"
            binding.skillduration.text = "traço de 12M Gama"
            binding.skilltime.text = "16s Recarga"
            binding.skilldetailone.text = "Na"
            binding.skilldetailtwo.text = "Na"
            binding.skilldetailthree.text = "Na"
            binding.skillleveldetail.text = "4s Recarga"
            binding.skillleveldetailtwo.text = "+75 Dano"
            binding.skillleveldetailthree.text =
                "Reduza o tempo de recarga em 2s por inimigo atingido (1s para não-Herói). Máximo 6s por Dash"
        }
        binding.skillc.setOnClickListener {
            binding.layoutskills.visibility = View.VISIBLE
            binding.skillselect.text = "Bloodletting "
            binding.skilldescription.text =
                "Pegue apenas uma parte do dano recebido imediatamente e adie o restante para ser tomado ao longo do tempo. Ativar para limpar uma parte do dano diferido."
            binding.skillrange.text = "30% de Dano de Entrada Adiado"
            binding.skillduration.text = "10s Dano Adiado Duração"
            binding.skilltime.text = "21 Recarga"
            binding.skilldetailone.text = "Na"
            binding.skilldetailtwo.text = "Ativar: 40% de Dano Adiado Apagado"
            binding.skilldetailthree.text = "Na"
            binding.skillleveldetail.text = "+5s Dano Diferido Duração"
            binding.skillleveldetailtwo.text = "CD 5s"
            binding.skillleveldetailthree.text = "+25% Dano Diferido Apurado"
        }
        binding.skillx.setOnClickListener {
            binding.layoutskills.visibility = View.VISIBLE
            binding.skillselect.text = "Killing Blow"
            binding.skilldescription.text =
                "Ative para saltar em direção a um herói inimigo e matar instantaneamente eles se a sua saúde é abaixo do limiar de mortecaso contrário, cause 200 de dano a eles.\nPassivo: Danificar inimigos enche você de raiva. Enquanto na rave completa, Shiv ganha dano aumentado e propriedades especiais sobre suas outras habilidades."
            binding.skillrange.text = "20m Gam"
            binding.skillduration.text = "Limiar de Saúde do Inimigo de 20%"
            binding.skilltime.text = "95s Recarg"
            binding.skilldetailone.text = "Na"
            binding.skilldetailtwo.text = "+15% Todos os Danos"
            binding.skilldetailthree.text = "Na"
            binding.skillleveldetail.text =
                "Ganhe +2m/s velocidade de movimento enquanto estiver com raiva total"
            binding.skillleveldetailtwo.text =
                "+8% Limiar de saúde do inimigo e +10% Dano de Bónus de Fúria Total"
            binding.skillleveldetailthree.text =
                "Terminar um inimigo com Killing Blow redefine sua recarga"
        }
        binding.adView.loadAd(AdRequest.Builder().build())
    }
}
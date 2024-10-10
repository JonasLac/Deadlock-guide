package com.example.myapp

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapp.databinding.ActivityKelvinProfileBinding
import com.google.android.gms.ads.AdRequest

class KelvinProfile : AppCompatActivity() {
    private lateinit var binding: ActivityKelvinProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKelvinProfileBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.adView.loadAd(AdRequest.Builder().build())

        binding.skillq.setOnClickListener {
            binding.layoutskills.visibility = View.VISIBLE
            binding.skillselect.text = "Frost Grenade"
            binding.skilldescription.text =
                "Jogue uma granada que exploda em uma nuvem de gelo congelante prejudicial e desaceleração inimigos."
            binding.skillrange.text = "1 Cobranças "
            binding.skillduration.text = "7s Recarga Entre Cargas"
            binding.skilltime.text = "22s Recarga "
            binding.skilldetailone.text = "6.5m Raio "
            binding.skilldetailtwo.text = "80 Danos"
            binding.skilldetailthree.text = "40% Movimento Lento"
            binding.skillleveldetail.text = "+1 Cobranças "
            binding.skillleveldetailtwo.text =
                "Grenada de Gelo agora cura 145 HP para alvos amigáveis. Escalas com Espírito"
            binding.skillleveldetailthree.text = "+175 Danos"
        }
        binding.skille.setOnClickListener {
            binding.layoutskills.visibility = View.VISIBLE
            binding.skillselect.text = "Ice Path"
            binding.skilldescription.text =
                "Kelvin cria um trilha flutuante de gelo e neve que dá bônus de movimento para ele e seus aliados. Kelvin ganha 60% de resistência lenta pela duração. Inimigos também podem andar na trilha flutuante.\n" +
                        "Pressione [LEFT SHIFT] / [LEFT CTRL] para subir ou descer enquanto estiver no Caminho do Gelo."
            binding.skillrange.text = "8s Duração"
            binding.skillduration.text = "18s Duração"
            binding.skilltime.text = "38s Recarga "
            binding.skilldetailone.text = "+2m/s Velocidade de Movimento"
            binding.skilldetailtwo.text = "+2m/s Velocidade de Sprint"
            binding.skilldetailthree.text = ""
            binding.skillleveldetail.text = "+4m/s Velocidade de Sprint"
            binding.skillleveldetailtwo.text = "16s Recarga"
            binding.skillleveldetailthree.text =
                "Enquanto estiver ativo, ganhe +1 Spirit Power por metro de trilha Ice Path criada. Máximo de 55 Poder Espiritual"
        }
        binding.skillc.setOnClickListener {
            binding.layoutskills.visibility = View.VISIBLE
            binding.skillselect.text = "Arctic Beam"
            binding.skilldescription.text =
                "Atire energia fria congelante na sua frente alvos prejudiciais e construindo movimento e taxa de fogo lenta contra eles quanto mais tempo você sustentar o feixe sobre eles. Você reduziu a velocidade de movimento ao usar o Arctic Beam."
            binding.skillrange.text = "5s Canal Tempo"
            binding.skillduration.text = "comprimento do feixe de 25M"
            binding.skilltime.text = "24s Recarga "
            binding.skilldetailone.text = "60 DPS"
            binding.skilldetailtwo.text = "Fluxo Máximo de 50%, Taxa de Fogo Máxima de 40% Lenta"
            binding.skilldetailthree.text = "2s Linger Lento"
            binding.skillleveldetail.text = "-8s Recarga "
            binding.skillleveldetailtwo.text = "+40 DPS"
            binding.skillleveldetailthree.text =
                "Dispara 2 Feixes Árticos Adicionais em direção a inimigos dentro de 13m do último alvo atingido"
        }
        binding.skillx.setOnClickListener {
            binding.layoutskills.visibility = View.VISIBLE
            binding.skillselect.text = "Frozen Shelter"
            binding.skilldescription.text =
                "Kelvin congela o ar ao seu redor, criando uma cúpula impenetrável em torno de si mesmo. Enquanto na cúpula, aliados rapidamente regenerar a saúde e os inimigos são desacelerado."
            binding.skillrange.text = "10m Raio "
            binding.skillduration.text = "5.5s Duração "
            binding.skilltime.text = "127 Recarga"
            binding.skilldetailone.text = "+120 Regen Saúde"
            binding.skilldetailtwo.text = "35% Movimento Lento"
            binding.skilldetailthree.text = ""
            binding.skillleveldetail.text = "+40% Taxa de Incêndio Lenta"
            binding.skillleveldetailtwo.text = "40 Recarga "
            binding.skillleveldetailthree.text = "+70 Health Regen e agora escala com Spirit Power"
        }
    }
}
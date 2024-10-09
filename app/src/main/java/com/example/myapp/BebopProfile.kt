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
import com.example.myapp.databinding.ActivityBebopProfileBinding

class BebopProfile : AppCompatActivity() {
    private lateinit var binding: ActivityBebopProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBebopProfileBinding.inflate(layoutInflater)
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
            binding.skillselect.text = "Exploding Uppercut"
            binding.skilldescription.text = "Negociação Luz Melee danos às unidades próximas e enviá-los voando de volta, causando danos na área onde eles pousam. Não prejudica aliados."
            binding.skillrange.text = "0 Dano de Uppercut"
            binding.skillduration.text = "14m Aterragem Raio \n"
            binding.skilltime.text = "21 Recarga \n"
            binding.skilldetailone.text = "Na"
            binding.skilldetailtwo.text = "80 Danos na Área\n"
            binding.skilldetailthree.text = "Na"
            binding.skillleveldetail.text = "11 Recarga \n"
            binding.skillleveldetailtwo.text = "No Uppercut inimigo Hero, ganhe tempo de spin-up rápido, alcance de 2x e +60% de dano de arma por 12s\n"
            binding.skillleveldetailthree.text = "No Uppercut inimigo Hero, defina o tempo de recarga de Gancho para 0 e instantaneamente +100% de balas para o seu clipe atual\n"
        }
        binding.skille.setOnClickListener {
            binding.layoutskills.visibility = View.VISIBLE
            binding.skillselect.text = "Sticky Bomb"
            binding.skilldescription.text = "Anexar uma Bomba Pegajosa a um alvo próximo que lida dano explosivo após um curto período de fusível. Ganho +2,5% de dano da bomba para cada herói inimigo atingido. Você pode conjurar Sticky Bomb em si mesmo usando [M3]."
            binding.skillrange.text = "6m Gama \n"
            binding.skillduration.text = "12m Raio \n"
            binding.skilltime.text = "12m Raio \n"
            binding.skilldetailone.text = "120 Danos\n"
            binding.skilldetailtwo.text = "3s Tempo de Fusível\n"
            binding.skilldetailthree.text = "Na"
            binding.skillleveldetail.text = "CD -8s\n"
            binding.skillleveldetailtwo.text = "+80 Danos\n"
            binding.skillleveldetailthree.text = "Em Anexar, desarma o alvo por 3,5s\n"
        }

        binding.skillc.setOnClickListener {
            binding.layoutskills.visibility = View.VISIBLE
            binding.skillselect.text = "Hook"
            binding.skilldescription.text = "Lançar um gancho que agarra e cambaleia o primeiro inimigo ou herói amigo que ele atinge, causando dano se o alvo for um inimigo. O alvo será colocado onde você está enfrentando."
            binding.skillrange.text = "25m Gama "
            binding.skillduration.text = "40 Dano"
            binding.skilltime.text = "23s Recarga"
            binding.skilldetailone.text = "Na"
            binding.skilldetailtwo.text = "Na"
            binding.skilldetailthree.text = "Na"
            binding.skillleveldetail.text = "Bebop causa 30% mais dano de bala contra inimigos viciados por 10s"
            binding.skillleveldetailtwo.text = "+30m Elenco Gama"
            binding.skillleveldetailthree.text = "-12s Recarga"
            }
        binding.skillx.setOnClickListener {
            binding.layoutskills.visibility = View.VISIBLE
            binding.skillselect.text = "Hyper Beam"
            binding.skilldescription.text = "Carregue seu laser para liberar uma poderosa torrente de energia que causa dano e retarda o movimento e os traços dos inimigos. Você tem movimento lento e taxa de rotação para a duração. Se ativado no ar, você vai pairar enquanto libera o feixe."
            binding.skillrange.text = "8s Duração "
            binding.skillduration.text = "largura do feixe de 2.9M"
            binding.skilltime.text = "130 Recarga "
            binding.skilldetailone.text = ""
            binding.skilldetailtwo.text = ""
            binding.skilldetailthree.text = ""
            binding.skillleveldetail.text = "30 Recarga \n" +
                    "\n"
            binding.skillleveldetailtwo.text = "+100 DPS\n" +
                    "\n"
            binding.skillleveldetailthree.text = "Hyper Beam cura Bebop por 100% de seu dano em Heroes. 33% em não-herói\n" +
                    "\n"
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
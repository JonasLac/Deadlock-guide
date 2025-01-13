package com.jlds.deadlockguide.base;

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapp.R
import com.jlds.deadlockguide.EspectraProfile

open class BaseActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
        // Comportamentos comuns podem ser inicializados aqui
        }
        override fun onBackPressed() {
                super.onBackPressed()
                overridePendingTransition(R.anim.zoom_out, R.anim.zoom_out)
        }
        public fun opensla(){
                startActivity(Intent(this, EspectraProfile::class.java))
        }
        override fun startActivity(intent: Intent?) {
                super.startActivity(intent)
                // Define a animação padrão ao abrir uma nova Activity
                overridePendingTransition(R.anim.zoom_in, R.anim.zoom_out)
        }

        override fun finish() {
                super.finish()
                // Define a animação padrão ao fechar uma Activity
                overridePendingTransition(R.anim.zoom_out, R.anim.zoom_in)
        }
        }

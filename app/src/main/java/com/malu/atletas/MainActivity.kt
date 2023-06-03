package com.malu.atletas

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.malu.atletas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bt_novo_registro = binding.btnRegistro
        val bt_ver_historico = binding.btnHistorico

        bt_novo_registro.setOnClickListener{
            val intent = Intent(this, Registro::class.java)
            startActivity(intent)
        }
        bt_ver_historico.setOnClickListener{
            val intent = Intent(this, Historico::class.java)
            startActivity(intent)
        }
    }
}
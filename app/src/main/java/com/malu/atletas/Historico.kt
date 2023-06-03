package com.malu.atletas

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import com.malu.atletas.databinding.HistoricoLayoutBinding

class Historico: AppCompatActivity() {

    private lateinit var binding: HistoricoLayoutBinding
    private val db = FirebaseFirestore.getInstance()

            override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HistoricoLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

                recuperarRegistro()
    }
    private fun recuperarRegistro(){
        db.collection("atletas").document("atleta").get().addOnCompleteListener(){
            documento ->
            if (documento.isSuccessful){
                val nome = documento.result.get("Nome").toString()
                val modalidade = documento.result.get("Modalidade").toString()
                val salario = documento.result.get("Salario").toString()

                binding.historicoNome.text = nome
                binding.historicoModalidade.text = modalidade
                binding.historicoSalario.text = salario
            }
        }
    }
}
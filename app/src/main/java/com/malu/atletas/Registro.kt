package com.malu.atletas

import android.content.res.Configuration
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import com.malu.atletas.databinding.RegistroLayoutBinding

class Registro : AppCompatActivity() {

private lateinit var binding: RegistroLayoutBinding
private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = RegistroLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegistrar.setOnClickListener{
            val nome = binding.registroNome.text.toString()
            val modalidade = binding.registroModalidade.text.toString()
            val salario = binding.registroSalario.text.toString()

            if(nome.isEmpty()||modalidade.isEmpty()||salario.isEmpty()){
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            }else{
                salvarRegistro(nome,modalidade,salario)
            }
        }
    }

    private fun salvarRegistro(nome: String, modalidade: String, salario: String){
        val mapAtletas = hashMapOf("Nome" to nome, "Modalidade" to modalidade, "Salario" to salario)
        db.collection("atletas").document("atleta").set(mapAtletas).addOnCompleteListener{
                tarefa -> if(tarefa.isSuccessful){
                    Toast.makeText(this, "Sucesso!", Toast.LENGTH_SHORT).show()
                    binding
                }
        }.addOnFailureListener{
            Toast.makeText(this, "Deu ruim", Toast.LENGTH_SHORT).show()

        }
    }
    private fun limparCampos(){
        binding.registroNome.setText("")
        binding.registroModalidade.setText("")
        binding.registroSalario.setText("")
    }
}
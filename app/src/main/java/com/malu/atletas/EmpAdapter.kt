package com.malu.atletas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EmpAdapter(private val empList: ArrayList<Modelo>) :
    RecyclerView.Adapter<EmpAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.atletas_lista, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentEmp = empList[position]
        holder.historicoNome.text = currentEmp.empNome
        holder.historicoModalidade.text = currentEmp.empModalidade
        holder.historicoSalario.text = currentEmp.emSalario

    }

    override fun getItemCount(): Int {
        return empList.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val historicoNome : TextView = itemView.findViewById(R.id.historicoNome)
        val historicoModalidade : TextView = itemView.findViewById(R.id.historicoModalidade)
        val historicoSalario : TextView = itemView.findViewById(R.id.historicoSalario)

    }
}
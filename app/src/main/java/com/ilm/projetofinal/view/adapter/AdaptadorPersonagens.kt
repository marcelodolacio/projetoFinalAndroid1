package com.ilm.projetofinal.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ilm.projetofinal.R
import com.ilm.projetofinal.databinding.ItemDoPersonagemBinding
import com.ilm.projetofinal.domain.Personagem

class AdaptadorPersonagens(
    val lista: List<Personagem>
) : RecyclerView.Adapter<AdaptadorPersonagens.GuardadorDeDadosPersonagem>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuardadorDeDadosPersonagem {
        var instanciaDoXML = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_do_personagem, parent, false)
        var guardador = GuardadorDeDadosPersonagem(instanciaDoXML)
        return guardador
    }

    override fun onBindViewHolder(holder: GuardadorDeDadosPersonagem, position: Int) {
        val binding = holder.binding
        val p = lista[position]
        binding.personagem = p
        binding.executePendingBindings()
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    inner class GuardadorDeDadosPersonagem(v: View) : RecyclerView.ViewHolder(v) {
        val binding: ItemDoPersonagemBinding = ItemDoPersonagemBinding.bind(v)
    }


}
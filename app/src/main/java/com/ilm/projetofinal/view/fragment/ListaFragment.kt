package com.ilm.projetofinal.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.ilm.projetofinal.databinding.FragmentListaBinding
import com.ilm.projetofinal.domain.Personagem
import com.ilm.projetofinal.view.adapter.AdaptadorPersonagens
import com.ilm.projetofinal.viewmodel.ApiViewModel

class ListaFragment : Fragment() {

    private lateinit var binding: FragmentListaBinding
    private val viewModel: ApiViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListaBinding.inflate(inflater, container, false)
        binding.meuFragmento = this
        binding.lifecycleOwner = this

        viewModel.resultadoTela.observe(viewLifecycleOwner){ lista ->
            mostrarResultadoAPI(lista)
        }

        binding.rvPersonagens.layoutManager = LinearLayoutManager(context)

        return binding.root
    }

    private fun mostrarResultadoAPI(lista: List<Personagem>){

        val adaptador = AdaptadorPersonagens(lista)

        binding.rvPersonagens.adapter = adaptador

    }

    fun chamarAPI(){
        viewModel.chamarAPI()
    }
}
package com.example.projetofinal.interactor

import com.example.projetofinal.domain.Personagem
import com.example.projetofinal.repository.ApiRepository

class ApiInteractor {

    private val repo = ApiRepository()

    suspend fun chamarAPI(): List<Personagem>{
        return repo.chamarAPI()
    }
}
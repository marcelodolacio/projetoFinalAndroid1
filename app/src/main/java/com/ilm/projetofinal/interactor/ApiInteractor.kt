package com.ilm.projetofinal.interactor

import com.ilm.projetofinal.domain.Personagem
import com.ilm.projetofinal.repository.ApiRepository

class ApiInteractor {

    private val repo = ApiRepository()

    suspend fun chamarAPI(): List<Personagem>{
        return repo.chamarAPI()
    }
}
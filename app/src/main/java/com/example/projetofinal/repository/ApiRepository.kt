package com.example.projetofinal.repository

import com.example.projetofinal.domain.Personagem
import com.example.projetofinal.repository.dto.CharacterDTO
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers

interface BreakingBadPersonagensApi {
    @GET("characters")  //https://breakingbadapi.com/api/characters
    @Headers("Content-Type: application/json")
    //suspend fun recuperarPersonagens (@Query("limit") limit: Int, @Query("offset") offset: Int) : PageDTO
    suspend fun recuperarPersonagens () : List<CharacterDTO>
}

class ApiRepository {

    private val connector: Retrofit

    init {
        /*
        val gsonConfig = GsonBuilder()
            .setDateFormat("MM-dd-yyyy")
            .create()
         */
        connector = Retrofit.Builder()
            .baseUrl("https://www.breakingbadapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    suspend fun chamarAPI(): List<Personagem>{
        val service = connector.create(BreakingBadPersonagensApi::class.java)
        val listaPersonagens = service.recuperarPersonagens()

        return listaPersonagens.map { dto ->
            Personagem(
                name = dto.name,
                img = dto.img,
                nickname = dto.nickname,
                status = dto.status,
            )
        }
    }

}
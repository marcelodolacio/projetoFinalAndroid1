package com.ilm.projetofinal.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.ilm.projetofinal.domain.Personagem
import com.ilm.projetofinal.interactor.ApiInteractor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class ApiViewModel(val app: Application) : AndroidViewModel(app), CoroutineScope {

    override val coroutineContext: CoroutineContext = Dispatchers.Main

    private val interactor = ApiInteractor()
    val resultadoTela = MutableLiveData<List<Personagem>>()

    fun chamarAPI(){
        launch {
            val listaPersonagens =  interactor.chamarAPI()
            resultadoTela.value = listaPersonagens
        }
    }

}
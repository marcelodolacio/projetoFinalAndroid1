package com.ilm.projetofinal.repository.dto

// https://breakingbadapi.com/api/characters
data class CharacterDTO(
    var char_id: Int,
    var name: String,
    var birthday: String,
    var occupation: List<String>,
    var img: String,
    var status: String,
    var nickname: String,
    var appearance: List<Int>,
    var portrayed: String
)

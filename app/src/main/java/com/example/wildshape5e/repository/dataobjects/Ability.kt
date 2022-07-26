package com.example.wildshape5e.repository.dataobjects

data class Ability(
    val name : String,
    val desc : String,
    val attack_bonus : Int?,
    val damage : List<Damage>?,
    val dc : Dc?,
    val usage : Usage?
)

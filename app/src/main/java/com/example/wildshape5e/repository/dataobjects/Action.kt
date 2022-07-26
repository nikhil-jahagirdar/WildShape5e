package com.example.wildshape5e.repository.dataobjects

data class Action(
    val name : String,
    val desc : String,
    val attack_bonus : Int?,
    val dc : Dc?,
    val damage : List<Damage>?
)

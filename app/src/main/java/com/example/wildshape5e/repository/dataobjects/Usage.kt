package com.example.wildshape5e.repository.dataobjects

data class Usage(
    val type : String,
    val rest_types : List<String>,
    val times : Int
)

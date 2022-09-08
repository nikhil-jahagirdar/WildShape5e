package com.example.wildshape5e.beastlist

import com.example.wildshape5e.base.DataResult
import com.example.wildshape5e.repository.dataobjects.MonsterDetail

data class BeastListState(
    val beastListData : DataResult<List<MonsterDetail>> = DataResult.Loading,
    val filteredBeastList : List<MonsterDetail> = listOf(),
    val filterClicked : Filter? = null,
    val rating : Int? = null,
    val strength : Int? = null,
    val dexterity : Int? = null,
    val constitution : Int? = null,
    val intelligence : Int? = null,
    val wisdom : Int? = null,
    val charisma : Int? = null
)
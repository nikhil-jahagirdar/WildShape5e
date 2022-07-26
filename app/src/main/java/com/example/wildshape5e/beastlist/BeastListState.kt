package com.example.wildshape5e.beastlist

import com.example.wildshape5e.base.DataResult
import com.example.wildshape5e.repository.dataobjects.MonsterDetail

data class BeastListState(
    val beastListData : DataResult<List<MonsterDetail>> = DataResult.Loading,
    val filterClicked : Filter? = null,
    val rating : Int? = null
)
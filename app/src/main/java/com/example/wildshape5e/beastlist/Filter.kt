package com.example.wildshape5e.beastlist

import androidx.compose.runtime.Composable
import com.example.wildshape5e.base.BaseAction
import com.example.wildshape5e.repository.dataobjects.MonsterDetail

interface Filter {

    fun isActive(state: BeastListState) : Boolean

    fun message(state: BeastListState) : String

    fun filter(state: BeastListState, list : List<MonsterDetail>) : List<MonsterDetail>

    @Composable
    fun popUp(state: BeastListState, performAction: (BaseAction<BeastListState>) -> Unit)
}
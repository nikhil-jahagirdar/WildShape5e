package com.example.wildshape5e.beastlist

import androidx.compose.runtime.Composable
import com.example.wildshape5e.base.BaseAction
import com.example.wildshape5e.beastlist.actions.FilterClosedAction
import com.example.wildshape5e.repository.dataobjects.MonsterDetail

val filterList = listOf(ChallengeRatingFilter, StrengthFilter)

abstract class Filter {

    abstract fun isActive(state: BeastListState) : Boolean

    abstract fun message(state: BeastListState) : String

    abstract fun filter(state: BeastListState, list : List<MonsterDetail>) : List<MonsterDetail>

    @Composable
    abstract fun popUp(state: BeastListState, performAction: (BaseAction<BeastListState>) -> Unit)

    fun close(performAction: (BaseAction<BeastListState>) -> Unit) {
        performAction(FilterClosedAction())
    }

    abstract fun reset(performAction: (BaseAction<BeastListState>) -> Unit)
}
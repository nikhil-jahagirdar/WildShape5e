package com.example.wildshape5e.beastlist

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.wildshape5e.base.BaseAction
import com.example.wildshape5e.repository.dataobjects.MonsterDetail
import com.example.wildshape5e.ui.FilterPopUp

object StrengthFilter : Filter() {
    const val title = "Strength Rating"

    override fun isActive(state: BeastListState) : Boolean {
        return state.strength != null
    }

    override fun message(state: BeastListState) : String {
        if (!isActive(state)) {
            return title
        } else {
            return "${state.strength}"
        }
    }

    override fun filter(state: BeastListState, list : List<MonsterDetail>) : List<MonsterDetail> {
        if (!isActive(state)) {
            return list
        }
        return list.filter { monsterDetail -> monsterDetail.challenge_rating == state.strength }
    }

    @Composable
    override fun popUp(state: BeastListState, performAction : (BaseAction<BeastListState>) -> Unit) {
        FilterPopUp(name = title) {
            Spacer(modifier = Modifier.height(300.dp))
        }
    }

    override fun reset(performAction: (BaseAction<BeastListState>) -> Unit) {

    }
}
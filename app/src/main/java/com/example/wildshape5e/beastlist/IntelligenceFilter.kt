package com.example.wildshape5e.beastlist

import androidx.compose.runtime.Composable
import com.example.wildshape5e.base.BaseAction
import com.example.wildshape5e.beastlist.actions.IntelligenceChosenAction
import com.example.wildshape5e.beastlist.actions.IntelligenceResetAction
import com.example.wildshape5e.repository.dataobjects.MonsterDetail
import com.example.wildshape5e.ui.FilterPopUp
import com.example.wildshape5e.ui.MyPicker

object IntelligenceFilter : Filter() {
    const val title = "Intelligence"

    override fun isActive(state: BeastListState) : Boolean {
        return state.intelligence != null
    }

    override fun message(state: BeastListState) : String {
        if (!isActive(state)) {
            return title
        } else {
            return "Intelligence: ${state.intelligence}"
        }
    }

    override fun filter(state: BeastListState, list : List<MonsterDetail>) : List<MonsterDetail> {
        if (!isActive(state)) {
            return list
        }
        return list.filter { monsterDetail -> monsterDetail.intelligence == state.intelligence }
    }

    @Composable
    override fun popUp(state: BeastListState, performAction : (BaseAction<BeastListState>) -> Unit) {
        FilterPopUp(
            name = IntelligenceFilter.title,
            { close(performAction) },
            { reset(performAction) }
        )  {
            MyPicker(default = state.intelligence?:0) {
                performAction(IntelligenceChosenAction(it))
            }

        }
    }

    override fun reset(performAction: (BaseAction<BeastListState>) -> Unit) {
        performAction(IntelligenceResetAction())
        close(performAction)
    }
}
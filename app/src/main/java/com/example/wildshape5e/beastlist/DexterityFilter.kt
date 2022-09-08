package com.example.wildshape5e.beastlist

import androidx.compose.runtime.Composable
import com.example.wildshape5e.base.BaseAction
import com.example.wildshape5e.beastlist.actions.DexterityChosenAction
import com.example.wildshape5e.beastlist.actions.DexterityResetAction
import com.example.wildshape5e.beastlist.actions.StrengthChosenAction
import com.example.wildshape5e.beastlist.actions.StrengthResetAction
import com.example.wildshape5e.repository.dataobjects.MonsterDetail
import com.example.wildshape5e.ui.FilterPopUp
import com.example.wildshape5e.ui.MyPicker

object DexterityFilter : Filter() {
    const val title = "Dexterity"

    override fun isActive(state: BeastListState) : Boolean {
        return state.dexterity != null
    }

    override fun message(state: BeastListState) : String {
        if (!isActive(state)) {
            return title
        } else {
            return "Dexterity: ${state.dexterity}"
        }
    }

    override fun filter(state: BeastListState, list : List<MonsterDetail>) : List<MonsterDetail> {
        if (!isActive(state)) {
            return list
        }
        return list.filter { monsterDetail -> monsterDetail.dexterity == state.dexterity }
    }

    @Composable
    override fun popUp(state: BeastListState, performAction : (BaseAction<BeastListState>) -> Unit) {
        FilterPopUp(
            name = DexterityFilter.title,
            { close(performAction) },
            { reset(performAction) }
        )  {
            MyPicker(default = state.dexterity?:0) {
                performAction(DexterityChosenAction(it))
            }

        }
    }

    override fun reset(performAction: (BaseAction<BeastListState>) -> Unit) {
        performAction(DexterityResetAction())
        close(performAction)
    }
}
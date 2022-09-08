package com.example.wildshape5e.beastlist

import androidx.compose.runtime.Composable
import com.example.wildshape5e.base.BaseAction
import com.example.wildshape5e.beastlist.actions.ConstitutionChosenAction
import com.example.wildshape5e.beastlist.actions.ConstitutionResetAction
import com.example.wildshape5e.repository.dataobjects.MonsterDetail
import com.example.wildshape5e.ui.FilterPopUp
import com.example.wildshape5e.ui.MyPicker

object ConstitutionFilter : Filter() {
    const val title = "Constitution"

    override fun isActive(state: BeastListState) : Boolean {
        return state.constitution != null
    }

    override fun message(state: BeastListState) : String {
        if (!isActive(state)) {
            return title
        } else {
            return "Constitution: ${state.constitution}"
        }
    }

    override fun filter(state: BeastListState, list : List<MonsterDetail>) : List<MonsterDetail> {
        if (!isActive(state)) {
            return list
        }
        return list.filter { monsterDetail -> monsterDetail.constitution == state.constitution }
    }

    @Composable
    override fun popUp(state: BeastListState, performAction : (BaseAction<BeastListState>) -> Unit) {
        FilterPopUp(
            name = ConstitutionFilter.title,
            { close(performAction) },
            { reset(performAction) }
        )  {
            MyPicker(default = state.constitution?:0) {
                performAction(ConstitutionChosenAction(it))
            }

        }
    }

    override fun reset(performAction: (BaseAction<BeastListState>) -> Unit) {
        performAction(ConstitutionResetAction())
        close(performAction)
    }
}
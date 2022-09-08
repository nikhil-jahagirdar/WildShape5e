package com.example.wildshape5e.beastlist

import androidx.compose.runtime.Composable
import com.example.wildshape5e.base.BaseAction
import com.example.wildshape5e.beastlist.actions.CharismaChosenAction
import com.example.wildshape5e.beastlist.actions.CharismaResetAction
import com.example.wildshape5e.repository.dataobjects.MonsterDetail
import com.example.wildshape5e.ui.FilterPopUp
import com.example.wildshape5e.ui.MyPicker

object CharismaFilter : Filter() {
    const val title = "Charisma"

    override fun isActive(state: BeastListState) : Boolean {
        return state.charisma != null
    }

    override fun message(state: BeastListState) : String {
        if (!isActive(state)) {
            return title
        } else {
            return "Charisma: ${state.charisma}"
        }
    }

    override fun filter(state: BeastListState, list : List<MonsterDetail>) : List<MonsterDetail> {
        if (!isActive(state)) {
            return list
        }
        return list.filter { monsterDetail -> monsterDetail.charisma == state.charisma }
    }

    @Composable
    override fun popUp(state: BeastListState, performAction : (BaseAction<BeastListState>) -> Unit) {
        FilterPopUp(
            name = CharismaFilter.title,
            { close(performAction) },
            { reset(performAction) }
        )  {
            MyPicker(default = state.charisma?:0) {
                performAction(CharismaChosenAction(it))
            }

        }
    }

    override fun reset(performAction: (BaseAction<BeastListState>) -> Unit) {
        performAction(CharismaResetAction())
        close(performAction)
    }
}
package com.example.wildshape5e.beastlist

import androidx.compose.runtime.Composable
import com.example.wildshape5e.base.BaseAction
import com.example.wildshape5e.beastlist.actions.WisdomChosenAction
import com.example.wildshape5e.beastlist.actions.WisdomResetAction
import com.example.wildshape5e.repository.dataobjects.MonsterDetail
import com.example.wildshape5e.ui.FilterPopUp
import com.example.wildshape5e.ui.MyPicker

object WisdomFilter : Filter() {
    const val title = "Wisdom"

    override fun isActive(state: BeastListState) : Boolean {
        return state.wisdom != null
    }

    override fun message(state: BeastListState) : String {
        if (!isActive(state)) {
            return title
        } else {
            return "Wisdom: ${state.wisdom}"
        }
    }

    override fun filter(state: BeastListState, list : List<MonsterDetail>) : List<MonsterDetail> {
        if (!isActive(state)) {
            return list
        }
        return list.filter { monsterDetail -> monsterDetail.wisdom == state.wisdom }
    }

    @Composable
    override fun popUp(state: BeastListState, performAction : (BaseAction<BeastListState>) -> Unit) {
        FilterPopUp(
            name = WisdomFilter.title,
            { close(performAction) },
            { reset(performAction) }
        )  {
            MyPicker(default = state.wisdom?:0) {
                performAction(WisdomChosenAction(it))
            }

        }
    }

    override fun reset(performAction: (BaseAction<BeastListState>) -> Unit) {
        performAction(WisdomResetAction())
        close(performAction)
    }
}
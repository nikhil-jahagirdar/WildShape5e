package com.example.wildshape5e.beastlist

import androidx.compose.runtime.Composable
import com.example.wildshape5e.base.BaseAction
import com.example.wildshape5e.beastlist.actions.FilterClickedAction
import com.example.wildshape5e.beastlist.actions.FilterClosedAction
import com.example.wildshape5e.beastlist.actions.RatingChosenAction
import com.example.wildshape5e.beastlist.actions.RatingResetAction
import com.example.wildshape5e.repository.dataobjects.MonsterDetail
import com.example.wildshape5e.ui.FilterPopUp
import com.example.wildshape5e.ui.MyPicker


object ChallengeRatingFilter : Filter() {

    const val title = "Challenge Rating"

    override fun isActive(state: BeastListState) : Boolean {
        return state.rating != null
    }

    override fun message(state: BeastListState) : String {
        if (!isActive(state) || state.filterClicked is ChallengeRatingFilter) {
            return title
        } else {
            return "Rating: ${state.rating}"
        }
    }

    override fun filter(state: BeastListState, list : List<MonsterDetail>) : List<MonsterDetail> {
        if (!isActive(state)) {
            return list
        }
        return list.filter { monsterDetail -> monsterDetail.challenge_rating == state.rating }
    }

    @Composable
    override fun popUp(state: BeastListState, performAction : (BaseAction<BeastListState>) -> Unit) {
        FilterPopUp(
            name = title,
            {close(performAction)},
            {
                performAction(RatingResetAction())
                performAction(FilterClosedAction())
            }
        )  {
            MyPicker(default = state.rating?:0) {
                performAction(RatingChosenAction(it))
            }

        }

    }

    override fun reset(performAction: (BaseAction<BeastListState>) -> Unit) {
        performAction(RatingResetAction())
        close(performAction)
    }
}
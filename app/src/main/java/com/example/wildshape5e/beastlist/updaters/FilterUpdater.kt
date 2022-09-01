package com.example.wildshape5e.beastlist.updaters

import com.example.wildshape5e.base.BaseUpdater
import com.example.wildshape5e.beastlist.BeastListState
import com.example.wildshape5e.beastlist.Filter

class FilterUpdater(private val filter: Filter?) : BaseUpdater<BeastListState> {
    override fun performUpdate(prevState: BeastListState): BeastListState {
        return prevState.copy(filterClicked = filter)
    }
}
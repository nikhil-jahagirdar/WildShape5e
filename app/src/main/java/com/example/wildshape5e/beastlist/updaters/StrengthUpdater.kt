package com.example.wildshape5e.beastlist.updaters

import com.example.wildshape5e.base.BaseUpdater
import com.example.wildshape5e.beastlist.BeastListState

class StrengthUpdater(private val newStrength : Int?) : BaseUpdater<BeastListState> {
    override fun performUpdate(prevState: BeastListState): BeastListState {
        return prevState.copy(strength = newStrength)

    }
}
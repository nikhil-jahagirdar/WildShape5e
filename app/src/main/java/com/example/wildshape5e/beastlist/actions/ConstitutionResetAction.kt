package com.example.wildshape5e.beastlist.actions

import com.example.wildshape5e.base.BaseAction
import com.example.wildshape5e.base.BaseEvent
import com.example.wildshape5e.base.BaseUpdater
import com.example.wildshape5e.beastlist.BeastListState
import com.example.wildshape5e.beastlist.updaters.ConstitutionUpdater

class ConstitutionResetAction() : BaseAction<BeastListState> {
    override suspend fun performAction(
        currentState: BeastListState,
        sendUpdate: (BaseUpdater<BeastListState>) -> Unit,
        sendEvent: (BaseEvent) -> Unit
    ) {
        sendUpdate(ConstitutionUpdater(null))
    }
}
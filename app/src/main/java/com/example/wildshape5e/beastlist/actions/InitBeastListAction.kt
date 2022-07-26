package com.example.wildshape5e.beastlist.actions


import com.example.wildshape5e.base.BaseAction
import com.example.wildshape5e.base.BaseEvent
import com.example.wildshape5e.base.BaseUpdater
import com.example.wildshape5e.beastlist.BeastListState
import com.example.wildshape5e.beastlist.updaters.BeastListUpdater
import com.example.wildshape5e.beastlist.updaters.FilteredBeastListUpdater
import com.example.wildshape5e.repository.BeastRepository

class InitBeastListAction(private val beastRepository: BeastRepository) : BaseAction<BeastListState> {
    override suspend fun performAction(
        currentState: BeastListState,
        sendUpdate: (BaseUpdater<BeastListState>) -> Unit,
        sendEvent: (BaseEvent) -> Unit
    ) {
        beastRepository.getBeasts().collect { result ->
            sendUpdate(BeastListUpdater(result))
            sendUpdate(FilteredBeastListUpdater())
        }

    }
}
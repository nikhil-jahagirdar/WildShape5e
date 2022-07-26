package com.example.wildshape5e.beastlist.updaters

import com.example.wildshape5e.base.BaseUpdater
import com.example.wildshape5e.base.DataResult
import com.example.wildshape5e.beastlist.BeastListState
import com.example.wildshape5e.repository.dataobjects.MonsterDetail

class BeastListUpdater(private val result : DataResult<List<MonsterDetail>>) : BaseUpdater<BeastListState> {
    override fun performUpdate(prevState: BeastListState): BeastListState {
        return prevState.copy(beastListData = result)
    }
}
package com.example.wildshape5e.beastlist.updaters

import com.example.wildshape5e.base.BaseUpdater
import com.example.wildshape5e.base.DataResult
import com.example.wildshape5e.beastlist.BeastListState
import com.example.wildshape5e.beastlist.filterList
import com.example.wildshape5e.repository.dataobjects.MonsterDetail

class FilteredBeastListUpdater() : BaseUpdater<BeastListState> {
    override fun performUpdate(prevState: BeastListState): BeastListState {
        val newList = when (prevState.beastListData) {
            is DataResult.Success -> {
                filterList.fold(prevState.beastListData.data) { currList, filter ->
                    filter.filter(prevState, currList)
                }
            }
            is DataResult.Error -> {
                listOf()
            }
            is DataResult.Loading -> {
                listOf()
            }
        }
        return prevState.copy(filteredBeastList = newList)
    }
}
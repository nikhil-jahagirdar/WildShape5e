package com.example.wildshape5e.repository

import com.example.wildshape5e.base.DataResult
import com.example.wildshape5e.repository.dataobjects.MonsterDetail
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class BeastRepository(private val beastWebService: BeastWebService, private val coroutineDispatcher: CoroutineDispatcher) {
    suspend fun getBeasts() : Flow<DataResult<List<MonsterDetail>>> {
        return flow {
            emit(DataResult.Loading)
            try {
                val monsterResults = beastWebService.getMonsters().results
                val monsterDetails = mutableListOf<MonsterDetail>()
                for (monster in monsterResults) {
                    val monsterDetail = beastWebService.getDetail(monster.index)
                    monsterDetails.add(monsterDetail)
                }
                val beastDetails = monsterDetails.filter { monsterDetail -> monsterDetail.type == "beast" } as MutableList
                beastDetails.sortBy { beast -> beast.name }
                emit(DataResult.Success(beastDetails))
            } catch (exception: Exception) {
                emit(DataResult.Error(exception.toString()))
            }
        }.flowOn(coroutineDispatcher)
    }
}
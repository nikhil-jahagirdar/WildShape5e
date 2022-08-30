package com.example.wildshape5e.repository

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.wildshape5e.repository.dataobjects.MonsterDetail

@Dao
interface BeastDao {
    @Query("SELECT * FROM monsterdetail")
    fun getMonsterDetails(): List<MonsterDetail>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllMonsterDetails(monsterdetails: List<MonsterDetail>)
}
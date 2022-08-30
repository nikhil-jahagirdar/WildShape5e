package com.example.wildshape5e.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.wildshape5e.repository.dataobjects.MonsterDetail


@Database(entities = [MonsterDetail::class], version = 1)
@TypeConverters(
    StringListTypeConverter::class,
    ProficiencyBonusListTypeConverter::class,
    ConditionListTypeConverter::class,
    AbilityListTypeConverter::class,
    ActionListTypeConverter::class
)
abstract class BeastDatabase : RoomDatabase() {
    abstract fun beastDao(): BeastDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: BeastDatabase? = null

        fun getDatabase(context: Context): BeastDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BeastDatabase::class.java,
                    "beast_database.db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
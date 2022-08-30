package com.example.wildshape5e.repository

import androidx.room.TypeConverter
import com.example.wildshape5e.repository.dataobjects.Ability
import com.example.wildshape5e.repository.dataobjects.Action
import com.example.wildshape5e.repository.dataobjects.Condition
import com.example.wildshape5e.repository.dataobjects.ProficiencyBonus
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue

abstract class ListTypeConverter<G> {
    @TypeConverter
    fun fromJson(value: String): List<G>? {
        val mapper = ObjectMapper()
        return mapper.readValue<List<G>>(value)
    }

    @TypeConverter
    fun listToJson(list: List<G>?): String? {
        val mapper = ObjectMapper()
        return mapper.writeValueAsString(list)
    }
}

class StringListTypeConverter : ListTypeConverter<String>()
class ProficiencyBonusListTypeConverter : ListTypeConverter<ProficiencyBonus>()
class ConditionListTypeConverter : ListTypeConverter<Condition>()
class AbilityListTypeConverter : ListTypeConverter<Ability>()
class ActionListTypeConverter : ListTypeConverter<Action>()
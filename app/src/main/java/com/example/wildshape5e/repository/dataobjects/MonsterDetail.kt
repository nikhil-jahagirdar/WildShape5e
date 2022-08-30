package com.example.wildshape5e.repository.dataobjects

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity

data class MonsterDetail(

    val index : String,
    @PrimaryKey
    val name : String,
    val size : String,
    val type : String,
    val alignment : String,
    val armor_class : Int,
    val hit_points : Int,
    @Embedded
    val speed : Speed,
    val strength : Int,
    val dexterity : Int,
    val constitution : Int,
    val intelligence : Int,
    val wisdom : Int,
    val charisma : Int,
    val proficiencies : List<ProficiencyBonus>,
    val damage_vulnerabilities : List<String>,
    val damage_resistances : List<String>,
    val damage_immunities : List<String>,
    val condition_immunities : List<Condition>,
    @Embedded
    val senses : Senses,
    val languages : String,
    val challenge_rating : Int,
    val xp : Int,
    val special_abilities : List<Ability>,
    val actions : List<Action>?,
    val url : String
)

package com.s2start.marvel.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "character")
data class Character (
    @PrimaryKey
    val id:Int,
    val name:String?,
    val description:String?
)
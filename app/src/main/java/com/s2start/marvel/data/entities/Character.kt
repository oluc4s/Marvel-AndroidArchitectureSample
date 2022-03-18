package com.s2start.marvel.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@Entity(tableName = "character")
data class Character (
    @PrimaryKey
    val id:Int,
    val name:String?,
    val description:String?,
    val thumbnail:Image?
)
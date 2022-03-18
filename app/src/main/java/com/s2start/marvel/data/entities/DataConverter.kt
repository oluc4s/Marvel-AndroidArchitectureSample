package com.s2start.marvel.data.entities

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class DataConverter {
    @TypeConverter
    fun fromImage(value: Image): String {
        val gson = Gson()
        val type = object : TypeToken<Image>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toImage(value: String): Image {
        val gson = Gson()
        val type = object : TypeToken<Image>() {}.type
        return gson.fromJson(value, type)
    }
}

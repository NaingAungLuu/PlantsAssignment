package com.androboy.plants.persistence.typeConverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class PlantTypeConverter {

    @TypeConverter
    fun toJson(plantType : List<String>) : String{
        return Gson().toJson(plantType)
    }

    @TypeConverter
    fun fromJson(Json : String) : List<String>
    {
        val token = object : TypeToken<List<String>>(){}.type
        return Gson().fromJson(Json , token)
    }

}
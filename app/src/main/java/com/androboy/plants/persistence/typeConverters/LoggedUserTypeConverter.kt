package com.androboy.plants.persistence.typeConverters

import androidx.room.TypeConverter
import com.androboy.plants.data.vos.LoggedInUserVO
import com.google.gson.Gson

class LoggedUserTypeConverter {

    @TypeConverter
    fun toJson(user : LoggedInUserVO) : String
    {
        return Gson().toJson(user)
    }

    @TypeConverter
    fun fromJson(Json : String) : LoggedInUserVO
    {
        return Gson().fromJson(Json , LoggedInUserVO::class.java)
    }

}
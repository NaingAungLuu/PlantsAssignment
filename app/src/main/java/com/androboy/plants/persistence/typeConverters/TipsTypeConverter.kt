package com.androboy.plants.persistence.typeConverters

import androidx.room.TypeConverter
import com.androboy.plants.data.vos.TipsVO
import com.google.gson.Gson

class TipsTypeConverter {

    @TypeConverter
    fun toJson(tips : TipsVO) : String
    {
        return Gson().toJson(tips)
    }

    @TypeConverter
    fun fromJson(Json : String) : TipsVO
    {
        return Gson().fromJson(Json , TipsVO::class.java)
    }

}
package com.androboy.plants.persistence.typeConverters

import androidx.room.TypeConverter
import com.androboy.plants.data.vos.UploadedUserVO
import com.google.gson.Gson


class UserTypeCoverter {

    @TypeConverter
    fun toJson(user : UploadedUserVO) : String{
        return Gson().toJson(user)
    }

    @TypeConverter
    fun fromJson(Json : String) : UploadedUserVO
    {
        return Gson().fromJson(Json , UploadedUserVO::class.java)
    }

}
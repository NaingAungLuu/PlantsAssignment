package com.androboy.plants.data.vos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "login")
data class LoggedInUserVO (

    @PrimaryKey
    @ColumnInfo(name = "user_id")
    @SerializedName("user_id")
    val userID : String,

    @ColumnInfo(name = "user_name")
    @SerializedName("user_name")
    val userName : String,

    @ColumnInfo(name = "user_photo_url")
    @SerializedName("user_photo_url")
    val userPhotoUrl : String,

    @ColumnInfo(name = "member_since")
    @SerializedName("member_since")
    val memberSince : String,

    @ColumnInfo(name = "member_rank")
    @SerializedName("member_rank")
    val memberRank : String

){

}
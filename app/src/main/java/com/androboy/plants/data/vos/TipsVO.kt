package com.androboy.plants.data.vos

import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName

data class TipsVO(


    @SerializedName("temperature")
    val temperature : String,


    @SerializedName("light")
    val light : String,


    @SerializedName("placement")
    val placement : String

) {
}
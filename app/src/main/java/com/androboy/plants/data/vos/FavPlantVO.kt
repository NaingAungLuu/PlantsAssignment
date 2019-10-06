package com.androboy.plants.data.vos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "favourites")
data class FavPlantVO(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val idPK : Int,

    @ColumnInfo(name = "plant_id")
    val plantID : String

) {

}
package com.androboy.plants.data.vos

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "plants")
data class PlantVO(

    @PrimaryKey
    @ColumnInfo(name = "plant_id")
    @SerializedName("plant_id")
    val plantID : String,

    @ColumnInfo(name = "plant_name")
    @SerializedName("plant_name")
    val plantName: String,

    @ColumnInfo(name = "plant_type")
    @SerializedName("plant_type")
    val plantType: List<String>,

    @ColumnInfo(name = "description")
    @SerializedName("description")
    val plantDescription: String,

    @ColumnInfo(name = "top_tip")
    @SerializedName("top_tip")
    val plantTopTip : String,

    @Embedded(prefix = "tips_")
    @SerializedName("tips")
    val plantTips: TipsVO,

    @Embedded(prefix = "uploaded_user_")
    @SerializedName("uploaded_user")
    val uploadedUser: UploadedUserVO,

    @ColumnInfo(name = "plant_photo")
    @SerializedName("plant_photo")
    val plantPhotoUrl : String

) {
}
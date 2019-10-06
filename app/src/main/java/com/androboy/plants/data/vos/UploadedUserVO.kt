package com.androboy.plants.data.vos

import com.google.gson.annotations.SerializedName

data class UploadedUserVO(

    @SerializedName("name")
    val userName : String,

    @SerializedName("user_photo")
    val userPhotoUrl : String,

    @SerializedName("uploaded_time")
    val uploadedTime : String,

    @SerializedName("user_rank")
    val userRank : String

) {
}
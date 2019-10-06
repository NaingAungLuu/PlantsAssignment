package com.androboy.plants.network.reponse

import com.androboy.plants.data.vos.PlantVO
import com.google.gson.annotations.SerializedName

data class PlantsResponse(

    @SerializedName("message")
    val message : String,

    @SerializedName("code")
    val code : Int,

    @SerializedName("data")
    val data: List<PlantVO>


) {
    fun isResponseOk() : Boolean
    {
        return (code == 200 && data != null)
    }
}
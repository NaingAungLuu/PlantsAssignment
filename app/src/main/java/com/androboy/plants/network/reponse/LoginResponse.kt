package com.androboy.plants.network.reponse

import com.androboy.plants.data.vos.LoggedInUserVO
import com.google.gson.annotations.SerializedName

data class LoginResponse (

    @SerializedName("message")
    val message : String,

    @SerializedName("code")
    val code : Int,

    @SerializedName("data")
    val data : LoggedInUserVO
)
{
    fun isResponseOk(): Boolean
    {
        return (data != null && code == 200)
    }
}
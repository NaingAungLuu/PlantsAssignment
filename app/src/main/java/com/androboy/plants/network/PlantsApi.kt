package com.androboy.plants.network

import com.androboy.plants.network.reponse.LoginResponse
import com.androboy.plants.network.reponse.PlantsResponse
import com.androboy.plants.utils.*
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface PlantsApi {

    @POST(GET_PLANTS)
    @FormUrlEncoded
    fun getAllPlants(@Field(PARAM_ACCESS_TOKEN) accessToken : String ) : Call<PlantsResponse>


    @POST(LOGIN)
    @FormUrlEncoded
    fun login(@Field(PARAM_USERNAME) username : String , @Field(PARAM_PASSWORD) password : String) : Call<LoginResponse>


}
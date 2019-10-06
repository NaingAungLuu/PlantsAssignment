package com.androboy.plants.network.dataAgents

import com.androboy.plants.data.vos.LoggedInUserVO
import com.androboy.plants.data.vos.PlantVO
import com.androboy.plants.network.PlantsApi
import com.androboy.plants.network.reponse.LoginResponse
import com.androboy.plants.network.reponse.PlantsResponse
import com.androboy.plants.utils.BASE_URL
import com.androboy.plants.utils.ERROR_MESSAGE
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetroFitDataAgent: PlantDataAgent {


    private lateinit var plantApi : PlantsApi

    init {
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(15 , TimeUnit.SECONDS)
            .readTimeout(15 , TimeUnit.SECONDS)
            .writeTimeout(15 , TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        plantApi = retrofit.create(PlantsApi::class.java)

    }

    override fun getAllPlants(
        accessToken: String,
        onSuccess: (List<PlantVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {

        val call = plantApi.getAllPlants(accessToken)
        call.enqueue(object : Callback<PlantsResponse>{

            override fun onFailure(call: Call<PlantsResponse>, t: Throwable) {
                onFailure(t.localizedMessage)
            }

            override fun onResponse(
                call: Call<PlantsResponse>,
                response: Response<PlantsResponse>
            ) {

                val plantResponse = response.body()

                if(plantResponse != null)
                {
                    if(plantResponse.isResponseOk())
                    {
                        onSuccess(plantResponse.data)
                    }
                    else
                    {
                        onFailure(plantResponse.message)
                    }
                    println("network success!!")
                }
                else
                {
                    onFailure(ERROR_MESSAGE)
                    println("network failedd!!")
                }

            }


        })



    }

    override fun login(
        username: String,
        password: String,
        onSuccess: (LoggedInUserVO) -> Unit,
        onFailure: (String) -> Unit
    ) {
        val call = plantApi.login(username , password)

        call.enqueue(object : Callback<LoginResponse>{

            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {

                val loginResponse = response.body()

                if(loginResponse != null)
                {
                    if(loginResponse.isResponseOk())
                    {
                        onSuccess(loginResponse.data)
                    }
                    else
                    {
                        onFailure(loginResponse.message)
                    }
                }
                else
                {
                    onFailure(response.message())
                }

            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {

                onFailure(t.localizedMessage)

            }

        })
    }

}
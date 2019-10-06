package com.androboy.plants.network.dataAgents

import com.androboy.plants.data.vos.LoggedInUserVO
import com.androboy.plants.data.vos.PlantVO

interface PlantDataAgent {

    fun getAllPlants(
        accessToken : String,
        onSuccess : (List<PlantVO>) -> Unit,
        onFailure : (String) -> Unit
    )

    fun login(
        username : String,
        password : String,
        onSuccess: (LoggedInUserVO) -> Unit,
        onFailure: (String) -> Unit
    )

}
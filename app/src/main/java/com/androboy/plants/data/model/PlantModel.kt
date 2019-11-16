package com.androboy.plants.data.model

import android.content.Context
import com.androboy.plants.data.vos.LoggedInUserVO
import com.androboy.plants.data.vos.PlantVO

interface PlantModel {

    fun getPlants(
        onSuccess: (List<PlantVO>) -> Unit,
        onFailure: (String) -> Unit
    )

    fun addFavourite(plantID : String)


}
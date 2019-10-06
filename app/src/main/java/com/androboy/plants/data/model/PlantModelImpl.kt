package com.androboy.plants.data.model

import com.androboy.plants.data.vos.LoggedInUserVO
import com.androboy.plants.data.vos.PlantVO
import com.androboy.plants.utils.ACCESS_TOKEN

object PlantModelImpl : BaseModel() , PlantModel {



    override fun getPlants(onSuccess: (List<PlantVO>) -> Unit, onFailure: (String) -> Unit) {

        val plantData = plantDatabase.getPlantDao().getAllPlants()

        if(!plantData.isEmpty())
        {
            onSuccess(plantData)
        }
        else {

            dataAgent.getAllPlants(
                ACCESS_TOKEN,
                {
                    plantDatabase.getPlantDao().insertPlants(it)
                    onSuccess(it)
                },
                onFailure
            )
        }



    }




}
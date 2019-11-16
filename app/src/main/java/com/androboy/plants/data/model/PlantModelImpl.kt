package com.androboy.plants.data.model

import android.content.Context
import com.androboy.plants.data.vos.FavPlantVO
import com.androboy.plants.data.vos.LoggedInUserVO
import com.androboy.plants.data.vos.PlantVO
import com.androboy.plants.persistence.PlantDatabase
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

    override fun addFavourite(plantID : String){
        val favplantDao = plantDatabase.getFavPlantsDao()
        val favPlant = FavPlantVO( 0 , plantID)
        favplantDao.insertPlant(favPlant)
        val favPlantsList = getFavPlants()

        println("Added Fav")
    }

    fun getFavPlants() : List<PlantVO>
    {
        val plantDao = plantDatabase.getPlantDao()
        val favPlantsDao = plantDatabase.getFavPlantsDao()
        val favPlantIDs = favPlantsDao.getAllPlantID()
        val favPlants = ArrayList<PlantVO>()

        favPlantIDs.forEach {
            favPlants.add(plantDao.getPlantById(it.plantID))
        }

        return  favPlants
    }


}
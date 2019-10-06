package com.androboy.plants.persistence.daos

import android.content.Context
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.androboy.plants.data.vos.FavPlantVO
import com.androboy.plants.data.vos.PlantVO
import com.androboy.plants.persistence.PlantDatabase

abstract class FavPlantsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertPlant(plantID : Int)

    @Query("SELECT * FROM favourites")
    abstract fun getAllPlantID() : List<String>

    fun getFavPlants(context: Context) : List<PlantVO>
    {
        val favPlantIDs = getAllPlantID()
        val favPlants = ArrayList<PlantVO>()

        favPlantIDs.forEach {
           favPlants.add(PlantDatabase.getInstance(context).getPlantDao().getPlantById(it))
        }

        return  favPlants
    }

}
package com.androboy.plants.persistence.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.androboy.plants.data.vos.PlantVO
import com.androboy.plants.utils.PLANT_DB

@Dao
abstract class PlantsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertPlants(plants : List<PlantVO>) : LongArray

    @Query("SELECT * FROM plants")
    abstract fun getAllPlants(): List<PlantVO>

    @Query("SELECT * FROM plants WHERE plant_id = :plantID")
    abstract fun getPlantById(plantID : String) : PlantVO

    fun isDatabaseEmpty():Boolean
    {
        return getAllPlants().isEmpty()
    }

}
package com.androboy.plants.persistence.daos

import android.content.Context
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.androboy.plants.data.vos.FavPlantVO
import com.androboy.plants.data.vos.PlantVO
import com.androboy.plants.persistence.PlantDatabase

@Dao
abstract class FavPlantsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertPlant(plantToInsert : FavPlantVO) : Long

    @Query("SELECT * FROM favourites")
    abstract fun getAllPlantID() : List<FavPlantVO>



}
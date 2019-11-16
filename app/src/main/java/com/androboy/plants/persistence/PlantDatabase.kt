package com.androboy.plants.persistence

import android.content.Context
import androidx.room.*
import com.androboy.plants.data.vos.FavPlantVO
import com.androboy.plants.data.vos.LoggedInUserVO
import com.androboy.plants.data.vos.PlantVO
import com.androboy.plants.persistence.daos.FavPlantsDao
import com.androboy.plants.persistence.daos.LoginUserDao
import com.androboy.plants.persistence.daos.PlantsDao
import com.androboy.plants.persistence.typeConverters.LoggedUserTypeConverter
import com.androboy.plants.persistence.typeConverters.PlantTypeConverter
import com.androboy.plants.persistence.typeConverters.TipsTypeConverter
import com.androboy.plants.persistence.typeConverters.UserTypeCoverter
import com.androboy.plants.utils.PLANT_DB

@Database(entities = [PlantVO::class , LoggedInUserVO::class , FavPlantVO::class] , version = 4 , exportSchema = true)
@TypeConverters(PlantTypeConverter::class , TipsTypeConverter::class , UserTypeCoverter::class , LoggedUserTypeConverter::class)
abstract class PlantDatabase :RoomDatabase() {

    abstract fun getPlantDao() : PlantsDao

    abstract fun getLoginUserDao() : LoginUserDao

    abstract fun getFavPlantsDao() : FavPlantsDao

    companion object{
        private var instance : PlantDatabase? = null

        fun getInstance(context: Context) : PlantDatabase
        {
            if(instance == null)
            {
                instance = Room.databaseBuilder(context , PlantDatabase::class.java , PLANT_DB)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }

            val db = instance!!
            return db
        }

    }

}
package com.androboy.plants.data.model

import android.content.Context
import com.androboy.plants.data.vos.PlantVO
import com.androboy.plants.network.dataAgents.PlantDataAgent
import com.androboy.plants.network.dataAgents.RetroFitDataAgent
import com.androboy.plants.persistence.PlantDatabase

abstract class BaseModel {

    protected val dataAgent : PlantDataAgent = RetroFitDataAgent

    protected lateinit var plantDatabase : PlantDatabase

    fun initDatabase(context: Context)
    {
        plantDatabase = PlantDatabase.getInstance(context)

    }




}
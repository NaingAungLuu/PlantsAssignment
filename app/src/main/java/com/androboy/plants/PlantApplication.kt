package com.androboy.plants

import android.app.Application
import android.content.Intent
import com.androboy.plants.activities.CatalogueActivity
import com.androboy.plants.activities.LoginActivity
import com.androboy.plants.data.model.PlantModelImpl
import com.androboy.plants.persistence.PlantDatabase

class PlantApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        PlantModelImpl.initDatabase(applicationContext)
    }
}
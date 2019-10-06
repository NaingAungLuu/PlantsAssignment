package com.androboy.plants.mvp.views

import com.androboy.plants.data.vos.PlantVO

interface PlantDetailView : BaseView {

    fun displayPlantInfo(plant : PlantVO)

}
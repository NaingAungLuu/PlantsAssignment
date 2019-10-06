package com.androboy.plants.mvp.views

import com.androboy.plants.data.vos.PlantVO

interface CatalogueView : BaseView {

    fun displayCatalogue(plantList : List<PlantVO>)
    fun displayErrorMessage(msg : String)
    fun navigateToDetail(plantID : String)

}
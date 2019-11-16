package com.androboy.plants.mvp.presenters

import com.androboy.plants.data.model.PlantModelImpl
import com.androboy.plants.delegate.PlantDelegate
import com.androboy.plants.mvp.views.FavouriteView

class FavouritePresenter : BasePresenter<FavouriteView>() , PlantDelegate {

    override fun onTapFavButton(plantID: String) {

    }


    override fun onTapPlantItem(plantID: String) {
        mView.navigateToDetail(plantID)
    }

    fun onUIReady() {
        val model = PlantModelImpl
        mView.showFavouritePlants(model.getFavPlants())
    }


}
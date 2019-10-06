package com.androboy.plants.mvp.presenters

import com.androboy.plants.delegate.PlantDelegate
import com.androboy.plants.mvp.views.FavouriteView

class FavouritePresenter : BasePresenter<FavouriteView>() , PlantDelegate {


    override fun onTapPlantItem(plantID: String) {
        mView.navigateToDetail(plantID)
    }



}
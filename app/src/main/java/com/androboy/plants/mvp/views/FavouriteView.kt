package com.androboy.plants.mvp.views

import com.androboy.plants.data.vos.PlantVO
import com.androboy.plants.mvp.presenters.BasePresenter

interface FavouriteView : BaseView {

    fun showFavouritePlants( plants:  List<PlantVO>)
    fun displayErrorMessage(msg : String)
    fun navigateToDetail(plantID : String)

}
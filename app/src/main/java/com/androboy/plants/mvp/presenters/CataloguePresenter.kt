package com.androboy.plants.mvp.presenters

import android.widget.ProgressBar
import com.androboy.plants.data.model.PlantModelImpl
import com.androboy.plants.delegate.PlantDelegate
import com.androboy.plants.mvp.views.CatalogueView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_catalogue.*

class CataloguePresenter : BasePresenter<CatalogueView>(), PlantDelegate {

    private val model = PlantModelImpl

    override fun onTapFavButton(plantID: String) {

        println("Tapped on fav icon!! $plantID")
        model.addFavourite(plantID)
    }

    override fun onTapPlantItem(plantID: String) {
        mView.navigateToDetail(plantID)
    }


    override fun onCreate()
    {

        model.getPlants(onSuccess =
        {plantData ->

            mView.displayCatalogue(plantData)

        },onFailure =
        {

            mView.displayErrorMessage(it)

        })
    }


}
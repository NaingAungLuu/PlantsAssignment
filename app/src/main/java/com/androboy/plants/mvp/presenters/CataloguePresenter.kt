package com.androboy.plants.mvp.presenters

import android.widget.ProgressBar
import com.androboy.plants.data.model.PlantModelImpl
import com.androboy.plants.delegate.PlantDelegate
import com.androboy.plants.mvp.views.CatalogueView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_catalogue.*

class CataloguePresenter : BasePresenter<CatalogueView>(), PlantDelegate {

    override fun onTapPlantItem(plantID: String) {
        mView.navigateToDetail(plantID)
    }

    fun onTapFavourite(plantID : String)
    {

    }

    override fun onCreate()
    {
        val model = PlantModelImpl

        model.getPlants(onSuccess =
        {plantData ->

            mView.displayCatalogue(plantData)

        },onFailure =
        {

            mView.displayErrorMessage(it)

        })
    }


}
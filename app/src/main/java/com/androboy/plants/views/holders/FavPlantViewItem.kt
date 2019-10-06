package com.androboy.plants.views.holders

import android.view.View
import com.androboy.plants.data.vos.PlantVO
import com.androboy.plants.delegate.PlantDelegate
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.favourite_plant_view_item.view.*

class FavPlantViewItem(itemView: View , delegate : PlantDelegate) : BaseViewHolder<PlantVO>(itemView) {

    init {

        itemView.setOnClickListener {

                delegate.onTapPlantItem(data?.plantID ?: "")

        }

    }

    override fun bindData(data: PlantVO) {
        this.data = data
        Glide.with(itemView.context).load(data.plantPhotoUrl).into(itemView.ivFavouritePlant)
    }



}
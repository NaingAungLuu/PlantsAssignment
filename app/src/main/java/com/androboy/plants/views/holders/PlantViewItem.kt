package com.androboy.plants.views.holders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.androboy.plants.adapters.PlantCatalougeAdapter
import com.androboy.plants.data.vos.PlantVO
import com.androboy.plants.delegate.PlantDelegate
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.plant_view_item.view.*

class PlantViewItem(itemView: View , delegate: PlantDelegate) : BaseViewHolder<PlantVO>(itemView) {

    init {
        //Check if the layout is the correct one
        if(itemView.tvPlantName != null) {
            println(itemViewType)
            itemView.ivPlant.setOnClickListener {
                data?.plantID?.let {
                    delegate.onTapPlantItem(it)
                    println("CLicked!")
                }
            }
            itemView.ivFavourite.setOnClickListener {

            }
        }

    }

    override fun bindData(data: PlantVO) {

        itemView.tvPlantName.text = data.plantName
        itemView.tvUserName.text = "By ${data.uploadedUser.userName} ."
        Glide.with(itemView.context).load(data.plantPhotoUrl).into(itemView.ivPlant)
        Glide.with(itemView.context).load(data.uploadedUser.userPhotoUrl).into(itemView.ivProfilePicture)
    }


}
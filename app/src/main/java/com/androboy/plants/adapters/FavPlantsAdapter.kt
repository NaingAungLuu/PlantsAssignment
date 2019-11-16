package com.androboy.plants.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.androboy.plants.R
import com.androboy.plants.data.vos.PlantVO
import com.androboy.plants.delegate.PlantDelegate
import com.androboy.plants.views.holders.FavPlantViewItem
import com.androboy.plants.views.holders.PlantViewItem

class FavPlantsAdapter( private val delegate : PlantDelegate) : BaseAdapter<FavPlantViewItem , PlantVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavPlantViewItem {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.favourite_plant_view_item , parent , false)
        return FavPlantViewItem(view , delegate)

    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: FavPlantViewItem, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.data = dataList[position]
    }




}
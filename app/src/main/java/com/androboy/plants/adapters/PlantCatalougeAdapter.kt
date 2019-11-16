package com.androboy.plants.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.androboy.plants.R
import com.androboy.plants.data.vos.PlantVO
import com.androboy.plants.delegate.PlantDelegate
import com.androboy.plants.views.holders.PlantViewItem

class PlantCatalougeAdapter(private val delegate: PlantDelegate) : BaseAdapter<PlantViewItem , PlantVO>() {

      val TOP_LAYOUT = 0
      val ITEMS = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantViewItem {
        val layoutID : Int
        if(viewType == TOP_LAYOUT)
        {
            layoutID = R.layout.plant_view_item_1
        }
        else
        {
            layoutID = R.layout.plant_view_item
        }
        val view = LayoutInflater.from(parent.context).inflate(layoutID , parent , false)
        return PlantViewItem(view , delegate)
    }

    override fun getItemViewType(position: Int): Int {
        return when(position){
            0 -> TOP_LAYOUT
            else -> ITEMS
        }
    }

    override fun onBindViewHolder(holder: PlantViewItem, position: Int) {
        if(position > 0) {
            holder.data = dataList[position-1]
        }
    }
}
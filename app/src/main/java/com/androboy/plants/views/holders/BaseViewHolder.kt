package com.androboy.plants.views.holders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.androboy.plants.adapters.PlantCatalougeAdapter
import com.androboy.plants.data.vos.PlantVO

abstract class BaseViewHolder<T>(itemView : View) : RecyclerView.ViewHolder(itemView) {

    protected val TOP_LAYOUT = 0
    protected val ITEMS = 1

    var data: T? = null
    set(value) {
        field = value

        value?.let {
            if(itemViewType != TOP_LAYOUT) {
                bindData(value)
                println(itemViewType)
                println("data set")
            }
        }

    }


    protected abstract fun bindData(data : T)


}
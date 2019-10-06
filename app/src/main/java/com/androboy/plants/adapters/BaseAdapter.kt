package com.androboy.plants.adapters

import androidx.recyclerview.widget.RecyclerView
import com.androboy.plants.views.holders.BaseViewHolder
import com.androboy.plants.views.holders.PlantViewItem

abstract class BaseAdapter<VH: BaseViewHolder<T>, T> : RecyclerView.Adapter<VH>() {

    protected var dataList: MutableList<T> = ArrayList()


    override fun getItemCount(): Int {
        return dataList.size + 1
    }

    override fun onBindViewHolder(holder: VH, position: Int) {

    }

    fun setNewData(newData : MutableList<T>)
    {
        dataList = newData
        notifyDataSetChanged()
    }

    fun appendNewData(newData: MutableList<T>)
    {
        dataList.addAll(newData)
        notifyDataSetChanged()
    }




}
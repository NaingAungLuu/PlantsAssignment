package com.androboy.plants.mvp.presenters

import android.content.Context
import com.androboy.plants.mvp.views.BaseView

abstract class BasePresenter<T : BaseView> {
    protected lateinit var mView: T

    open fun initPresenter(view: T)
    {
        this.mView = view
    }

    open fun onCreate(){}
    open fun onDestroy(){}
    open fun onStart(){}
    open fun onStop(){}
    open fun onPause(){}
    open fun onResume(){}




}
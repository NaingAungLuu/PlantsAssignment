package com.androboy.plants.mvp.views

import android.content.Context

interface LoginView : BaseView{

    fun getContext() : Context
    fun navigateToCatalogue(userID : String)
}

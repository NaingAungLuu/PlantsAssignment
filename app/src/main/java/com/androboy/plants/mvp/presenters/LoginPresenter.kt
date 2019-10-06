package com.androboy.plants.mvp.presenters

import android.content.Context
import com.androboy.plants.delegate.LoginDelegate
import com.androboy.plants.mvp.views.LoginView
import com.androboy.plants.persistence.PlantDatabase

class LoginPresenter : BasePresenter<LoginView>() , LoginDelegate{



    override fun onTapLoginButton(email: String, password: String) {

        val context = mView.getContext()
        val userDao = PlantDatabase.getInstance(context).getLoginUserDao()

        if(!userDao.isDatabaseEmpty())
        {
            val loggedInUser = userDao.getLoggedInUser().get(0)
            mView.navigateToCatalogue(loggedInUser.userID)
        }
       else
        {
            mView.navigateToCatalogue("HELLo")
        }

    }

    override fun onCreate() {


    }

    fun onUIReady(context: Context)
    {

    }

}
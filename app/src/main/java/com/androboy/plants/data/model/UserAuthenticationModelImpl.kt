package com.androboy.plants.data.model

import com.androboy.plants.data.vos.LoggedInUserVO

object UserAuthenticationModelImpl : BaseModel() , UserAuthenticationModel {

    override fun login(
        username: String,
        password: String,
        onSuccess: (LoggedInUserVO) -> Unit,
        onFailure: (String) -> Unit
    ) {

            dataAgent.login(username , password , {
                plantDatabase.getLoginUserDao().insertUser(it)
                onSuccess(it)
            },
                onFailure)


    }

    override fun logout(userID : String) {
        plantDatabase.getLoginUserDao().deleteLoggedInUser(userID)
    }

}
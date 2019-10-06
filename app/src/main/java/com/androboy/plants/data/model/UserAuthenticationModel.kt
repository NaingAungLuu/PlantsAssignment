package com.androboy.plants.data.model

import com.androboy.plants.data.vos.LoggedInUserVO

interface UserAuthenticationModel {

    fun login(
        username : String,
        password : String,
        onSuccess : (LoggedInUserVO) -> Unit,
        onFailure: (String) -> Unit
    )

    fun logout(userID : String)
}
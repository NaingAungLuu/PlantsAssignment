package com.androboy.plants.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.androboy.plants.data.model.PlantModel
import com.androboy.plants.data.model.PlantModelImpl
import com.androboy.plants.data.model.UserAuthenticationModel
import com.androboy.plants.data.model.UserAuthenticationModelImpl

abstract class BaseActivity : AppCompatActivity(){

    protected lateinit var model : PlantModel
    protected lateinit var userModel : UserAuthenticationModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        model = PlantModelImpl
        userModel = UserAuthenticationModelImpl
    }
}
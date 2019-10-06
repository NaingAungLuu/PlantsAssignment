package com.androboy.plants.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import com.androboy.plants.R
import com.androboy.plants.data.vos.PlantVO
import com.androboy.plants.mvp.views.PlantDetailView
import com.androboy.plants.persistence.PlantDatabase
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_plant_detail.*

class PlantDetailActivity : BaseActivity() , PlantDetailView{

    override fun displayPlantInfo(plant: PlantVO) {

    }

    companion object{

        const val PLANT_ID = "PLANT_ID"

        fun newIntent(context : Context? , plantID : String) : Intent
        {
            val intent = Intent(context , PlantDetailActivity::class.java).apply {
                putExtra(PLANT_ID , plantID)
            }
            return intent
        }
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_plant_detail)
        val plantDao = PlantDatabase.getInstance(applicationContext).getPlantDao()
        bindDetailData(plantDao.getPlantById(intent.getStringExtra(PLANT_ID)))
        ivDetailBack.setOnClickListener {
            onBackPressed()
        }

    }

    fun bindDetailData(data : PlantVO)
    {
        Glide.with(applicationContext).load(data.plantPhotoUrl).into(ivDetailPlant)
        Glide.with(applicationContext).load(data.uploadedUser.userPhotoUrl).into(ivDetailProfilePicture)
        tvDetailPlantName.text = data.plantName
        tvDetailUserName.text = "by ${data.uploadedUser.userName} ."
        tvDetailDescription.text = data.plantDescription
        tvTemperature.text = data.plantTips.temperature
        tvLight.text = data.plantTips.light
        println(data.plantTips.light)
        tvPlacement.text = data.plantTips.placement
    }
}
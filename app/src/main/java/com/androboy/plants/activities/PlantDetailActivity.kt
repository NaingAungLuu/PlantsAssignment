package com.androboy.plants.activities

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.view.animation.OvershootInterpolator
import com.androboy.plants.R
import com.androboy.plants.data.vos.PlantVO
import com.androboy.plants.mvp.views.PlantDetailView
import com.androboy.plants.persistence.PlantDatabase
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_plant_detail.*
import kotlinx.android.synthetic.main.activity_plant_detail.view.*

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

    private var isFavourite = false


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
        startPlantDetailAnimation()
        setupListeners()
    }

    private fun startPlantDetailAnimation()
    {
        val handler = Handler()
        handler.postDelayed( { playPlantTipsAnimation() } , 500)
    }

    private fun playPlantTipsAnimation() {
        val tipsAnimator = ObjectAnimator.ofFloat(lyPLantDetailTips , View.TRANSLATION_X , 500f , 0f)
        tipsAnimator.duration = 1000
        tipsAnimator.interpolator = OvershootInterpolator()
        tipsAnimator.addListener(object : AnimatorListenerAdapter()
        {
            override fun onAnimationEnd(animation: Animator?) {
                playFavouriteButtonAnimation()
            }

            override fun onAnimationStart(animation: Animator?) {
                lyPLantDetailTips.visibility = View.VISIBLE
            }
        })
        tipsAnimator.start()
    }

    private fun playFavouriteButtonAnimation()
    {

    }

    private fun setupListeners()
    {
        ivFavourite.setOnClickListener {
            if(isFavourite) {

                isFavourite = false
                btnFavourite.reverseAnimationSpeed()
                btnFavourite.visibility = View.VISIBLE
                ivFavourite.visibility = View.INVISIBLE
                btnFavourite.playAnimation()

            }
            else
            {
                isFavourite = true
                btnFavourite.speed = 1f
                btnFavourite.visibility = View.VISIBLE
                ivFavourite.visibility = View.INVISIBLE
                btnFavourite.playAnimation()

            }
            btnFavourite.addAnimatorListener(object : AnimatorListenerAdapter(){

                override fun onAnimationEnd(animation: Animator?) {
                    ivFavourite.visibility = View.VISIBLE
                    btnFavourite.visibility  = View.INVISIBLE
                }

                override fun onAnimationStart(animation: Animator?) {
                    if(isFavourite)
                    {
                        ivFavourite.setImageResource(R.drawable.ic_favorite_black_24dp)

                    }
                    else
                    {
                        ivFavourite.setImageResource(R.drawable.ic_favorite_border_black_24dp)
                    }


                }
            })
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
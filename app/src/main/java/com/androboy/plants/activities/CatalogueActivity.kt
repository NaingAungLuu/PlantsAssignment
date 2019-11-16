package com.androboy.plants.activities

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.transition.Fade
import android.view.*
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.OvershootInterpolator
import android.widget.ProgressBar
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.androboy.plants.R
import com.androboy.plants.adapters.PlantCatalougeAdapter
import com.androboy.plants.data.vos.PlantVO
import com.androboy.plants.mvp.presenters.CataloguePresenter
import com.androboy.plants.mvp.views.CatalogueView
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_catalogue.*
import kotlinx.android.synthetic.main.plant_view_item.*

class CatalogueActivity : BaseActivity(), CatalogueView , NavigationView.OnNavigationItemSelectedListener{

    override fun displayCatalogue(plantList: List<PlantVO>) {
        mAdapter.setNewData(plantList.toMutableList())
        pbProgress.visibility = ProgressBar.INVISIBLE
    }

    override fun displayErrorMessage(msg: String) {
        Snackbar.make(catalogueRootView , msg , Snackbar.LENGTH_LONG).show()
    }

    override fun navigateToDetail(plantID: String) {
        val plantImagePair = Pair.create(ivPlant as View , "tPlantImage")
        val plantNamePair = Pair.create(tvPlantName as View , "tPlantName")
        val plantOwnerPair = Pair.create(tvUserName as View , "tPlantOwner")
        val plantOwnerImagePair = Pair.create(ivProfilePicture  as View , "tPlantOwnerName")
        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this , plantImagePair , plantNamePair )
        startActivity(PlantDetailActivity.newIntent(this , plantID) , options.toBundle())
    }

    private lateinit var mUserID : String
    private lateinit var mPresenter : CataloguePresenter
    private lateinit var mAdapter: PlantCatalougeAdapter

    companion object{

        const val USER_ID = "USER_ID"

        fun newIntent(context : Context , userID : String) : Intent
        {
            val intent = Intent(context , CatalogueActivity::class.java)
            intent.putExtra(USER_ID , userID)
            return intent
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        val menuID  = item.itemId
        supportActionBar?.title = item.title
        catalogueRootView.closeDrawer(GravityCompat.START)

        if(menuID == R.id.nav_LogOut )
        {
            userModel.logout(mUserID)
            startActivity(Intent(applicationContext , LoginActivity::class.java))
        }
        else if(menuID == R.id.nav_Favourite)
        {
            startActivity(Intent(applicationContext , FavouriteActivity::class.java) ,ActivityOptionsCompat.makeSceneTransitionAnimation(this).toBundle())
        }
        return true
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setupTransition()
        setContentView(R.layout.activity_catalogue)
        setSupportActionBar(tbCatalogue)

        //initialization of presenter and adapters
        mPresenter = CataloguePresenter()
        mPresenter.initPresenter(this)
        mAdapter = PlantCatalougeAdapter(mPresenter)
//        mUserID = intent.getStringExtra(USER_ID)

        rvPlants.layoutManager = LinearLayoutManager(applicationContext , LinearLayoutManager.VERTICAL , false)
        rvPlants.adapter = mAdapter

        btnOpenDrawer.setOnClickListener {
            catalogueRootView.openDrawer(Gravity.LEFT)
        }

        navMenu.setNavigationItemSelectedListener(this)
        mPresenter.onCreate()
        startPlantListAnimation()
    }

    private fun setupTransition() {
        with(window)
        {
            requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
            val fadeTransition = Fade()
            fadeTransition.interpolator = AccelerateDecelerateInterpolator()
            fadeTransition.duration = 1000
            enterTransition = fadeTransition
            exitTransition = fadeTransition
        }
    }

    private fun startPlantListAnimation()
    {
        val handler = Handler()
        handler.postDelayed( { playPlantListAnimation() } , 2500)
    }

    private fun playPlantListAnimation()
    {
        val animator = ObjectAnimator.ofFloat(rvPlants , View.TRANSLATION_X , rvPlants.width.toFloat() , 0f)
        animator.interpolator = OvershootInterpolator()
        animator.duration = 1500
        animator.addListener(object : AnimatorListenerAdapter()
        {
            override fun onAnimationStart(animation: Animator?) {
                rvPlants.visibility = View.VISIBLE
            }
        })
        animator.start()
    }


    override fun onStart() {
        super.onStart()
        mPresenter.onStart()

    }

    override fun onStop()
    {
        super.onStop()
        mPresenter.onStop()

    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.onDestroy()
    }

    override fun onPause()
    {
        super.onPause()
        mPresenter.onPause()
    }

    override fun onResume()
    {
        super.onResume()
        mPresenter.onResume()
    }

}
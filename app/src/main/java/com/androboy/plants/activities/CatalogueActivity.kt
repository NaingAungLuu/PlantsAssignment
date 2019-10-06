package com.androboy.plants.activities

import android.content.Context
import android.content.Intent
import android.opengl.Visibility
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.view.Window
import android.view.WindowManager
import android.widget.ProgressBar
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.androboy.plants.R
import com.androboy.plants.adapters.PlantCatalougeAdapter
import com.androboy.plants.data.vos.PlantVO
import com.androboy.plants.delegate.PlantDelegate
import com.androboy.plants.mvp.presenters.BasePresenter
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
        startActivity(PlantDetailActivity.newIntent(this , plantID))
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
            startActivity(Intent(applicationContext , FavouriteActivity::class.java))
        }
        return true
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
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
package com.androboy.plants.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.androboy.plants.R
import com.androboy.plants.activities.PlantDetailActivity
import com.androboy.plants.adapters.FavPlantsAdapter
import com.androboy.plants.data.vos.PlantVO
import com.androboy.plants.mvp.presenters.FavouritePresenter
import com.androboy.plants.mvp.presenters.LoginPresenter
import com.androboy.plants.mvp.views.FavouriteView
import kotlinx.android.synthetic.main.fragment_favourite.*

class FavouriteFragment : Fragment() , FavouriteView{


    override fun navigateToDetail(plantID: String) {
        startActivity(PlantDetailActivity.newIntent(context , plantID))
    }


    override fun displayErrorMessage(msg: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showFavouritePlants(plants: List<PlantVO>) {

    }

    private lateinit var mPresenter: FavouritePresenter
    private lateinit var mAdapter : FavPlantsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mPresenter = FavouritePresenter()
        mPresenter.initPresenter(this)
        mAdapter = FavPlantsAdapter(mPresenter)

        rvFavouritesRecent.adapter = mAdapter
        rvFavouritesRecent.layoutManager = GridLayoutManager(context , 2)


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_favourite , container , false)

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

    }
}
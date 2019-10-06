package com.androboy.plants.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.androboy.plants.R
import com.androboy.plants.adapters.PlantCatalougeAdapter
import com.androboy.plants.mvp.presenters.LoginPresenter
import com.androboy.plants.mvp.views.LoginView
import com.androboy.plants.persistence.PlantDatabase
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_catalogue.*
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity() , LoginView{

    override fun navigateToCatalogue(userID: String) {
        val intent = CatalogueActivity.newIntent(applicationContext , userID)
        startActivity(intent)
    }

    override fun getContext(): Context = applicationContext

    private lateinit var mPresenter : LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_login)

        mPresenter = LoginPresenter()
        mPresenter.initPresenter(this)



        btnLogin.setOnClickListener {
            mPresenter.onTapLoginButton(etEmail.text.toString() , etPassword.text.toString())
        }


    }

    override fun onStart() {
        super.onStart()

    }

    override fun onStop()
    {
        super.onStop()

    }
}

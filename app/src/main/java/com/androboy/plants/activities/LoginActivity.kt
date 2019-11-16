package com.androboy.plants.activities

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.view.animation.AnimationSet
import android.view.animation.BounceInterpolator
import android.view.animation.LinearInterpolator
import android.view.animation.OvershootInterpolator
import androidx.core.app.ActivityOptionsCompat
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
import kotlinx.android.synthetic.main.plant_view_item.*

class LoginActivity : BaseActivity() , LoginView{

    override fun navigateToCatalogue(userID: String) {
        val intent = CatalogueActivity.newIntent(applicationContext , userID)
        startActivity(intent , ActivityOptionsCompat.makeSceneTransitionAnimation(this).toBundle())
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
        startScreenAnimation()


    }

    private fun startScreenAnimation() {
        //Animation 1 (Login Sign in and Plant Image)
        val titleAnimator = ObjectAnimator.ofFloat(tvTitle , View.ALPHA , 0f , 1f)
        val sloganAnimator = ObjectAnimator.ofFloat(tvSubTitle , View.ALPHA , 0f , 1f)
        val ImageAnimator = ObjectAnimator.ofFloat(ivLoginBackground , View.ALPHA , 0f , 1f)

        AnimatorSet().apply {
            play(titleAnimator).with(sloganAnimator).with(ImageAnimator)
            duration = 1000
            interpolator = LinearInterpolator()
            start()
            addListener(object : AnimatorListenerAdapter(){
                override fun onAnimationEnd(animation: Animator?) {
                    playAnimation2()
                }
            })
        }

    }

    private fun playAnimation2()
    {
        //Animation 2 (UserName and password field)
        val tvUserNameAnimator = ObjectAnimator.ofFloat(tvEmail , View.TRANSLATION_X , 500f , 0f)
        val etUserNameAnimator = ObjectAnimator.ofFloat(etEmail , View.TRANSLATION_X , 500f , 20f)
        val tvPasswordAnimator = ObjectAnimator.ofFloat(tvPassword , View.TRANSLATION_X , 500f , 0f)
        val etPasswordAnimator = ObjectAnimator.ofFloat(etPassword , View.TRANSLATION_X , 500f , 20f)

        AnimatorSet().apply {
            playTogether(tvUserNameAnimator , etUserNameAnimator , tvPasswordAnimator , etPasswordAnimator)
            duration = 1500
            interpolator = BounceInterpolator()
            tvEmail.visibility = View.VISIBLE
            etEmail.visibility = View.VISIBLE
            etPassword.visibility = View.VISIBLE
            tvPassword.visibility = View.VISIBLE
            start()
            addListener(object : AnimatorListenerAdapter(){
                override fun onAnimationEnd(animation: Animator?) {
                    playAnimation3()
                }
            })
        }
    }

    private fun playAnimation3()
    {
        //Animation3
        val  btnLoginAnimator = ObjectAnimator.ofFloat(btnLogin , View.TRANSLATION_X , -500f , -60f).apply {
            interpolator = OvershootInterpolator()
            duration = 1500
        }
        btnLogin.visibility = View.VISIBLE
        btnLoginAnimator.start()
    }


    override fun onStart() {
        super.onStart()

    }

    override fun onStop()
    {
        super.onStop()

    }
}

package com.neosoft.republictv.presentation.view.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.neosoft.republictv.R
import com.neosoft.republictv.presentation.BaseActivity


class SplashActivity : BaseActivity() {

    val SPLASH_DISPLAY_LENGTH: Long = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed(Runnable {
            val mainIntent = Intent(this, ListOfUsersActivity::class.java)
            startActivity(mainIntent)
            finish()

        }, SPLASH_DISPLAY_LENGTH)
    }


    override fun injectComponent() {

    }


}

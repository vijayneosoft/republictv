package com.neosoft.republictv.presentation

import android.app.Application
import android.content.Context
import com.facebook.stetho.Stetho
import com.neosoft.republictv.presentation.di.component.ApplicationComponent
import com.neosoft.republictv.presentation.di.component.DaggerApplicationComponent
import com.neosoft.republictv.presentation.di.module.ApplicationModule
import com.neosoft.republictv.presentation.di.module.ContextModule


/**
 * Created by Vijay on 30/8/19.
 */

class UserApplication : Application() {

    var applicationComponent: ApplicationComponent? = null
    lateinit var context: Context

    override fun onCreate() {
        super.onCreate()
        context = this
        Stetho.initializeWithDefaults(this);

        applicationComponent = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .contextModule(ContextModule(this))
            .build()

    }

    fun getComponent(): ApplicationComponent? {
        return applicationComponent
    }


}
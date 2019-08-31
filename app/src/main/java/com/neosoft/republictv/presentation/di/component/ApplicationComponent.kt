package com.neosoft.republictv.presentation.di.component

import android.content.Context
import com.neosoft.republictv.data.net.RestApi
import com.neosoft.republictv.presentation.di.module.ApplicationModule
import com.neosoft.republictv.presentation.di.module.ContextModule
import com.neosoft.republictv.presentation.di.module.DataModule
import com.neosoft.republictv.presentation.navigation.Navigator
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Vijay on 30/8/19.
 */
@Singleton
@Component(modules = arrayOf(ApplicationModule::class, DataModule::class, ContextModule::class))
interface ApplicationComponent {

    fun navigator(): Navigator

    fun restApi(): RestApi

    fun getContext(): Context


}
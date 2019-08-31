package com.neosoft.republictv.presentation.di.module

import android.app.Application
import com.neosoft.republictv.presentation.navigation.Navigator
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Vijay on 30/8/19.
 */

@Module
class ApplicationModule(application: Application) {

    var application: Application? = application

    @Provides
    @Singleton
    fun provideNavigator(): Navigator {
        return Navigator()
    }


}
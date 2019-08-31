package com.neosoft.republictv.presentation.di.module

import android.app.Activity
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import com.neosoft.republictv.presentation.di.PerActivity
import com.neosoft.republictv.presentation.viewModelFactory.ViewModelFactory
import com.neosoft.republictv.presentation.viewmodel.DetailsOfUsersVM
import com.neosoft.republictv.presentation.viewmodel.ListOfUsersVM
import dagger.Module
import dagger.Provides

/**
 * Created by Vijay on 30/8/19.
 */

@Module
class ActivityModule(val mActivity: Activity) {

    @Provides
    @PerActivity
    fun provideActivityModule(): Activity {
        return mActivity
    }

    @Provides
    @PerActivity
    fun provideListOfUsersVM(viewModelFactory: ViewModelFactory): ListOfUsersVM =
        ViewModelProviders.of(mActivity as FragmentActivity, viewModelFactory).get(ListOfUsersVM::class.java)

    @Provides
    @PerActivity
    fun provideDetailsOfUsersVM(viewModelFactory: ViewModelFactory): DetailsOfUsersVM =
        ViewModelProviders.of(mActivity as FragmentActivity, viewModelFactory).get(DetailsOfUsersVM::class.java)

}
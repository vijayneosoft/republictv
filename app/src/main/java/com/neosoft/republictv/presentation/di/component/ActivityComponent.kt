package com.neosoft.republictv.presentation.di.component

import com.neosoft.republictv.presentation.di.PerActivity
import com.neosoft.republictv.presentation.di.module.ActivityModule
import com.neosoft.republictv.presentation.view.activity.DetailsOfUsersActivity
import com.neosoft.republictv.presentation.view.activity.ListOfUsersActivity
import dagger.Component

/**
 * Created by Vijay on 30/8/19.
 */

@PerActivity
@Component(dependencies = arrayOf(ApplicationComponent::class), modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

    fun inject(listOfUsersActivity: ListOfUsersActivity)

    fun inject(detailsOfUsersActivity: DetailsOfUsersActivity)


}

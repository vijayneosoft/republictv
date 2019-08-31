package com.neosoft.republictv.presentation.navigation

import android.app.Activity
import android.content.Context
import com.neosoft.republictv.domain.entity.ResultEntity
import com.neosoft.republictv.presentation.view.activity.DetailsOfUsersActivity
import javax.inject.Singleton

/**
 * Created by Vijay on 30/8/19.
 */

@Singleton
class Navigator {


    fun navigateToDetailsOfUserActivity(activity: Context, resultEntity: ResultEntity) {
        activity.startActivity(DetailsOfUsersActivity.getCallingIntent(activity,resultEntity))
    }


}
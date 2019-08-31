package com.neosoft.republictv.presentation.view.activity

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.bumptech.glide.Glide
import com.neosoft.republictv.R
import com.neosoft.republictv.domain.entity.ResultEntity
import com.neosoft.republictv.presentation.BaseActivity
import com.neosoft.republictv.presentation.UserApplication
import com.neosoft.republictv.presentation.di.component.DaggerActivityComponent
import com.neosoft.republictv.presentation.di.module.ActivityModule
import com.neosoft.republictv.presentation.viewmodel.ListOfUsersVM
import kotlinx.android.synthetic.main.activity_details_of_users.*
import javax.inject.Inject


@SuppressLint("Registered")
class DetailsOfUsersActivity : BaseActivity() {

    @Inject
    lateinit var mListOfUsersVM: ListOfUsersVM
    lateinit var userDetails: ResultEntity

    companion object {

        var KEY_USER_DATA = "keyUserData"

        fun getCallingIntent(context: Context, resultEntity: ResultEntity): Intent {
            val intent = Intent(context, DetailsOfUsersActivity::class.java)
            intent.putExtra(KEY_USER_DATA, resultEntity)
            return intent
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_of_users)

        val bundle = intent.extras
        if (bundle != null) {
            val userDetails = bundle.getSerializable(KEY_USER_DATA) as ResultEntity

            txt_name.setText(userDetails.name?.first + " " + userDetails.name?.last)

            txt_street.setText(userDetails.location?.street)
            txt_city.setText(userDetails.location?.city)
            txt_state.setText(userDetails.location?.state)
            txt_email.setText(userDetails.email)

            Glide.with(this).load(userDetails.picture?.large)
                .into(img_user)


        }

    }


    override fun injectComponent() {
        DaggerActivityComponent.builder()
            .applicationComponent((application as UserApplication).getComponent())
            .activityModule(ActivityModule(this))
            .build().inject(this)
    }

}

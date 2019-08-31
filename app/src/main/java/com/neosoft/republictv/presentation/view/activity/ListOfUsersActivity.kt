package com.neosoft.republictv.presentation.view.activity

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.neosoft.republictv.R
import com.neosoft.republictv.data.enums.Status
import com.neosoft.republictv.domain.entity.ResultEntity
import com.neosoft.republictv.presentation.BaseActivity
import com.neosoft.republictv.presentation.UserApplication
import com.neosoft.republictv.presentation.di.component.DaggerActivityComponent
import com.neosoft.republictv.presentation.di.module.ActivityModule
import com.neosoft.republictv.presentation.request.ListOfUserRequest
import com.neosoft.republictv.presentation.view.adapter.ListUserAdapter
import com.neosoft.republictv.presentation.viewmodel.ListOfUsersVM
import com.nmesgroup.dipulse.tetra.view.utility.RecyclerItemClickListener
import kotlinx.android.synthetic.main.activity_list_of_users.*
import javax.inject.Inject


@SuppressLint("Registered")
class ListOfUsersActivity : BaseActivity() {

    @Inject
    lateinit var mListOfUsersVM: ListOfUsersVM

    lateinit var mListUserData: List<ResultEntity>

    companion object {
        fun getCallingIntent(context: Context): Intent {
            val intent = Intent(context, ListOfUsersActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_of_users)
        observeUserListResponse()

        val mListUserRequest = ListOfUserRequest()
        mListUserRequest.result = 10

        if (isThereInternetConnection()) {
            mListOfUsersVM.listUsersRequest(mListUserRequest)
        } else {

        }

    }


    override fun injectComponent() {
        DaggerActivityComponent.builder()
            .applicationComponent((application as UserApplication).getComponent())
            .activityModule(ActivityModule(this))
            .build().inject(this)
    }


    private fun observeUserListResponse() {
        mListOfUsersVM.listUsersResponse().observe(this, Observer { response ->
            when (response?.status) {
                Status.SUCCESS -> {
                    //success
                    showToastMessage(getString(R.string.info_success))
                    mListUserData = response.listOfUserEntity?.results!!

                    if (!mListUserData.isNullOrEmpty()) {
                        showAdapter()
                    }
                }
                Status.ERROR -> {
                    //error
                    hideLoading()
                    showToastMessage(getString(R.string.info_error) + response.error!!.message)

                }
            }
        })
    }

    @SuppressLint("WrongConstant")
    private fun showAdapter() {
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_list_users.layoutManager = linearLayoutManager

        val mListUserAdapter = ListUserAdapter(this, mListUserData)
        rv_list_users.adapter = mListUserAdapter

        rv_list_users.addOnItemTouchListener(
            RecyclerItemClickListener(this, rv_list_users,
                object : RecyclerItemClickListener.OnItemClickListener {
                    override fun onItemClick(view: View, position: Int) {
                        mNavigator?.navigateToDetailsOfUserActivity(
                            this@ListOfUsersActivity,
                            mListUserData.get(position)
                        )
                    }
                })
        )

    }


}

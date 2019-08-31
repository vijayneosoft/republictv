package com.neosoft.republictv.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.neosoft.republictv.domain.entity.ListOfUserEntity
import com.neosoft.republictv.domain.usecases.ListOfUsersUC
import com.neosoft.republictv.presentation.model.ListOfUserModel
import com.neosoft.republictv.presentation.request.ListOfUserRequest
import io.reactivex.observers.DisposableObserver


/**
 * Created by Vijay on 30/8/19.
 *
 */


class ListOfUsersVM(var mListOfUsersUC: ListOfUsersUC?) : ViewModel() {

    var mMutableLiveDataUsersList = MutableLiveData<ListOfUserModel>()

    fun listUsersResponse(): LiveData<ListOfUserModel> {
        return mMutableLiveDataUsersList
    }

    fun listUsersRequest(mListOfUserRequest: ListOfUserRequest) {
        mListOfUsersUC?.execute(object : DisposableObserver<ListOfUserEntity>() {
            override fun onComplete() {
                Log.d("TAG--> ", "onComplete")
            }

            override fun onNext(response: ListOfUserEntity) {
                mMutableLiveDataUsersList.value =
                    ListOfUserModel.success(response)
                Log.d("TAG--> ", "onNext")
            }

            override fun onError(e: Throwable) {
                Log.d("TAG--> ", "onError" + e.message)
            }

        }, mListOfUserRequest)

    }


}
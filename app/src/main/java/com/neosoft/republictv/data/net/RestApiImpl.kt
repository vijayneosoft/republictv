package com.neosoft.republictv.data.net

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import com.neosoft.republictv.data.net.interfaces.CustomerService
import com.neosoft.republictv.data.response.ListOfUserResponse
import com.neosoft.rideshare.data.exception.NetworkUnavailableException
import io.reactivex.Observable
import retrofit2.Response
import javax.inject.Inject


/**
 * Created by Vijay on 30/8/19.
 */

class RestApiImpl @Inject constructor(mCustomerService: CustomerService, mContext: Context) : RestApi {

    var mContext: Context = mContext
    var mCustomerService: CustomerService = mCustomerService

    override fun getListOfUsers(result: Int): Observable<Response<ListOfUserResponse>> {
        return Observable.create<Response<ListOfUserResponse>> { emitter ->
            if (!isThereInternetConnection()) {
                emitter.onError(NetworkUnavailableException())
                return@create
            }

            //Synchronous request
            val sessionEntity: Response<ListOfUserResponse> =
                mCustomerService.getListOfUsers(result).execute()
            if (sessionEntity.isSuccessful) {
                if (sessionEntity.body() != null) {
                    //emitting data after transforming.
                    emitter.onNext(sessionEntity)
                    //Calling onComplete.
                    emitter.onComplete()

                } else {
                    //unknown error
                    emitter.onError(UnknownError())
                }
            }
        }
    }

    @SuppressLint("MissingPermission")
    fun isThereInternetConnection(): Boolean {
        val cm = this.mContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?

        return cm!!.activeNetworkInfo != null
    }
}

package com.neosoft.republictv.data.net

import com.neosoft.republictv.data.response.ListOfUserResponse
import io.reactivex.Observable
import retrofit2.Response

/**
 * Created by Vijay on 30/8/19.
 */

interface RestApi {

    fun getListOfUsers(result: Int): Observable<Response<ListOfUserResponse>>

}
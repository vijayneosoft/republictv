package com.neosoft.republictv.data.net.interfaces


import com.neosoft.republictv.data.response.ListOfUserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Vijay on 30/8/19.
 */

interface CustomerService {

    @GET("api")
    fun getListOfUsers(
        @Query("results") result: Int
    ): Call<ListOfUserResponse>




}
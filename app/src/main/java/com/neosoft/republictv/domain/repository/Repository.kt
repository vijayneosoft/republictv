package com.neosoft.republictv.domain.repository

import com.neosoft.republictv.domain.entity.ListOfUserEntity
import io.reactivex.Observable

/**
 * Created by Vijay on 30/8/19.
 */

interface Repository {

    fun getListOfUsers(result: Int): Observable<ListOfUserEntity>


}
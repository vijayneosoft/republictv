package com.neosoft.republictv.data.dataRepository

import com.neosoft.republictv.data.mapper.DataMapper
import com.neosoft.republictv.data.net.RestApi
import com.neosoft.republictv.domain.entity.ListOfUserEntity
import com.neosoft.republictv.domain.repository.Repository
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Vijay on 30/8/19.
 */

@Singleton
class DataRepository @Inject constructor(mRestApi: RestApi, mDataMapper: DataMapper) :
    Repository {

    var mRestApi: RestApi = mRestApi
    var mDataMapper: DataMapper = mDataMapper

    override fun getListOfUsers(result: Int): Observable<ListOfUserEntity> {
        return mRestApi.getListOfUsers(result).map(mDataMapper::mapListOfUsersMapper)
    }


}
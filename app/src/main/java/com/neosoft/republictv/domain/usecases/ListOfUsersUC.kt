package com.neosoft.republictv.domain.usecases

import com.neosoft.republictv.data.dataRepository.DataRepository
import com.neosoft.republictv.domain.entity.ListOfUserEntity
import com.neosoft.republictv.presentation.request.ListOfUserRequest
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by Vijay on 30/8/19.
 */

class ListOfUsersUC @Inject constructor(val repository: DataRepository) :
    BaseUC<ListOfUserEntity, ListOfUserRequest>() {

    override fun build(param: ListOfUserRequest): Observable<ListOfUserEntity> {
        return repository.getListOfUsers(param.result)

    }
}
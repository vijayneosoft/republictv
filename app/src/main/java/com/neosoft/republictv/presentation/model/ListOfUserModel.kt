package com.neosoft.republictv.presentation.model

import com.neosoft.republictv.data.enums.Status
import com.neosoft.republictv.domain.entity.ListOfUserEntity


/**
 * Created by Vijay on 30/8/19.
 */

class ListOfUserModel(status: Status, listOfUserEntity: ListOfUserEntity?, error: Throwable?) {

    var status: Status? = status
    var listOfUserEntity: ListOfUserEntity? = listOfUserEntity
    var error: Throwable? = error


    companion object {

        fun success(response: ListOfUserEntity): ListOfUserModel {
            return ListOfUserModel(Status.SUCCESS, response, null)
        }

        fun error(error: Throwable): ListOfUserModel {
            return ListOfUserModel(Status.ERROR, null, error)
        }
    }
}
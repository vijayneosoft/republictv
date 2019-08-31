package com.neosoft.republictv.data.mapper

import com.neosoft.republictv.data.response.ListOfUserResponse
import com.neosoft.republictv.domain.entity.*
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Vijay on 30/8/19.
 */

@Singleton
class DataMapper @Inject constructor() {

    fun mapListOfUsersMapper(response: Response<ListOfUserResponse>): ListOfUserEntity {

        val listOfUserResponse: ListOfUserResponse? = response.body()
        val listResultResponse = listOfUserResponse!!.results
        val listOfUserEntity = ListOfUserEntity()

        val listUserResultE = ArrayList<ResultEntity>()

        for (i in 0..listResultResponse!!.size - 1) {
            val resultsE = ResultEntity()
            resultsE.email = listResultResponse.get(i).email

            val locationE = LocationEntity()
            locationE.city = listResultResponse.get(i).location!!.city
            locationE.state = listResultResponse.get(i).location!!.state
            locationE.street = listResultResponse.get(i).location!!.street
            locationE.postcode = listResultResponse.get(i).location!!.postcode

            val pictureE = PictureEntity()
            pictureE.large = listResultResponse.get(i).picture!!.large
            pictureE.medium = listResultResponse.get(i).picture!!.medium
            pictureE.thumbnail = listResultResponse.get(i).picture!!.thumbnail

            val nameE = NameEntity()
            nameE.first = listResultResponse.get(i).name!!.first
            nameE.last = listResultResponse.get(i).name!!.last
            nameE.title = listResultResponse.get(i).name!!.title

            resultsE.location = locationE
            resultsE.picture = pictureE
            resultsE.name = nameE

            listUserResultE.add(resultsE)
        }

        listOfUserEntity.results = listUserResultE

        return listOfUserEntity
    }

}
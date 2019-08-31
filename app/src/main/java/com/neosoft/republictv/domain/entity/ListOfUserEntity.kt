package com.neosoft.republictv.domain.entity

import java.io.Serializable

/**
 * Created by Vijay on 30/8/19.
 */

class ListOfUserEntity : Serializable {

    var results: List<ResultEntity>? = null

}

class ResultEntity : Serializable {

    var gender: String? = null
    var name: NameEntity? = null
    var location: LocationEntity? = null
    var email: String? = null
    var picture: PictureEntity? = null

}

class NameEntity : Serializable{
    var title: String? = null
    var first: String? = null
    var last: String? = null
}

class LocationEntity : Serializable{
    var street: String = ""
    var city: String = ""
    var state: String = ""
    var postcode: String = ""
}

class PictureEntity : Serializable{
    var large: String = ""
    var medium: String = ""
    var thumbnail: String = ""
}
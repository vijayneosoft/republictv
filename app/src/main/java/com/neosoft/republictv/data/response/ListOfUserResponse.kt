package com.neosoft.republictv.data.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Created by Vijay on 30/8/19.
 */

class ListOfUserResponse {

    @SerializedName("results")
    @Expose
    var results: List<ResultResponse>? = null

}

class ResultResponse {
    @SerializedName("gender")
    @Expose
    var gender: String? = null
    @SerializedName("name")
    @Expose
    var name: NameResponse? = null
    @SerializedName("location")
    @Expose
    var location: LocationResponse? = null
    @SerializedName("email")
    @Expose
    var email: String? = null
    @SerializedName("picture")
    @Expose
    var picture: PictureResponse? = null

}

class NameResponse {
    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("first")
    @Expose
    var first: String? = null
    @SerializedName("last")
    @Expose
    var last: String? = null

}

class LocationResponse {
    @SerializedName("street")
    var street: String = ""
    @SerializedName("city")
    var city: String = ""
    @SerializedName("state")
    var state: String = ""
    @SerializedName("postcode")
    var postcode: String = ""

}

class PictureResponse {
    @SerializedName("large")
    var large: String = ""
    @SerializedName("medium")
    var medium: String = ""
    @SerializedName("thumbnail")
    var thumbnail: String = ""
}
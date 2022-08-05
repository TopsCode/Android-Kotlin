package com.example.retrofitcrudex

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Model
{
    @Expose
    @SerializedName("id")
    var id = 0

    @Expose
    @SerializedName("name")
    var name: String? = null

    @Expose
    @SerializedName("email")
    var email: String? = null
}
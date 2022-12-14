package com.example.retrofitcrudex

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface Apiinterface
{

    @FormUrlEncoded
    @POST("insert.php")
    fun savedata
                (
                     @Field("name") name: String?,
                    @Field("email") email: String?,
                ): Call<Model?>?

    @get:GET("view.php")
    val viewdata: Call<List<Model?>?>?



}
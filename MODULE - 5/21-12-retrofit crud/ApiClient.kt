package com.example.retrofitcrudex

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient
{

    private val BASE_URL = "https://prakrutivyas.000webhostapp.com/regserver/CRUD/"
    private var retrofit: Retrofit? = null

    fun getApiClient(): Retrofit?
    {

            retrofit=Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                .build()

        return retrofit

    }


}
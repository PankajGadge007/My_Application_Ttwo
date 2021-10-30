package com.tembhode.myapplicationttwo.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Pankaj Gadge on 10/30/2021.
 */

class RetrofitBase {
    companion object {
        private val BASE_URL = "http://simple-node-app-nkd.herokuapp.com"

        val retrofit =
            Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
        var apiInterface: ApiInterface = retrofit.create(ApiInterface::class.java)

    }


}
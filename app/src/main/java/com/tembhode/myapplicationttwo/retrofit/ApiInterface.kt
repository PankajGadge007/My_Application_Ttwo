package com.tembhode.myapplicationttwo.retrofit

import com.tembhode.myapplicationttwo.data.Plant
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by Pankaj Gadge on 10/30/2021.
 */
interface ApiInterface {
    @GET(".")
    fun getAllData(): Call<List<Plant>>
}
package com.iulian.iancu.spacetracker

import com.iulian.iancu.spacetracker.data.Result
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface SpaceTrackerService {

    @GET("latest")
    suspend fun getWeatherForLocation(): Response<Result>

    companion object {
        var retrofitService: SpaceTrackerService? = null
        fun getInstance(): SpaceTrackerService {
            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://api.spacexdata.com/v4/launches/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(SpaceTrackerService::class.java)
            }
            return retrofitService!!
        }

    }
}
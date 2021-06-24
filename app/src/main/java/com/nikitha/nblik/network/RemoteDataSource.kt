package com.nikitha.nblik.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RemoteDataSource {
    companion object{
        private const val BASE_URL ="https://auth-api7.herokuapp.com/api/"
    }

    fun<API> buildApi(
        api:Class<API>
    ):API
    {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(api)
    }
}
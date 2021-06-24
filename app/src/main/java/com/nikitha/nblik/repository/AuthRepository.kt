package com.nikitha.nblik.repository

import com.nikitha.nblik.network.AuthApi

class AuthRepository(
    private val api : AuthApi
): BaseRepository() {

   suspend fun login(email:String, password:String) = safeApiCall {
        api.login(email, password)
    }

}
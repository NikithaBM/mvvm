package com.nikitha.nblik.responses

data class LoginResponse(
    val city: String,
    val country: String,
    val email: String,
    val id: Int,
    val name: String,
    val phone: String,
    val token: String,
    val user_type: String
)
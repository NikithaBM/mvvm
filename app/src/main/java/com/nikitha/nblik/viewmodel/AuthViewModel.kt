package com.nikitha.nblik.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nikitha.nblik.network.Resource
import com.nikitha.nblik.repository.AuthRepository
import com.nikitha.nblik.responses.LoginResponse
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class AuthViewModel(private val authRepo:AuthRepository): ViewModel() {

    private val _loginResponse: MutableLiveData<Resource<LoginResponse>> = MutableLiveData()
    val tokenResponse: LiveData<Resource<LoginResponse>>
        get() = _loginResponse

    fun login(email: String, password: String) = viewModelScope.launch {
        _loginResponse.value = Resource.Loading
        _loginResponse.value = authRepo.login(email, password)
    }
}
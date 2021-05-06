package com.vuonghung.androidbase.data.remote

import com.vuonghung.androidbase.data.model.BaseResponse
import com.vuonghung.androidbase.data.model.User
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getUsers(): Response<BaseResponse<User>>
}
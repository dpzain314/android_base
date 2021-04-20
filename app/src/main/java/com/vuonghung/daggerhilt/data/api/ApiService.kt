package com.vuonghung.daggerhilt.data.api

import com.vuonghung.daggerhilt.data.model.User
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getUsers(): List<User>
}
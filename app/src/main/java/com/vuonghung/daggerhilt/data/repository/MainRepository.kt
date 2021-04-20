package com.vuonghung.daggerhilt.data.repository

import com.vuonghung.daggerhilt.data.api.ApiHelper
import com.vuonghung.daggerhilt.data.model.User
import io.reactivex.Single

class MainRepository(private val apiHelper: ApiHelper) {
    suspend fun getUsers(): List<User> = apiHelper.getUsers()
}
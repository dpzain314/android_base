package com.vuonghung.daggerhilt.data.repository

import com.vuonghung.daggerhilt.data.api.ApiHelper
import com.vuonghung.daggerhilt.data.model.BaseResponse
import com.vuonghung.daggerhilt.data.model.User
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiHelper: ApiHelper) {
    suspend fun getUsers(): BaseResponse<User> = apiHelper.getUsers()
}
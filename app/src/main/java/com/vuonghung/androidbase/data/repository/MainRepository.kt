package com.vuonghung.androidbase.data.repository

import com.vuonghung.androidbase.data.api.ApiHelper
import com.vuonghung.androidbase.data.model.BaseResponse
import com.vuonghung.androidbase.data.model.User
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiHelper: ApiHelper) {
    suspend fun getUsers(): BaseResponse<User> = apiHelper.getUsers()
}
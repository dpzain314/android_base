package com.vuonghung.androidbase.data.repository

import com.vuonghung.androidbase.data.remote.ApiHelper
import com.vuonghung.androidbase.data.model.BaseResponse
import com.vuonghung.androidbase.data.model.User
import com.vuonghung.androidbase.utils.performOperation
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiHelper: ApiHelper) {
    fun getUsers() = performOperation(networkCall = { apiHelper.getUsers() })
}
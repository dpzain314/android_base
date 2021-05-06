package com.vuonghung.androidbase.data.remote

import javax.inject.Inject

class ApiHelper @Inject constructor(private val apiService: ApiService): BaseDataSource() {
    suspend fun getUsers() = getResult { apiService.getUsers()}
}
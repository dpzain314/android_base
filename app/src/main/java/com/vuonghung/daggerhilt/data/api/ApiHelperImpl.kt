package com.vuonghung.daggerhilt.data.api

import javax.inject.Inject

//class ApiHelper(private val apiService: ApiService) {
class ApiHelperImpl @Inject constructor(private val apiService: ApiService): ApiHelper {
    override suspend fun getUsers() = apiService.getUsers()
}
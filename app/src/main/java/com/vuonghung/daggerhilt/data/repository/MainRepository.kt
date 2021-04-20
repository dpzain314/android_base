package com.vuonghung.daggerhilt.data.repository

import com.vuonghung.daggerhilt.data.api.ApiHelperImpl
import com.vuonghung.daggerhilt.data.model.User
import javax.inject.Inject

//class MainRepository(private val apiHelper: ApiHelper) {
class MainRepository @Inject constructor( private val apiHelper: ApiHelperImpl) {
    suspend fun getUsers(): List<User> = apiHelper.getUsers()
}
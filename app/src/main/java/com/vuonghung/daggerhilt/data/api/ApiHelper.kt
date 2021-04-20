package com.vuonghung.daggerhilt.data.api

import com.vuonghung.daggerhilt.data.model.User

interface ApiHelper {
    suspend fun getUsers():List<User>
}
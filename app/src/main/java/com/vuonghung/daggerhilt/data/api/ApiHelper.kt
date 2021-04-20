package com.vuonghung.daggerhilt.data.api

import com.vuonghung.daggerhilt.data.model.BaseResponse
import com.vuonghung.daggerhilt.data.model.User

interface ApiHelper {
    suspend fun getUsers(): BaseResponse<User>
}
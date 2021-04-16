package com.vuonghung.daggerhilt.data.api

import com.vuonghung.daggerhilt.data.model.User
import io.reactivex.Single

interface ApiService {
    fun getUsers(): Single<List<User>>
}
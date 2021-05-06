package com.vuonghung.androidbase.data.remote

import com.vuonghung.androidbase.utils.ConnectivityNetworkManager
import com.vuonghung.androidbase.utils.Resource
import retrofit2.Response
import timber.log.Timber
import javax.inject.Inject

abstract class BaseDataSource{
    @Inject lateinit var connectivity : ConnectivityNetworkManager

    protected suspend fun <T> getResult(call: suspend () -> Response<T>): Resource<T> {
        if(connectivity.isNetworkConnected()) {
            try {
                val response = call()
                if (response.isSuccessful) {
                    val body = response.body()
                    if (body != null) return Resource.success(body)
                }
                return error(" ${response.code()} ${response.message()}")
            } catch (e: Exception) {
                return error(e.message ?: e.toString())
            }
        }else{
            return error("Network connection failed!")
        }
    }

    private fun <T> error(message: String): Resource<T> {
        Timber.d(message)
        return Resource.error("Error: $message")
    }

}
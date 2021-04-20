package com.vuonghung.daggerhilt.data.model

import com.google.gson.annotations.SerializedName

open class BaseResponse<T>(
    @SerializedName("status")
    var status: String? = "",
    @SerializedName("message")
    var message: String? = "",
    @SerializedName("data")
    var data: List<T>? = null,
)
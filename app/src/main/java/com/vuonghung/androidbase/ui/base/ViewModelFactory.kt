package com.vuonghung.androidbase.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vuonghung.androidbase.data.api.ApiHelper
import com.vuonghung.androidbase.data.repository.MainRepository
import com.vuonghung.androidbase.ui.main.viewmodel.MainViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory(private val apiHelper: ApiHelper): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainViewModel::class.java)){
            return  MainViewModel(MainRepository(apiHelper)) as T
        }
        throw  IllegalArgumentException("unknown class name")
    }
}
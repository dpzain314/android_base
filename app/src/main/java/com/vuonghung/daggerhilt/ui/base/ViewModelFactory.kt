package com.vuonghung.daggerhilt.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vuonghung.daggerhilt.data.api.ApiHelperImpl
import com.vuonghung.daggerhilt.data.repository.MainRepository
import com.vuonghung.daggerhilt.ui.main.viewmodel.MainViewModel
import java.lang.IllegalArgumentException
import javax.inject.Inject

class ViewModelFactory @Inject constructor(private val apiHelper: ApiHelperImpl): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainViewModel::class.java)){
            return  MainViewModel(MainRepository(apiHelper)) as T
        }
        throw  IllegalArgumentException("unknown class name")
    }
}
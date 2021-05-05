package com.vuonghung.androidbase.ui.main.viewmodel

import androidx.lifecycle.*
import com.vuonghung.androidbase.data.model.BaseResponse
import com.vuonghung.androidbase.data.model.User
import com.vuonghung.androidbase.data.repository.MainRepository
import com.vuonghung.androidbase.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val mainRepository: MainRepository) : ViewModel(){
    private val users = MutableLiveData<Resource<BaseResponse<User>>>()
    init {
        viewModelScope.launch {
            try{
                val data = async { mainRepository.getUsers()}
                users.postValue(Resource.success(data.await()))
            }catch (ex: Exception){
                users.postValue(Resource.error("Something Went Wrong", null))
            }
        }
    }

    //using liveData + emit : might need to calculate values asynchronously
    fun getUsers(): LiveData<Resource<BaseResponse<User>>>{
        return liveData(Dispatchers.IO) {
            emit(Resource.success(mainRepository.getUsers()))
        }
    }

    //using viewModelScope
    fun getUsers2() = users
}
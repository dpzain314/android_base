package com.vuonghung.daggerhilt.ui.main.viewmodel

import androidx.lifecycle.*
import com.vuonghung.daggerhilt.data.model.BaseResponse
import com.vuonghung.daggerhilt.data.model.User
import com.vuonghung.daggerhilt.data.repository.MainRepository
import com.vuonghung.daggerhilt.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel (
    private val mainRepository: MainRepository
) : ViewModel() {

    private val users = MutableLiveData<Resource<BaseResponse<User>>>()

    init {
//        viewModelScope.launch {
//            try {
//                val data = async { mainRepository.getUsers() }
//                users.postValue(Resource.success(data.await()))
//            } catch (ex: Exception) {
//                users.postValue(Resource.error("Error", null))
//            }
//        }
    }

    //using liveData + emit : might need to calculate values asynchronously
    fun getUsers(): LiveData<Resource<List<User>>> {
        return liveData(Dispatchers.IO) {
            emit(Resource.success(mainRepository.getUsers().items))
        }
    }

    //using viewModelScope
    fun getUsers2() = users
}
package com.vuonghung.androidbase.ui.main.viewmodel

import androidx.lifecycle.*
import com.vuonghung.androidbase.data.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val mainRepository: MainRepository) : ViewModel(){
    val listUsers = mainRepository.getUsers()
}
package com.vuonghung.daggerhilt.di.module

import com.vuonghung.daggerhilt.BuildConfig
import com.vuonghung.daggerhilt.data.api.ApiHelper
import com.vuonghung.daggerhilt.data.api.ApiHelperImpl
import com.vuonghung.daggerhilt.data.api.ApiService
import com.vuonghung.daggerhilt.data.repository.MainRepository
import com.vuonghung.daggerhilt.ui.base.ViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {
    @Provides
    fun providesBaseUrl() = BuildConfig.BASE_URL

    @Provides
    fun providesOkHttpClient() = OkHttpClient.Builder().build()

    @Provides
    @Singleton
    fun providesRetrofit(okHttpClient: OkHttpClient, BASE_URL: String) =
        Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .build()

    @Provides
    @Singleton
    fun providesRepository(apiHelper: ApiHelperImpl) = MainRepository(apiHelper)

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit) = retrofit.create(ApiService::class.java)

    @Provides
    @Singleton
    fun provideApiHelper(apiHelper: ApiHelperImpl): ApiHelper = apiHelper

    @Provides
    @Singleton
    fun providesViewModelFactory(apiHelper: ApiHelperImpl) = ViewModelFactory(apiHelper)

}
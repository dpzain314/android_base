package com.vuonghung.daggerhilt.di

import com.vuonghung.daggerhilt.data.api.ApiHelper
import com.vuonghung.daggerhilt.data.api.ApiService
import com.vuonghung.daggerhilt.data.repository.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object MainModule {
    @Provides
    fun provideBaseUrl() = "https://607e4fe902a23c0017e8b20a.mockapi.io/base_app/"

    @Provides
    fun provideOkHttp() = OkHttpClient.Builder().build()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, BASE_URL: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build() //Doesn't require the adapter
    }

    @Provides
    @Singleton
    fun provideRepository(apiHelper: ApiHelper): MainRepository = MainRepository(apiHelper)


    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

}
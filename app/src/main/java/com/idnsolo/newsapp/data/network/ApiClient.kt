package com.idnsolo.newsapp.data.network

import okhttp3.OkHttpClient
import okhttp3.OkHttpClient.Builder
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {

    fun provideApiservice(): ApiService {
        val okHttpClient = Builder()
            .addInterceptor{
                val newRequest = it.request().newBuilder()
                    .addHeader("X-Api-Key","0af09c3f63fd46a4bd8688f9be75e777")
                    .build()
                it.proceed(newRequest)
            }
            .readTimeout(10,TimeUnit.SECONDS)
            .retryOnConnectionFailure(false)
            .build()

        return Retrofit.Builder()
            .baseUrl("https://newsapi.org")
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}
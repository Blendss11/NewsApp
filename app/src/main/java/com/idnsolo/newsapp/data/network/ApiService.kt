package com.idnsolo.newsapp.data.network

import com.idnsolo.newsapp.data.NewsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import java.security.CodeSource

interface ApiService {
    @GET("/v2/everything")
    fun getCommonNews(
        @Query("q") q: String = "islam",
        @Query("language") language: String = "en",
        @Query("pageSize") pageSize: Int = 50,
        @Query("sortBy") sortBy: String = "popularity",
    ):Call<NewsResponse>

    @GET("/v2/everything")

    fun getAlQuranNews(
        @Query("q") q: String = "Al-Quran",
        @Query("language") language: String = "en"
    ): Call<NewsResponse>

    @GET("/v2/top-headlines")
    fun getAlJazeeraNews(
        @Query("sources") source: String = "al-jazeera-english"
    ): Call<NewsResponse>

    @GET("/v2/everything")
    fun getWarningforMuslimNews(
        @Query("q") q: String = "anti islam",
        @Query("language") language: String = "en"
    ): Call<NewsResponse>

    @GET("/v2/everything")
    fun getSeachNews(
        @Query("q") q: String,
        @Query("pagesize") pageSize: Int = 19
    ): Call<NewsResponse>

}
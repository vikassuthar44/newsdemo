package com.vikas.newsdemo.data

import com.vikas.newsdemo.BuildConfig
import com.vikas.newsdemo.data.model.NewsResponse
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET

interface RepoService {

    companion object {
        const val COUNTRY_CODE = "in"
    }

    @GET("v2/top-headlines?country=${COUNTRY_CODE}&apiKey=${BuildConfig.API_key}")
    fun getNewsDetails(): Single<Response<NewsResponse>>

}
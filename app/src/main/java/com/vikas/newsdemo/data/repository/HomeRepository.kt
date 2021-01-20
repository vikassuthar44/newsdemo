package com.vikas.newsdemo.data.repository

import com.vikas.newsdemo.data.model.NewsResponse
import io.reactivex.Single
import retrofit2.Response

interface HomeRepository {

    fun getNewsDetails(): Single<Response<NewsResponse>>

}
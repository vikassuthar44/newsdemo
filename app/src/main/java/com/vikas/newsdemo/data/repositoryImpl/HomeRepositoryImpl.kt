package com.vikas.newsdemo.data.repositoryImpl

import com.vikas.newsdemo.data.RepoService
import com.vikas.newsdemo.data.model.NewsResponse
import com.vikas.newsdemo.data.repository.HomeRepository
import io.reactivex.Single
import retrofit2.Response

class HomeRepositoryImpl(
    private val repoService: RepoService
) : HomeRepository {

    override fun getNewsDetails(): Single<Response<NewsResponse>> = repoService.getNewsDetails()

}
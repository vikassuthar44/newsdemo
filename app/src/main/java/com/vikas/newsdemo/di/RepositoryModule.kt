package com.vikas.newsdemo.di


import com.vikas.newsdemo.data.RepoService
import com.vikas.newsdemo.data.repository.HomeRepository
import com.vikas.newsdemo.data.repositoryImpl.HomeRepositoryImpl
import dagger.Module
import dagger.Provides


@Module
class RepositoryModule {

    @Provides
    fun provideHomeRepo( repoService: RepoService): HomeRepository = HomeRepositoryImpl(repoService)

}
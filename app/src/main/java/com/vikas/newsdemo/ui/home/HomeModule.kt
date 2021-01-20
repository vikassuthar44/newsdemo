package com.vikas.newsdemo.ui.home

import com.vikas.newsdemo.data.model.NewsResponse
import com.vikas.newsdemo.di.scope.ActivityScoped
import com.vikas.newsdemo.ui.home.adapter.HomeNewsListAdapter
import dagger.Module
import dagger.Provides

/**
 *<h1>HomeModule</h1>
 *<p>dagger module class</p>
 * @author : Vikas
 * @since : 02 Nov 2020
 * @version : 1.0
 */
@Module
class HomeModule {

    @ActivityScoped
    @Provides
    fun provideNewsList() = ArrayList<NewsResponse.Article>()

    @ActivityScoped
    @Provides
    fun provideNewsAdapter(newsList:ArrayList<NewsResponse.Article>)=HomeNewsListAdapter(newsList)

}
package com.vikas.newsdemo.di


import com.vikas.newsdemo.ui.home.HomeActivity
import com.vikas.newsdemo.di.scope.ActivityScoped
import com.vikas.newsdemo.ui.articleDetail.ArticleDetailActivity
import com.vikas.newsdemo.ui.home.HomeModule
import com.vikas.newsdemo.ui.splash.SplashActivity

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(
    includes = [ViewModelModule::class]
)
abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector
    abstract fun splashActivity(): SplashActivity

    @ActivityScoped
    @ContributesAndroidInjector(modules = [HomeModule::class])
    abstract fun homeActivity(): HomeActivity

    @ActivityScoped
    @ContributesAndroidInjector
    abstract fun articleDetailActivity(): ArticleDetailActivity

}
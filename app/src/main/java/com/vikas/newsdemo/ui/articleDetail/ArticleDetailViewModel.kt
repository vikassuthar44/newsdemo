package com.vikas.newsdemo.ui.articleDetail

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.ViewModel
import javax.inject.Inject

/**
 *<h1>ArticleDetailViewModel</h1>
 * @author : Vikas
 * @since : 02 Nov 2020
 * @version : 1.0
 */
class ArticleDetailViewModel @Inject constructor() : ViewModel() {

    val loading = ObservableBoolean(true)
}
package com.vikas.newsdemo.ui.articleDetail

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.webkit.*
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.vikas.newsdemo.R
import com.vikas.newsdemo.common.Constants
import com.vikas.newsdemo.data.model.NewsResponse
import com.vikas.newsdemo.databinding.ActivityArticleDetailBinding
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject


/**
 *<h1>ArticleDetailActivity</h1>
 * @author : Vikas
 * @since : 02 Nov 2020
 * @version : 1.0
 */
class ArticleDetailActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: ArticleDetailViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(ArticleDetailViewModel::class.java)
    }
    private lateinit var mBinding: ActivityArticleDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_article_detail)
        mBinding.viewModel = viewModel
        parsePassedData()
    }

    /**
     * <h2>parsePassedData</h2>
     * method to get data from previous activity
     */
    private fun parsePassedData() {
        val data = intent.getSerializableExtra(Constants.ARTICLE_DETAILS)
        mBinding.data = data as NewsResponse.Article?
        initWebView(data)
    }

    /**
     * <h2>initWebView</h2>
     * <P>Enable javaScript  and webViewClientto webView.
     * showing progress while web view loading
     * </P>
     */
    @SuppressLint("SetJavaScriptEnabled")
    private fun initWebView(data: NewsResponse.Article?) {
        mBinding.webView.settings.javaScriptEnabled = true
        mBinding.webView.settings.builtInZoomControls = true
        mBinding.webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                viewModel.loading.set(true)
                view.loadUrl(url)
                return true
            }

            override fun onPageFinished(view: WebView, url: String) {
                viewModel.loading.set(false)
            }
        }
        data?.url?.let { mBinding.webView.loadUrl(it) }
    }
}
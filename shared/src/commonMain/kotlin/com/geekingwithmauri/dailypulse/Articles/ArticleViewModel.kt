package com.geekingwithmauri.dailypulse.Articles

import com.geekingwithmauri.dailypulse.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ArticleViewModel: BaseViewModel() {
    private val _articleState: MutableStateFlow<ArticleState> = MutableStateFlow(ArticleState())

    val articleState: StateFlow<ArticleState> get() = _articleState
}
package com.geekingwithmauri.dailypulse.Articles

import com.geekingwithmauri.dailypulse.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticleViewModel: BaseViewModel() {
    private val _articleState: MutableStateFlow<ArticleState> = MutableStateFlow(ArticleState())

    val articleState: StateFlow<ArticleState> get() = _articleState

    init {
        getArticles()
    }

    private fun getArticles() {
        scope.launch {
            delay(500)
            _articleState.emit(ArticleState())
        }
    }
}
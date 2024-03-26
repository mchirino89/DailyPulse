package com.geekingwithmauri.dailypulse.Articles

import com.geekingwithmauri.dailypulse.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticleViewModel: BaseViewModel() {
    private val _articleState: MutableStateFlow<ArticleState> = MutableStateFlow(
        ArticleState(loading = true)
    )

    val articleState: StateFlow<ArticleState> get() = _articleState

    init {
        getArticles()
    }

    private fun getArticles() {
        scope.launch {
            val fetchedArticles = fetchArticles()
            delay(500)
            _articleState.emit(ArticleState(articles = fetchedArticles))
        }
    }

    suspend fun fetchArticles(): List<Article> = mockArticle

    private val mockArticle = listOf(
        Article(
            title = "Title 1",
            description = "Description 1",
            date = "2021-09-01",
            imageUrl = "https://picsum.photos/200/300"
        ),
        Article(
            title = "Title 2",
            description = "Description 2",
            date = "2021-09-02",
            imageUrl = "https://picsum.photos/200/300"
        ),
        Article(
            title = "Title 3",
            description = "Description 3",
            date = "2021-09-03",
            imageUrl = "https://picsum.photos/200/300"
        )
    )
}
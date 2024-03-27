package com.geekingwithmauri.dailypulse.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.geekingwithmauri.dailypulse.Articles.ArticleViewModel
import com.geekingwithmauri.dailypulse.Platform
import com.geekingwithmauri.dailypulse.android.screens.AboutScreen
import com.geekingwithmauri.dailypulse.android.screens.ArticleScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val articleViewModel: ArticleViewModel by viewModels()

        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArticleScreen(articlesViewModel = articleViewModel)
                }
            }
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        AboutScreen()
    }
}

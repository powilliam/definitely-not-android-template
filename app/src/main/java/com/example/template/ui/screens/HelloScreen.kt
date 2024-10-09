package com.example.template.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.template.data.entities.Post
import com.example.template.ui.theming.MainTheme
import com.example.template.ui.viewmodel.HelloUiState
import kotlinx.serialization.Serializable

@Serializable
object Hello

@Composable
fun HelloScreen(uiState: HelloUiState = HelloUiState()) {
    Scaffold { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            items(uiState.posts, key = { it.id }) { post ->
                Text(text = post.body)
            }
        }
    }
}

@Preview
@Composable
private fun HelloScreenPreview() {
    val context = LocalContext.current
    val posts = listOf(
        Post(id = 1, title = "Hello World", body = "Hello World")
    )

    MainTheme({ context }) {
        HelloScreen(uiState = HelloUiState(posts = posts))
    }
}